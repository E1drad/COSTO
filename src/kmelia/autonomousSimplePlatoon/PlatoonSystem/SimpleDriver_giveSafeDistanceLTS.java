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

public class SimpleDriver_giveSafeDistanceLTS extends ExecutableLTS {

private SimpleDriver_giveSafeDistance service;

public void setService(SimpleDriver_giveSafeDistance theservice){
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

this.outGoing.put("i", createArrayListFrom(  "i___i1___1" ));


this.outGoing.put("i1", createArrayListFrom(  "i1___f___2" ));


transitionLabels.put("i___i1___1","msg(\"Driver give safedistance\")");
transitionLabels.put("i1___f___2","SENDRESULT(10)");

transitionCommunications.put("i1___f___2",new SimpleCommunication("giveSafeDistance",null,"__CALLER",32));
 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("i___i1___1".equals(transition)) return this.service.guard_i___i1___1();
if ("i1___f___2".equals(transition)) return this.service.guard_i1___f___2();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("i___i1___1".equals(transition))  {this.service.i___i1___1();return;}
if ("i1___f___2".equals(transition))  {this.service.i1___f___2();return;}
}	




}