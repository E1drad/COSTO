package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import costo.kml2java.framework.*;
import costo.kml2java.framework.test.*;
import costo.kml2java.framework.kmllibs.*;
import costo.kml2java.framework.channels.*;
import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.*;

 
import static kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.PLATOONLIB.*;
import static kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.PLATOONTESTLIB.*;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */
public class APPLICATION_PlatoonSystem_TA1{

 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlatoonSystem_TA1 comp = new PlatoonSystem_TA1("run",null);
	
		comp.addServiceListener(new ServiceEvolutionValidator());
		comp.init();
		
	}

}