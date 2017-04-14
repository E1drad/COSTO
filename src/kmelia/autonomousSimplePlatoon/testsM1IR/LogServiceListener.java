package kmelia.autonomousSimplePlatoon.testsM1IR;

import costo.kml2java.framework.IService;
import costo.kml2java.framework.IServiceEvolutionListener;
import costo.kml2java.framework.channels.IChannel;

public class LogServiceListener implements IServiceEvolutionListener {
	@Override
	public void transitionFired(String tname, String currentState, IService serv, String log, Exception ex) {
	 System.out.println("###TRANS "+ tname+ " :"+log);
		
	}

	@Override
	public void serviceError(IService serv, IChannel source, String message) {
		 System.out.println("###ERR "+ serv.getName()+ " :" +message);
		
	}

	
}
