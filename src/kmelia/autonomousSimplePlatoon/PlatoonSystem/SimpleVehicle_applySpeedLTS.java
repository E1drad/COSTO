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

public class SimpleVehicle_applySpeedLTS extends ExecutableLTS {

private SimpleVehicle_applySpeed service;

public void setService(SimpleVehicle_applySpeed theservice){
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

this.outGoing.put("e1", createArrayListFrom(  "e1___e2___2" ));


this.outGoing.put("e2", createArrayListFrom(  "e2___f___3" ));


this.outGoing.put("i", createArrayListFrom(  "i___e1___1" ));


transitionLabels.put("i___e1___1","lastpos := lastpos + thespeed");
transitionLabels.put("e1___e2___2","vspeed := thespeed");
transitionLabels.put("e2___f___3","SENDRESULT");


transitionCommunications.put("e2___f___3",new SimpleCommunication("applySpeed",null,"__CALLER",32));
 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("i___e1___1".equals(transition)) return this.service.guard_i___e1___1();
if ("e1___e2___2".equals(transition)) return this.service.guard_e1___e2___2();
if ("e2___f___3".equals(transition)) return this.service.guard_e2___f___3();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("i___e1___1".equals(transition))  {this.service.i___e1___1();return;}
if ("e1___e2___2".equals(transition))  {this.service.e1___e2___2();return;}
if ("e2___f___3".equals(transition))  {this.service.e2___f___3();return;}
}	




}