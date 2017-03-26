package kmelia.autonomousSimplePlatoon.ComputeTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle;
import costo.kml2java.framework.ExecutableComponent;

public class Main {

	public static void main(String[] args) {
		SimpleVehicle vehic = new SimpleVehicle();
		//on récupère tous les fields qu'on set accessible
		Field[] fields = vehic.getClass().getFields();
		for (Field f : fields) {
			f.setAccessible(true);
		}
		
		ExecutableComponent exec = new ExecutableComponent();
		Field[] field2 = exec.getClass().getFields();
		for (Field f2 : fields) {
			f2.setAccessible(true);
		}
		System.out.println("fields of Executable component");
		int a = fields.length;
		for (Field f : field2) {
			System.out.println(f.getName());
		}
		System.out.println("methods of SimpleVehicle");
		Method[] methods = vehic.getClass().getMethods();
		for (Method m : methods) {
			m.setAccessible(true);
		}
		int c = methods.length;
		for (Method m : methods) {
			System.out.println(m.getName());
		}
		System.out.println(c);
		System.out.println(a);
		SimpleDriver driver = new SimpleDriver();
		Field[] fieldsDriver = driver.getClass().getFields();
		int b = fields.length;
		for (Field f : fieldsDriver) {
			System.out.println(f.getName());
		}
		System.out.println(b);
		
		System.out.println("Print des fields PlatoonSystem mock?");
		
		PlatoonSystemMock sys = new PlatoonSystemMock();
		
		Field[] fieldsMock = sys.getClass().getFields();

		for (Field f : fieldsMock) {
			System.out.println(f.getName());
		}
		
		System.out.println("Print des methodes de platoonsystem mock");
		Method[] systemMock = sys.getClass().getMethods();

		for (Method m : systemMock) {
			System.out.println(m.getName());
		}
			
		
		
		
		
	}
}
