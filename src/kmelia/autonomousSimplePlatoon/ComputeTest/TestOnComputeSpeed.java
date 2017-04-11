package kmelia.autonomousSimplePlatoon.ComputeTest;

import static org.junit.Assert.*;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver_pos;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle;

import org.junit.Test;

import costo.kml2java.framework.IProvidedService;

public class TestOnComputeSpeed {

	//FIXME Trouver quoi donner au 
	@Test
	public void testComputeSpeed() throws InterruptedException{
		//Initialisation
		PlatoonSystemMock2 sys = new PlatoonSystemMock2();
		sys.init();
		Thread.sleep(50);
		SimpleVehicle midVeh = sys.mid;
		SimpleVehicle lastVeh = sys.last;
		SimpleDriver driv = sys.driver;
		//Récupération des services
		IProvidedService servCom = midVeh.getProvidedService("computeSpeed");
		IProvidedService servPos = midVeh.getProvidedService("pos");
		IProvidedService servSpeed = midVeh.getProvidedService("speed");
		IProvidedService servPos2 = lastVeh.getProvidedService("pos");
		IProvidedService servSpeed2 = lastVeh.getProvidedService("speed");
		IProvidedService servSafeDist = midVeh.getProvidedService("giveSafeDistance");
		IProvidedService servDPos = driv.getProvidedService("pos");
		IProvidedService servDSpeed = driv.getProvidedService("speed");
		//Tableau d'entier
		Object[] tab = new Object[7];
		//Tableau recevant les return des services
		Object[] rcvresult;	
		
		//Position mid
		servPos.callService("_pos", "pos",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, servPos);
		rcvresult=servPos.receiveServiceReturn("_pos","pos",new Class<?>[]{Integer.class},servPos);
		tab[0]= rcvresult[0];
		//Speed mid
		servSpeed.callService("_speed", "speed",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, servSpeed);
		rcvresult=servSpeed.receiveServiceReturn("_speed","speed",new Class<?>[]{Integer.class},servSpeed);
		tab[1] =rcvresult[0];
		
		//Position last
		servPos2.callService("_pos", "pos",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, servPos2);
		rcvresult=servPos2.receiveServiceReturn("_pos","pos",new Class<?>[]{Integer.class},servPos);
		tab[2]= rcvresult[0];
		//Speed last
		servSpeed2.callService("_speed", "speed",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, servSpeed2);
		rcvresult=servSpeed2.receiveServiceReturn("_speed","speed",new Class<?>[]{Integer.class},servSpeed);
		tab[3] =rcvresult[0];
		
		//SafeDistance
		servSafeDist.callService("_giveSafeDistance", "giveSafeDistance",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, servSafeDist);
		rcvresult=servSafeDist.receiveServiceReturn("_giveSafeDistance","giveSafeDistance",new Class<?>[]{Integer.class},servSafeDist);
		tab[4] =rcvresult[0];
		
		// Position driver
		servDPos.callService("_pos", "pos",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")},servDPos);
		rcvresult=servDPos.receiveServiceReturn("_pos","pos",new Class<?>[]{Integer.class},servDPos);
		tab[5] =rcvresult[0];
		//Speed Driver
		servDSpeed.callService("_speed", "speed",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")},servDSpeed);
		rcvresult=servDSpeed.receiveServiceReturn("_speed","speed",new Class<?>[]{Integer.class},servDSpeed);
		tab[6] =rcvresult[0];
		
		//ComputeSpeed
		//servCom.callService("_computeSpeed", "computeSpeed",new Object[]{mylib.PlatoonTestlibMap.getData("pilotpos"),mylib.PlatoonTestlibMap.getData("lastpos"),mylib.PlatoonTestlibMap.getData("safeDistance"),mylib.PlatoonTestlibMap.getData("vspeed"),mylib.PlatoonTestlibMap.getData("pilotspeed"),mylib.PlatoonTestlibMap.getData("oracledata") }, servCom);
		servCom.callService("_computeSpeed", "computeSpeed",tab, servCom);
		System.out.println("Hello");
		rcvresult=servCom.receiveServiceReturn("_computeSpeed","computeSpeed",new Class<?>[]{Integer.class},servCom);
		
		//System.out.println("First element : "+ rcvresult[0]);
		System.out.println("Hello 2");
		//int res = (Integer) rcvresult[0];
		
		
	}
}
