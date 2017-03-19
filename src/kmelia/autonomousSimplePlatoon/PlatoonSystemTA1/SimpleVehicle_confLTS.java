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

public class SimpleVehicle_confLTS extends ExecutableLTS {

private SimpleVehicle_conf service;

public void setService(SimpleVehicle_conf theservice){
this.service=theservice;
}

public ProvidedService getService(){
return this.service;
}


public void init(){
this.initialState="initvi";
this.currentState=initialState;
this.outGoing.put("initve1", createArrayListFrom(  "initve1___initve2___2" ));


this.outGoing.put("initve2", createArrayListFrom(  "initve2___initve3___3" ));


this.outGoing.put("initve3", createArrayListFrom(  "initve3___initvf___4" ));


this.outGoing.put("initvf", createArrayListFrom( ));
this.finalStates.add("initvf");

this.outGoing.put("initvi", createArrayListFrom(  "initvi___initve1___1" ));


transitionLabels.put("initvi___initve1___1","lastpos := currentPos");
transitionLabels.put("initve1___initve2___2","vname := pvname");
transitionLabels.put("initve2___initve3___3","vspeed := currentSpeed");
transitionLabels.put("initve3___initvf___4","display(vname + \" is initialised at currentpos: \" + currentPos + \" speed: \" + currentSpeed)");




 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("initvi___initve1___1".equals(transition)) return this.service.guard_initvi___initve1___1();
if ("initve1___initve2___2".equals(transition)) return this.service.guard_initve1___initve2___2();
if ("initve2___initve3___3".equals(transition)) return this.service.guard_initve2___initve3___3();
if ("initve3___initvf___4".equals(transition)) return this.service.guard_initve3___initvf___4();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("initvi___initve1___1".equals(transition))  {this.service.initvi___initve1___1();return;}
if ("initve1___initve2___2".equals(transition))  {this.service.initve1___initve2___2();return;}
if ("initve2___initve3___3".equals(transition))  {this.service.initve2___initve3___3();return;}
if ("initve3___initvf___4".equals(transition))  {this.service.initve3___initvf___4();return;}
}	




}