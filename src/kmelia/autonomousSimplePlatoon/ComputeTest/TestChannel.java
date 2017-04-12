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
	public Object falseResult = -42; // Quand on veut passer une valeur bidon
	public Object getResult() {
		//this.getOwner().closedChannel(this);
		//this.close(this.server);
		
		if ((Integer)falseResult == -42) {
			this.server.stop();	
			return result;
		}else{// Si falseResult alors on passe la valeur bidon
			result = falseResult;
			return result;
		}
		
	}

	public TestChannel(String name, IService client, IService server) {
		super(name, client, server);
		
	}
	
	
	public void setFalseResult(Object value){
		falseResult=value;
	}

	@Override
	public Object[] receiveMessage(String channel, String message, Class<?>[] paramtypes, IService orig) {
		System.err.println(" the Service wants to receive a message, use a mock "+message);
		Object[] obj = {falseResult};
		System.out.println(obj[0]);
		return obj;
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
		Object[] obj = {falseResult};
		System.out.println(obj[0]);
		return obj;
	}

	@Override
	public Object[] receiveServiceReturn(String channel, String message, Class<?>[] paramtypes, IService orig) {
		System.out.println("Hello55");
		//System.err.println("the service wants a Service return for "+channel+message +" , use a mock ");
		Object[] obj = {falseResult};
		System.out.println(obj[0]);
		return obj;
		
	}

}
