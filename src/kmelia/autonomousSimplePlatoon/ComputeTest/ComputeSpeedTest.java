package kmelia.autonomousSimplePlatoon.ComputeTest;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.ReflectPermission;
import java.security.AccessController;

import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle_pos;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle_safeDistance;

import org.junit.Test;

import costo.kml2java.framework.test.ServiceEvolutionValidator;

public class ComputeSpeedTest {
	
	@Test
	public void nameSettingTest(){
		SimpleVehicle vehic = new SimpleVehicle();
		
		vehic.setName("voiture test");
		assertEquals("voiture test", vehic.getName());
		
	}
	
	@Test
	public void posSettingTest(){
		
		
		//required services for simple vehicle: 
		//pilotpos,pilotspeed, isgoalreached, safeDistance
		
		//SimpleVehicle mockVehic = mock(SimpleVehicle.class);
		//SimpleDriver mockDriver = mock(SimpleDriver.class);
		//PlatoonSystem_TA1 plat = mock(PlatoonSystem_TA1.class);
		//SimpleVehicle_pilotpos mockPos = mock(SimpleVehicle_pilotpos.class);
		
		/*
		 * //exemples of use of mockito
		 
		LinkedList mockedList = mock(LinkedList.class);
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		System.out.println(mockedList.get(0));
		System.out.println(mockedList.get(1));
		System.out.println(mockedList.get(999));
		verify(mockedList).get(0);
		
		//stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");
		//stubbing using hamcrest (let's say isValid() returns your own hamcrest matcher):
		//when(mockedList.contains(argThat(isValid()))).thenReturn("element");
		//following prints "element"
		System.out.println(mockedList.get(999));
		//you can also verify using an argument matcher
		verify(mockedList).get(anyInt());
		*/
		
		//create a simpleDriver mocked and set its speed to then check that 
		SimpleVehicle vehic = new SimpleVehicle();
		vehic.createServices();
		SimpleVehicle_pos vehicPos = new SimpleVehicle_pos();

		vehicPos.setOwner(vehic);
		vehicPos.setResult(42);
		

		vehic.addServiceListener(new ServiceEvolutionValidator());
		vehic.setConfig("pos", vehicPos);
		vehic.initServices();
		
		
		vehic.createServices();
		
		//SimpleVehicle_safeDistance safeMock = mock(SimpleVehicle_safeDistance.class);
		
		
		
		System.out.println(vehicPos.getResult());
		System.out.println(vehic.getRequiredServices());
		
		
		//SimpleDriver mockDriver = mock(SimpleDriver.class);
		//mockDriver.createServices();
		//System.out.println(mockDriver.getProvidedServices());
		//when(mockDriver.getGoal()).thenReturn(9);
		//System.out.println(mockDriver.getGoal());
		//verify(mockDriver).getGoal();
		//verify(mockDriver).createServices();
		
		
		//SimpleVehicle mockVehic = mock(SimpleVehicle.class);
		//SimpleVehicle mockVehic2 = mock(SimpleVehicle.class);
		
		
		
		

		/*PlatoonSystem comp = new PlatoonSystem("run",null);
	
		comp.addServiceListener(new ServiceEvolutionValidator());
		when(mockDriver.getGoal()).thenReturn(2);
		when(mockVehic.getVname()).thenReturn("car");
		comp.setmid(mockVehic);
		comp.setlast(mockVehic2);
		comp.setdriver(mockDriver);
		System.out.println(mockVehic.getVname());
		System.out.println(mockVehic.getVspeed());
		mockVehic.setConfig("Vspeed", 130);
		System.out.println(mockVehic.getVspeed());
		
		
		verify(mockVehic).getVname();
		*/
		
	}
	
	@Test
	public void reflectTest(){
		ReflectPermission refperm = new ReflectPermission("suppressAccessChecks", "");
		ReflectPermission ref2 = new ReflectPermission("newProxyInPackage");
		AccessController.checkPermission(refperm);
	}
	
}
