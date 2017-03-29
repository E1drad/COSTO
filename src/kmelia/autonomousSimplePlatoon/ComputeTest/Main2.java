package kmelia.autonomousSimplePlatoon.ComputeTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.security.AllPermission;

import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle;


import costo.kml2java.framework.ExecutableComponent;

public class Main2 extends ExecutableComponent {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		PlatoonSystemMock2 mockSystem = new PlatoonSystemMock2();
		
		/*System.out.println("name of mockSystem = "+mockSystem.getName());
		
		mockSystem.setName("newName");
		System.out.println("name expected is 'newName', and the name is : "+mockSystem.getName());
		
		mockSystem.getMid().setConfig("conf","mid",75,55);
		mockSystem.getLast().setConfig("conf","last",80,15);
		
		//mockSystem.getMid().init();
		//mockSystem.getLast().init();
		Field[] fields = mockSystem.getClass().getFields();
		for (Field f : fields) {
			f.setAccessible(true); 
		}
		SimpleVehicle vehic = new SimpleVehicle();
		//on récupère tous les fields qu'on set accessible
		Field[] fields2 = vehic.getClass().getFields();
		for (Field f : fields2) {
			f.setAccessible(true);
		}
		
		
		mockSystem.setAutorunEnabled(true);
		mockSystem.init();
		//mockSystem.start();
		Thread.sleep(2000);
		System.out.println("test config = " +mockSystem.getMid().getLastpos());
		
		mockSystem.getMid().setConfig("conf","mid",30,20);
		mockSystem.getMid().init();
		
		mockSystem.setmid(mockSystem.getLast());
		System.out.println("test config = " +mockSystem.getMid().getLastpos());
		*/
		
		
		
		

	}

}
