package kmelia.autonomousSimplePlatoon.ComputeTest;

import java.util.HashMap;
import java.util.Map;

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
	private Object[] callparams;
	private Map<String,Object[]> mockvalues;
	
	
	
	public void setCallparams(Object... callparams) {
		this.callparams = callparams;
	}
	
	/**
	 * 
	 * @param callname name of the required service to mock
	 * @param values results to be returned by the mocked service
	 */
public void addMockValue(String callname, Object...values){
	mockvalues.put(callname, values);
	
}
	public Object getResult() {
		return result;
	}

	public TestChannel(String name, IService client, IService server) {
		super(name, client, server);
		mockvalues= new HashMap<>();
	}
	
	public void clearMockValue(){
		mockvalues.clear();
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
		System.out.println("the service "+message+" returns "+ params[0]);
		result=params[0]; 
	}
	

	@Override
	public Object[] receiveServiceCall(String channel, String message, Class<?>[] paramtypes, IService orig) {
	
		return this.callparams;
	}

	@Override
	public Object[] receiveServiceReturn(String channel, String message, Class<?>[] paramtypes, IService orig) {
		
		
		//System.err.println("the service wants a Service return for "+channel+message +" , using a mock "+mockvalues.get(message)[0]);
		// the following ack  is needed to unlock the service
		orig.ack(this, 0);
		return mockvalues.get(message);
	}
	@Override
	public void close(IService source) {
		// Overriding to NOP because this channel is one-ended
	}
	@Override
	public void cut(IService source) {
		// Overriding to NOP because this channel is one-ended
	}


}
