package kmelia.autonomousSimplePlatoon.testsM1IR;

import static org.junit.Assert.*;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver_pos;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle_isgoalreached;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle_pilotpos;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle_pilotspeed;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle_safeDistance;

import org.junit.Test;

import costo.kml2java.framework.IProvidedService;
import costo.kml2java.framework.IRequiredService;
import costo.kml2java.framework.exceptions.KmlCommunicationException;
import costo.kml2java.framework.exceptions.ServiceException;

public class TestOnComputeSpeed {
	/**
	 * Test quand le vehicle est suffisament loin du driver.
	 * @throws InterruptedException
	 * @throws KmlCommunicationException
	 * @throws ServiceException
	 */
	@Test
	public void testComputeSpeedOk() throws InterruptedException, KmlCommunicationException, ServiceException{
	
		
		// Creating the component under test
		SimpleVehicle veh = new SimpleVehicle("SimpleVehicle", new TestOuterContext("test"),"last");
		int posValue=10;
		
		veh.setConfig("conf","last",posValue,0);
		veh.init();
		
	
		// getting the service under test 
		IProvidedService provServToTest = veh.getProvidedService("computeSpeed");
	
		// uncomment the following to log every transition
	//	provServToTest.addServiceListener(new LogServiceListener());
		
		//Create and assign fake test channel to the service and its required services
		TestChannel testChan = new TestChannel("TESTCHANN",null,provServToTest);
		provServToTest.assignChannel(testChan);
		veh.getRequiredService("pilotpos").setReqChannel(testChan);
		veh.getRequiredService("pilotspeed").setReqChannel(testChan);
		
		// assigning call parameters for the Service under test and mock values for its required services
		testChan.setCallparams(120);// safeDistance
		testChan.addMockValue("pilotpos", 420);
		testChan.addMockValue("pilotspeed", 40);

	
	   // starting the service 
		provServToTest.start();
	    // waiting for the lts to reach its final state
		Thread.sleep(1000); // Demande un temps de sleep important
		
	// stop the service
		// FIXME : Error: closing requirements of SimpleVehicle::computeSpeed while not finished
		provServToTest.stop(testChan);
		
		//tests, asserts
		System.out.println(testChan.getResult());
		assertEquals(true,(Integer)testChan.getResult()>0);
		
		
	}
	
	
	/**
	 * Test quand le vehicle est trop proche du driver
	 * @throws InterruptedException
	 * @throws KmlCommunicationException
	 * @throws ServiceException
	 */
	@Test
	public void testComputeSpeedTropProche() throws InterruptedException, KmlCommunicationException, ServiceException{
	
		
		// Creating the component under test
		SimpleVehicle veh = new SimpleVehicle("SimpleVehicle", new TestOuterContext("test"),"last");
		int posValue=10;
		
		veh.setConfig("conf","last",posValue,0);
		veh.init();
		
	
		// getting the service under test 
		IProvidedService provServToTest = veh.getProvidedService("computeSpeed");
	
		// uncomment the following to log every transition
	//	provServToTest.addServiceListener(new LogServiceListener());
		
		//Create and assign fake test channel to the service and its required services
		TestChannel testChan = new TestChannel("TESTCHANN",null,provServToTest);
		provServToTest.assignChannel(testChan);
		veh.getRequiredService("pilotpos").setReqChannel(testChan);
		veh.getRequiredService("pilotspeed").setReqChannel(testChan);
		
		// assigning call parameters for the Service under test and mock values for its required services
		testChan.setCallparams(120); // safeDistance
		testChan.addMockValue("pilotpos", 40);
		testChan.addMockValue("pilotspeed", 40);

	
	   // starting the service 
		provServToTest.start();
	    // waiting for the lts to reach its final state
		Thread.sleep(1000); // Demande un temps de sleep important
		
	// stop the service
		// FIXME : Error: closing requirements of SimpleVehicle::computeSpeed while not finished
		provServToTest.stop(testChan);
		
		//tests, asserts
		System.out.println(testChan.getResult());
		assertEquals(true,(Integer)testChan.getResult()==0);
		
		
	}
	
	/**
	 * Test quand le vehicle est devant le driver
	 * @throws InterruptedException
	 * @throws KmlCommunicationException
	 * @throws ServiceException
	 */
	@Test
	public void testComputeSpeedDevantDriver() throws InterruptedException, KmlCommunicationException, ServiceException{
	
		
		// Creating the component under test
		SimpleVehicle veh = new SimpleVehicle("SimpleVehicle", new TestOuterContext("test"),"last");
		int posValue=100;
		
		veh.setConfig("conf","last",posValue,0);
		veh.init();
		
	
		// getting the service under test 
		IProvidedService provServToTest = veh.getProvidedService("computeSpeed");
	
		// uncomment the following to log every transition
	//	provServToTest.addServiceListener(new LogServiceListener());
		
		//Create and assign fake test channel to the service and its required services
		TestChannel testChan = new TestChannel("TESTCHANN",null,provServToTest);
		provServToTest.assignChannel(testChan);
		veh.getRequiredService("pilotpos").setReqChannel(testChan);
		veh.getRequiredService("pilotspeed").setReqChannel(testChan);
		
		// assigning call parameters for the Service under test and mock values for its required services
		testChan.setCallparams(120); // safeDistance
		testChan.addMockValue("pilotpos", 40);
		testChan.addMockValue("pilotspeed", 40);

	
	   // starting the service 
		provServToTest.start();
	    // waiting for the lts to reach its final state
		Thread.sleep(1000); // Demande un temps de sleep important
		
	// stop the service
		// FIXME : Error: closing requirements of SimpleVehicle::computeSpeed while not finished
		provServToTest.stop(testChan);
		
		//tests, asserts
		System.out.println(testChan.getResult());
		assertEquals(true,(Integer)testChan.getResult()==0);
		
		
	}
	
	
	/**
	 * Test quand le driver va tr�s vite. Cela ne doit normalement pas affecter le vehicule
	 * @throws InterruptedException
	 * @throws KmlCommunicationException
	 * @throws ServiceException
	 */
	@Test
	public void testComputeSpeedDriverRapide() throws InterruptedException, KmlCommunicationException, ServiceException{
	
		
		// Creating the component under test
		SimpleVehicle veh = new SimpleVehicle("SimpleVehicle", new TestOuterContext("test"),"last");
		int posValue=10;
		
		veh.setConfig("conf","last",posValue,0);
		veh.init();
		
	
		// getting the service under test 
		IProvidedService provServToTest = veh.getProvidedService("computeSpeed");
	
		// uncomment the following to log every transition
	//	provServToTest.addServiceListener(new LogServiceListener());
		
		//Create and assign fake test channel to the service and its required services
		TestChannel testChan = new TestChannel("TESTCHANN",null,provServToTest);
		provServToTest.assignChannel(testChan);
		veh.getRequiredService("pilotpos").setReqChannel(testChan);
		veh.getRequiredService("pilotspeed").setReqChannel(testChan);
		
		// assigning call parameters for the Service under test and mock values for its required services
		testChan.setCallparams(120); // safeDistance
		testChan.addMockValue("pilotpos", 400);
		testChan.addMockValue("pilotspeed", 4000);

	
	   // starting the service 
		provServToTest.start();
	    // waiting for the lts to reach its final state
		Thread.sleep(1000); // Demande un temps de sleep important
		
	// stop the service
		// FIXME : Error: closing requirements of SimpleVehicle::computeSpeed while not finished
		provServToTest.stop(testChan);
		
		//tests, asserts
		System.out.println(testChan.getResult());
		assertEquals(true,(Integer)testChan.getResult()>0);
		
		
	}
	
	
	/**
	 * Test quand la safe distande est n�gative
	 * @throws InterruptedException
	 * @throws KmlCommunicationException
	 * @throws ServiceException
	 */
	@Test
	public void testComputeSpeedNegativeSafeDistance() throws InterruptedException, KmlCommunicationException, ServiceException{
	
		
		// Creating the component under test
		SimpleVehicle veh = new SimpleVehicle("SimpleVehicle", new TestOuterContext("test"),"last");
		int posValue=10;
		
		veh.setConfig("conf","last",posValue,20);
		veh.init();
		
	
		// getting the service under test 
		IProvidedService provServToTest = veh.getProvidedService("computeSpeed");
	
		// uncomment the following to log every transition
	//	provServToTest.addServiceListener(new LogServiceListener());
		
		//Create and assign fake test channel to the service and its required services
		TestChannel testChan = new TestChannel("TESTCHANN",null,provServToTest);
		provServToTest.assignChannel(testChan);
		veh.getRequiredService("pilotpos").setReqChannel(testChan);
		veh.getRequiredService("pilotspeed").setReqChannel(testChan);
		
		// assigning call parameters for the Service under test and mock values for its required services
		testChan.setCallparams(120); // safeDistance
		testChan.addMockValue("pilotpos", 400);
		testChan.addMockValue("pilotspeed", 4000);

	
	   // starting the service 
		provServToTest.start();
	    // waiting for the lts to reach its final state
		Thread.sleep(1000); // Demande un temps de sleep important
		
	// stop the service
		// FIXME : Error: closing requirements of SimpleVehicle::computeSpeed while not finished
		provServToTest.stop(testChan);
		
		//tests, asserts
		System.out.println(testChan.getResult());
		assertEquals(true,(Integer)testChan.getResult()>0);
		
		
	}
	
	/**
	 * Test quand le vehicule a d�j� une vitesse
	 * @throws InterruptedException
	 * @throws KmlCommunicationException
	 * @throws ServiceException
	 */
	@Test
	public void testComputeSpeedDejaLancer() throws InterruptedException, KmlCommunicationException, ServiceException{
	
		
		// Creating the component under test
		SimpleVehicle veh = new SimpleVehicle("SimpleVehicle", new TestOuterContext("test"),"last");
		int posValue=10;
		
		veh.setConfig("conf","last",posValue,20);
		veh.init();
		
	
		// getting the service under test 
		IProvidedService provServToTest = veh.getProvidedService("computeSpeed");
	
		// uncomment the following to log every transition
	//	provServToTest.addServiceListener(new LogServiceListener());
		
		//Create and assign fake test channel to the service and its required services
		TestChannel testChan = new TestChannel("TESTCHANN",null,provServToTest);
		provServToTest.assignChannel(testChan);
		veh.getRequiredService("pilotpos").setReqChannel(testChan);
		veh.getRequiredService("pilotspeed").setReqChannel(testChan);
		
		// assigning call parameters for the Service under test and mock values for its required services
		testChan.setCallparams(-1); // safeDistance
		testChan.addMockValue("pilotpos", 400);
		testChan.addMockValue("pilotspeed", 4000);

	
	   // starting the service 
		provServToTest.start();
	    // waiting for the lts to reach its final state
		Thread.sleep(1000); // Demande un temps de sleep important
		
	// stop the service
		// FIXME : Error: closing requirements of SimpleVehicle::computeSpeed while not finished
		provServToTest.stop(testChan);
		
		//tests, asserts
		System.out.println(testChan.getResult());
		assertEquals(true,(Integer)testChan.getResult()>0);
		
		
	}
	
	
	
	
	//---------------Premi�re version des tests -> ne marche pas -> trace �crite------------------
	/*
	@Test
	public void testComputeSpeed() throws InterruptedException{
		//Initialisation
		PlatoonSystemMock2 sys = new PlatoonSystemMock2();
		sys.init();
		Thread.sleep(50);
		SimpleVehicle midVeh = sys.mid;
		SimpleVehicle lastVeh = sys.last;
		SimpleDriver driv = sys.driver;
		
		
		//R�cup�ration des services
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
		
		//Test
		
		
		// Cr�ation de mock channel sur les required services
		
		//pilotpos
		SimpleVehicle_pilotpos posPilotTest = (SimpleVehicle_pilotpos) midVeh.getRequiredService("pilotpos");
		
		TestChannel myChanPos = new TestChannel("myChanPos_", null, posPilotTest);
		myChanPos.setFalseResult(50);
		posPilotTest.assignChannel(myChanPos);
	
		//pilotspeed
		SimpleVehicle_pilotspeed speedPilotTest = (SimpleVehicle_pilotspeed) midVeh.getRequiredService("pilotspeed");
		
		TestChannel myChanSpeed = new TestChannel("myChanSpeed_", null, speedPilotTest);
		myChanSpeed.setFalseResult(80);
		speedPilotTest.assignChannel(myChanSpeed);
		
		//safeDistance
		SimpleVehicle_safeDistance safeDistanceTest = (SimpleVehicle_safeDistance) midVeh.getRequiredService("safeDistance");
		
		TestChannel myChanSafeDistance = new TestChannel("myChanSafeDistance_", null, safeDistanceTest);
		myChanSafeDistance.setFalseResult(10);
		safeDistanceTest.assignChannel(myChanSafeDistance);
		
		//isgoalreached
		SimpleVehicle_isgoalreached isGoalRTest = (SimpleVehicle_isgoalreached) midVeh.getRequiredService("isgoalreached");
		
		TestChannel myChanIsGoalR = new TestChannel("myChanmIsGoalR_", null, isGoalRTest);
		myChanIsGoalR.setFalseResult(false);
		isGoalRTest.assignChannel(myChanIsGoalR);
		
		
		//ComputeSpeed
		//servCom.callService("_computeSpeed", "computeSpeed",new Object[]{mylib.PlatoonTestlibMap.getData("pilotpos"),mylib.PlatoonTestlibMap.getData("lastpos"),mylib.PlatoonTestlibMap.getData("safeDistance"),mylib.PlatoonTestlibMap.getData("vspeed"),mylib.PlatoonTestlibMap.getData("pilotspeed"),mylib.PlatoonTestlibMap.getData("oracledata") }, servCom);
		servCom.callService("_computeSpeed", "computeSpeed",tab, servCom);
		System.out.println("Hello");
		rcvresult=servCom.receiveServiceReturn("_computeSpeed","computeSpeed",new Class<?>[]{Integer.class},servCom);
		
		//System.out.println("First element : "+ rcvresult[0]);
		System.out.println("Hello 2");
		//int res = (Integer) rcvresult[0];
		
		
	}*/
}
