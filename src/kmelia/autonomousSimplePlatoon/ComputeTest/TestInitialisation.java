package kmelia.autonomousSimplePlatoon.ComputeTest;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver_pos;

import org.junit.Test;

import costo.kml2java.framework.ExecutableComponent;
import costo.kml2java.framework.IProvidedService;
import costo.kml2java.framework.IRequiredService;
import costo.kml2java.framework.channels.Channel;
import costo.kml2java.framework.channels.ExecutionBinding;
import costo.kml2java.framework.channels.IChannel;

public class TestInitialisation {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testInitialisation() throws InterruptedException{
		
		PlatoonSystemMock2 sys = new PlatoonSystemMock2();
		sys.init();
		Thread.sleep(100);
		/*System.out.println(sys.driver.getIdJFK());
		System.out.println(sys.driver.getName());
		System.out.println(sys.driver.getSleepTime());
		System.out.println(sys.driver.getGoal());
		*/
		assertEquals("driver", sys.driver.getIdJFK());
		assertEquals("SimpleDriver",sys.driver.getName());
		assertEquals(500, sys.driver.getSleepTime());
		assertEquals(70, (int)sys.driver.getGoal());
		
		sys.driver.setName("anotherName");
		
		assertEquals("anotherName",sys.driver.getName());

		sys.driver.setConfig("conf",100);
		assertEquals(70, (int)sys.driver.getGoal());
		sys.driver.init();
		Thread.sleep(100);
		assertEquals(100, (int)sys.driver.getGoal());
		sys.driver.setIdJFK("newDriver");
		assertEquals("newDriver", sys.driver.getIdJFK());
		sys.driver.setSleepTime(510);
		assertEquals(510, sys.driver.getSleepTime());

	}
	
	@Test
	public void testServicePos() throws InterruptedException{
		PlatoonSystemMock2 sys = new PlatoonSystemMock2();
		sys.init();
		Thread.sleep(100);
		SimpleDriver driv = sys.driver; 
		ExecutionBinding binder = new ExecutionBinding("binder", sys.getInnerContext(), null, null, null, null) {
			
			@Override
			protected Channel createServicesandChannel(String newChanName,
					String kindofchannel, ExecutableComponent clientComponent,
					IRequiredService clientService) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		IProvidedService serv = driv.getProvidedService("pos");
		Channel chan = new Channel("_myChan",binder , serv, serv);
		
		SimpleDriver_pos aSimpleDriver_pos = new SimpleDriver_pos();
		aSimpleDriver_pos.setOwner(driv);
		aSimpleDriver_pos.setName("myChan");
	
		serv.assignChannel(chan);
		driv.initBindings();
		driv.init();
		sys.init();
		serv.callService("_pos", "pos",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, serv);
		Object[] rcvresult=serv.receiveServiceReturn("_pos","pos",new Class<?>[]{Integer.class},serv);
		
		/*serv.callService("_myChan", "myChan",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, serv);
		Object[] rcvresult=serv.receiveServiceReturn("_myChan","myChan",new Class<?>[]{Integer.class},serv);*/
		int res = (Integer) rcvresult[0];
		
		

		System.out.println("res = "+res);
		
	}
	@Test
	public void testServiceGoal() throws InterruptedException {
		PlatoonSystemMock2 sys = new PlatoonSystemMock2();
		sys.init();
		Thread.sleep(100);
		SimpleDriver driv = sys.driver; 
		IProvidedService serv = driv.getProvidedService("pos");
		Channel chan = new Channel("my chan", serv, serv);
		
		serv.assignChannel(chan);
		serv.callService("_goalreached", "goalreached",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, serv);
		Object[] rcvresult=serv.receiveServiceReturn("_goalreached","goalreached",new Class<?>[]{Integer.class},serv);
		
		/*serv.callService("pos", "pos",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, serv);
		Object[] rcvresult=serv.receiveServiceReturn("chan","pos",new Class<?>[]{Integer.class},serv);*/
		Object res = rcvresult[0];
		
		

		System.out.println("res = "+res);
	}
}
