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

public class VehicleTester_testcase1LTS extends ExecutableLTS {

private VehicleTester_testcase1 service;

public void setService(VehicleTester_testcase1 theservice){
this.service=theservice;
}

public ProvidedService getService(){
return this.service;
}


public void init(){
this.initialState="s0";
this.currentState=initialState;
this.outGoing.put("s0", createArrayListFrom(  "s0___s1___1" ));


this.outGoing.put("s2", createArrayListFrom(  "s2___s3___3" ));


this.outGoing.put("s1", createArrayListFrom(  "s1___s2___2" ));


this.outGoing.put("s3", createArrayListFrom(  "s3___s4___4" ));


this.outGoing.put("s4", createArrayListFrom( ));
this.finalStates.add("s4");

transitionLabels.put("s0___s1___1","computespeedresult := !!computeSpeed(getData(\"safeDistance\"))");
transitionLabels.put("s1___s2___2","verdict := (computespeedresult = getData(\"oracledata\"))");
transitionLabels.put("s2___s3___3","assertT(verdict)");
transitionLabels.put("s3___s4___4","SENDRESULT");
transitionCommunications.put("s0___s1___1",new SimpleCommunication("computeSpeed",null,"_computeSpeed",1));


transitionCommunications.put("s3___s4___4",new SimpleCommunication("testcase1",null,"__CALLER",32));
 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("s0___s1___1".equals(transition)) return this.service.guard_s0___s1___1();
if ("s1___s2___2".equals(transition)) return this.service.guard_s1___s2___2();
if ("s2___s3___3".equals(transition)) return this.service.guard_s2___s3___3();
if ("s3___s4___4".equals(transition)) return this.service.guard_s3___s4___4();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("s0___s1___1".equals(transition))  {this.service.s0___s1___1();return;}
if ("s1___s2___2".equals(transition))  {this.service.s1___s2___2();return;}
if ("s2___s3___3".equals(transition))  {this.service.s2___s3___3();return;}
if ("s3___s4___4".equals(transition))  {this.service.s3___s4___4();return;}
}	




}