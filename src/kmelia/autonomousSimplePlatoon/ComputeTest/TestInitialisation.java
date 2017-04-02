package kmelia.autonomousSimplePlatoon.ComputeTest;

import static org.junit.Assert.*;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;

import org.junit.Test;

import costo.kml2java.framework.IProvidedService;
import costo.kml2java.framework.channels.Channel;
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
	public void testService() throws InterruptedException{
		PlatoonSystemMock2 sys = new PlatoonSystemMock2();
		sys.init();
		Thread.sleep(100);
		SimpleDriver driv = sys.driver; 
		IProvidedService serv = driv.getProvidedService("pos");
		Channel chan = new Channel("my chan", serv, serv);
		
		serv.assignChannel(chan);
		serv.callService("_pos", "pos",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")}, serv);
		Object[] rcvresult=serv.receiveServiceReturn("_pos","pos",new Class<?>[]{Integer.class},serv);
		int res = (Integer) rcvresult[0];

		System.out.println("res = "+res);
		
	}

}
