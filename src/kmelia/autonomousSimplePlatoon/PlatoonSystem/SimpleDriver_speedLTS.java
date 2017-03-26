package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import costo.kml2java.framework.ExecutableLTS;
import costo.kml2java.framework.ProvidedService;
import costo.kml2java.framework.channels.SimpleCommunication;

/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */

public class SimpleDriver_speedLTS extends ExecutableLTS {

private SimpleDriver_speed service;

public void setService(SimpleDriver_speed theservice){
this.service=theservice;
}

public ProvidedService getService(){
return this.service;
}


public void init(){
this.initialState="i";
this.currentState=initialState;
this.outGoing.put("f", createArrayListFrom( ));
this.finalStates.add("f");

this.outGoing.put("i", createArrayListFrom(  "i___f___1" ));


transitionLabels.put("i___f___1","SENDRESULT(40)");
transitionCommunications.put("i___f___1",new SimpleCommunication("speed",null,"__CALLER",32));
 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("i___f___1".equals(transition)) return this.service.guard_i___f___1();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("i___f___1".equals(transition))  {this.service.i___f___1();return;}
}	




}