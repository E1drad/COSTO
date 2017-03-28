package kmelia.autonomousSimplePlatoon.test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.Mock;
import kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.PlatoonSystem_TA1;
import kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.SimpleVehicle;
import kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.VehicleTester;

import org.junit.Test;

import costo.kml2java.framework.ExecutableComponent.*;
import costo.kml2java.framework.ProvidedService;
import costo.kml2java.framework.test.ServiceEvolutionValidator;

public class TestPlatoonSystem {
	
	@Test
	public void test() throws Throwable {
		PlatoonSystem_TA1 platoonSystem = new PlatoonSystem_TA1("run",null);
		platoonSystem.addServiceListener(new ServiceEvolutionValidator());
		
		Mock drivermock = new Mock("DoubleIntegerMock", platoonSystem.getInnerContext(),"drivermock");
		platoonSystem.setdrivermock(drivermock);
		platoonSystem.getInnerContext().addInstance("drivermock",drivermock);
		
		SimpleVehicle mid = new SimpleVehicle("SimpleVehicle", platoonSystem.getInnerContext(),"mid");
		platoonSystem.setmid(mid);
		platoonSystem.getInnerContext().addInstance("mid",mid);
		
		VehicleTester tc = new VehicleTester("VehicleTester", platoonSystem.getInnerContext(),"tc");
		platoonSystem.settc(tc);
		platoonSystem.getInnerContext().addInstance("tc",tc);
		
		platoonSystem.getInnerContext().setOwner(platoonSystem);
		mid.setConfig("conf","mid",platoonSystem.getVp(),platoonSystem.getVs());
		drivermock.setConfig("conf","pilotspeed","pilotpos");
		
		platoonSystem.initState();// and subcomp
		platoonSystem.initSubComponents();
		platoonSystem.createServices();
		
		Method methodAddListeners;
		Method methodApplyConfig;
		Class c = platoonSystem.getClass().getSuperclass();
        Object requiredObj = platoonSystem;

        methodAddListeners = c.getDeclaredMethod("addListeners", new Class<?>[]{});
        methodAddListeners.setAccessible(true);
        requiredObj = methodAddListeners.invoke(platoonSystem, (Object[])null);
        
        methodApplyConfig = c.getDeclaredMethod("applyConfig", new Class<?>[]{});
        methodApplyConfig.setAccessible(true);
        requiredObj = methodApplyConfig.invoke(platoonSystem, (Object[])null);

		if (platoonSystem.isComposite()) {
			platoonSystem.initBindings();
			platoonSystem.getInnerContext().setPaused(platoonSystem.isPaused());
			platoonSystem.getInnerContext().setAutorunEnabled(platoonSystem.isAutorunEnabled());
			platoonSystem.getInnerContext().init();
		}
		
		platoonSystem.initServices();
		platoonSystem.setState(ComponentState.READY);
		if (platoonSystem.isApplication() && platoonSystem.isAutorunEnabled()) {
			platoonSystem.start();
		}
		
		Integer computespeedresult;
		ProvidedService pservice = (ProvidedService) platoonSystem.getDrivermock().getProvidedService("mockIntData1"); 
		platoonSystem.getDrivermock().getService("_computeSpeed").callService("_computeSpeed","computeSpeed",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, pservice);
		Object[] rcvresult=pservice.receiveServiceReturn("_computeSpeed","computeSpeed",new Class<?>[]{Integer.class},pservice);
		computespeedresult = (Integer) rcvresult[0 ];
		
		
		assertEquals(computespeedresult, Integer.valueOf(80) );
	}
	
}
