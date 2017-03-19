package kmelia.autonomousSimplePlatoon.ComputeTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;

import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle;

public class Main {

	public static void main(String[] args) {
		ReflectPermission refperm = new ReflectPermission("suppressAccessChecks", "");
		SimpleVehicle vehic = new SimpleVehicle();
		Field[] fields = vehic.getClass().getFields();
		int a = fields.length;
		for (Field f : fields) {
			System.out.println(f.getName());
		}
		Method[] methods = vehic.getClass().getMethods();
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
		
	}
}
