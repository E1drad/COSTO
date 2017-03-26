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

public class SimpleVehicle_goalreachedLTS extends ExecutableLTS {

private SimpleVehicle_goalreached service;

public void setService(SimpleVehicle_goalreached theservice){
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

this.outGoing.put("e2", createArrayListFrom(  "e2___f___2" ));


this.outGoing.put("i", createArrayListFrom(  "i___e2___1" ));


transitionLabels.put("i___e2___1","ok := goalreached and (lastpos - followerpos <= idealDistance)");
transitionLabels.put("e2___f___2","SENDRESULT(ok)");

transitionCommunications.put("e2___f___2",new SimpleCommunication("goalreached",null,"__CALLER",32));
 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("i___e2___1".equals(transition)) return this.service.guard_i___e2___1();
if ("e2___f___2".equals(transition)) return this.service.guard_e2___f___2();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("i___e2___1".equals(transition))  {this.service.i___e2___1();return;}
if ("e2___f___2".equals(transition))  {this.service.e2___f___2();return;}
}	




}