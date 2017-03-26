package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import costo.kml2java.framework.test.ServiceEvolutionValidator;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */
public class APPLICATION_PlatoonSystem{

 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlatoonSystem comp = new PlatoonSystem("run",null);
	
		comp.addServiceListener(new ServiceEvolutionValidator());
		comp.init();
		
	}

}