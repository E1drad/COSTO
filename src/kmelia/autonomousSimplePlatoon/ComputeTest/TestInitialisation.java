package kmelia.autonomousSimplePlatoon.ComputeTest;

import static org.junit.Assert.*;

import org.junit.Test;

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
	
	}

}
