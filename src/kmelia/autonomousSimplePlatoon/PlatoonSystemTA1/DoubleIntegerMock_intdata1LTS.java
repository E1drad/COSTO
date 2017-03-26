package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import costo.kml2java.framework.ExecutableLTS;
import costo.kml2java.framework.ProvidedService;
import costo.kml2java.framework.channels.SimpleCommunication;

/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */

public class DoubleIntegerMock_intdata1LTS extends ExecutableLTS {

private DoubleIntegerMock_intdata1 service;

public void setService(DoubleIntegerMock_intdata1 theservice){
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


transitionLabels.put("i___i1___1","count1 := getData(dataname1)");
transitionLabels.put("i1___f___2","SENDRESULT(count1)");

transitionCommunications.put("i1___f___2",new SimpleCommunication("intdata1",null,"__CALLER",32));
 

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