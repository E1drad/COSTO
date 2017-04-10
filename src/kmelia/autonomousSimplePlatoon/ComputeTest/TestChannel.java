package kmelia.autonomousSimplePlatoon.ComputeTest;

import costo.kml2java.framework.IService;
import costo.kml2java.framework.channels.Channel;
import costo.kml2java.framework.exceptions.KmlCommunicationException;
/**
 * Clase mock chanel fournis par Gilles Ardourel
 * 
 *
 */
public class TestChannel extends Channel{
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
