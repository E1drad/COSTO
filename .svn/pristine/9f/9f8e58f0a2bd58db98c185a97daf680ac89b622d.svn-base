package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import costo.kml2java.framework.*;
import costo.kml2java.framework.channels.*;
import costo.kml2java.framework.*;
import costo.kml2java.framework.kmllibs.*;

/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */

public class SimpleDriver_confLTS extends ExecutableLTS {

private SimpleDriver_conf service;

public void setService(SimpleDriver_conf theservice){
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


transitionLabels.put("i___f___1","goal := thegoal");

 

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