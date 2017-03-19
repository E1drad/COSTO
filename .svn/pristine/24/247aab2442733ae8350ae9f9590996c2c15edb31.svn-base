package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
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

public class DoubleIntegerMock_confLTS extends ExecutableLTS {

private DoubleIntegerMock_conf service;

public void setService(DoubleIntegerMock_conf theservice){
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

this.outGoing.put("s1", createArrayListFrom(  "s1___f___2" ));


this.outGoing.put("i", createArrayListFrom(  "i___s1___1" ));


transitionLabels.put("i___s1___1","dataname1 := dname1");
transitionLabels.put("s1___f___2","dataname2 := dname2");


 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("i___s1___1".equals(transition)) return this.service.guard_i___s1___1();
if ("s1___f___2".equals(transition)) return this.service.guard_s1___f___2();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("i___s1___1".equals(transition))  {this.service.i___s1___1();return;}
if ("s1___f___2".equals(transition))  {this.service.s1___f___2();return;}
}	




}