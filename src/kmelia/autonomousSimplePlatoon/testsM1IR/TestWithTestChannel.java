package kmelia.autonomousSimplePlatoon.testsM1IR;

import static org.junit.Assert.*;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver_pos;

import org.junit.Test;

import costo.kml2java.framework.channels.Channel;
import costo.kml2java.framework.config.ExecutionParameters;
import costo.kml2java.framework.exceptions.ServiceException;

public class TestWithTestChannel {

	/**
	 * 
	 * @throws InterruptedException 
	 * @throws ServiceException 
	 */
	@Test
	public void testWithChannel() throws InterruptedException, ServiceException{
		//Initialisation
		PlatoonSystemMock2 sys = new PlatoonSystemMock2();
		sys.init();
		Thread.sleep(50);
		
		SimpleDriver  driv = sys.driver;
		// R�cup�ration services
		SimpleDriver_pos posForTest = (SimpleDriver_pos) driv.getProvidedService("pos");
		
		//Cr�ation new channel 
		
		TestChannel myChan = new TestChannel("myChan_", null, posForTest);
		posForTest.assignChannel(myChan);
		
		//Start le service
		posForTest.start();
		//Temps d'attente
		Thread.sleep(100);
		
		int res1 = (Integer) myChan.getResult();
		 // On a configur� � 70 dans la classe PlatoonSystemMock2
		assertEquals(res1, 70);
		//stop() soul�ve une erreur -> l'ignor�e
		//posForTest.stop();
		//On test si le channel suit le changement de config
		driv.setConfig("conf",100);
		driv.init();
		posForTest.start();
		Thread.sleep(100);

		res1= (Integer) myChan.getResult();
		assertEquals(res1, 100);
	}
	/**
	 * Comparaison entre le mock chan et le channel de base
	 * @throws InterruptedException
	 * @throws ServiceException
	 */
	@Test
	public void testComparaison() throws InterruptedException, ServiceException{
		//Initialisation
		ExecutionParameters.pause=2;
		PlatoonSystemMock2 sys = new PlatoonSystemMock2();
		sys.init();
		Thread.sleep(50);
		
		SimpleDriver  driv = sys.driver;
		// R�cup�ration services
		SimpleDriver_pos posForTest = (SimpleDriver_pos) driv.getProvidedService("pos");
		
		//Cr�ation new channel 
		
		TestChannel myChan = new TestChannel("myChan_", null, posForTest);
		posForTest.assignChannel(myChan);
		
		//Start le service
		posForTest.start();
		//Temps d'attente
		Thread.sleep(100);
		
		int res1 = (Integer) myChan.getResult();
		
		//stop() soul�ve une erreur -> l'ignor�e
		//posForTest.stop();
		// Test avec le channel de base
		posForTest.callService("_pos", "pos",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, posForTest);
		Object[] rcvresult=posForTest.receiveServiceReturn("_pos","pos",new Class<?>[]{Integer.class},posForTest);
		int res2 = (Integer) rcvresult[0];
		
		//Comparaison
		assertEquals(res1, res2);
	}
}
