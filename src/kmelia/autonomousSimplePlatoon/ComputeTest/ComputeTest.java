package kmelia.autonomousSimplePlatoon.ComputeTest;


import static org.junit.Assert.*;

import costo.kml2java.framework.*;
import costo.kml2java.framework.test.*;
import costo.kml2java.framework.kmllibs.*;
import costo.kml2java.framework.channels.*;
import costo.kml2java.framework.config.ExecutionParameters;
import costo.kml2java.framework.exceptions.KmlCommunicationException;
import costo.kml2java.framework.exceptions.ServiceException;

import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.*;
import static kmelia.autonomousSimplePlatoon.PlatoonSystem.PLATOONLIB.*;


import org.junit.Test;
import org.junit.runner.RunWith;

/*import org.mockito.Mockito;
import org.mockito.exceptions.misusing.UnnecessaryStubbingException;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
*/
import costo.kml2java.framework.test.ServiceEvolutionValidator;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.PlatoonSystem;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver_giveSafeDistance;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle_computeSpeed;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle_pos;
//@RunWith(MockitoJUnitRunner.Silent.class)
public class ComputeTest {

	public static void main(String[] args) throws InterruptedException, KmlCommunicationException, ServiceException {
		//for testing without junit
		new ComputeTest().testComputeSpeed1();
	}
	
	@Test(timeout=10000)
	public void testComputeSpeed1() throws InterruptedException, KmlCommunicationException, ServiceException{
		System.out.println("Welcome to Junit");
		// only 1 service here, no need to be slow
		ExecutionParameters.pause=2;
		
		// Creating the component under test
		SimpleVehicle sv = new SimpleVehicle("SimpleVehicle", null,"last");
		int posValue=48;
		
		sv.setConfig("conf","last",posValue,0);
		sv.init();
		
		
		// getting the service under test 
		SimpleVehicle_pos provServToTest =(SimpleVehicle_pos) sv.getProvidedService("pos");
		
		//Create and assign fake test channel to the service
		TestChannel testChan = new TestChannel("TESTCHANN",null,provServToTest);
		provServToTest.assignChannel(testChan);
		
		//TODO : manage fake required services and channels for testing more complex services 
		
	    // starting the service 
		provServToTest.start();
	    // waiting for the lts to reach its final state
		Thread.sleep(100);
		
		//tests, asserts
		System.out.println(testChan.getResult());
		assertEquals(posValue,testChan.getResult());
	}
	
	
/***
 * 
 * Simple Mock Channel with no threads nor waiting
 * 
 * //FIXME manage parameters, results and mocks. 
 *  
 */
	
private class TestChannel extends Channel{
	private Object result;

	public Object getResult() {
		return result;
	}

	public TestChannel(String name, IService client, IService server) {
		super(name, client, server);
		
	}


	@Override
	public Object[] receiveMessage(String channel, String message, Class<?>[] paramtypes, IService orig) {
		System.err.println(" the Service wants to receive a message, use a mock "+message);
		return null;
	}

	@Override
	public void emitMessage(String channel, String message, Object[] params, IService orig) {
		
		System.out.println(" the Service emits "+message);
	}

	@Override
	public void callService(String channel, String message, Object[] params, IService orig)
			throws KmlCommunicationException {
	
		System.out.println("the service calls another Service"+channel+message);
	}

	@Override
	public void returnService(String channel, String message, Object[] params, IService orig) {
		result=params[0];

	 
	}

	@Override
	public Object[] receiveServiceCall(String channel, String message, Class<?>[] paramtypes, IService orig) {
		//System.out.println("The service received a ServiceCall"+channel+message);
		//FIXME : give the service parameters here if needed
		
		return null;
	}

	@Override
	public Object[] receiveServiceReturn(String channel, String message, Class<?>[] paramtypes, IService orig) {
		
		System.err.println("the service wants a Service return for "+channel+message +" , use a mock ");
		return null;
	}


	
}
	
	
	
	

}

