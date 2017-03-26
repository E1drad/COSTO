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

public class SimpleDriver_goalreachedLTS extends ExecutableLTS {

private SimpleDriver_goalreached service;

public void setService(SimpleDriver_goalreached theservice){
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

this.outGoing.put("e2", createArrayListFrom(  "e2___f___3" ));


this.outGoing.put("i2", createArrayListFrom(  "i2___e2___2" ));


this.outGoing.put("i", createArrayListFrom(  "i___i2___1" ));


transitionLabels.put("i___i2___1","msg(\" driver goalreached \" + followerpos)");
transitionLabels.put("i2___e2___2","ok := (goal - followerpos <= idealDistance)");
transitionLabels.put("e2___f___3","SENDRESULT(ok)");


transitionCommunications.put("e2___f___3",new SimpleCommunication("goalreached",null,"__CALLER",32));
 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("i___i2___1".equals(transition)) return this.service.guard_i___i2___1();
if ("i2___e2___2".equals(transition)) return this.service.guard_i2___e2___2();
if ("e2___f___3".equals(transition)) return this.service.guard_e2___f___3();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("i___i2___1".equals(transition))  {this.service.i___i2___1();return;}
if ("i2___e2___2".equals(transition))  {this.service.i2___e2___2();return;}
if ("e2___f___3".equals(transition))  {this.service.e2___f___3();return;}
}	




}