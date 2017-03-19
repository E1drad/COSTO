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

public class SimpleVehicle_runLTS extends ExecutableLTS {

private SimpleVehicle_run service;

public void setService(SimpleVehicle_run theservice){
this.service=theservice;
}

public ProvidedService getService(){
return this.service;
}


public void init(){
this.initialState="vri1";
this.currentState=initialState;
this.outGoing.put("vri1", createArrayListFrom(  "vri1___return___1" ));


this.outGoing.put("vrfinal", createArrayListFrom( ));
this.finalStates.add("vrfinal");

this.outGoing.put("applyspeed1", createArrayListFrom(  "applyspeed1___applyspeed2___8" ));


this.outGoing.put("applyspeed2", createArrayListFrom(  "applyspeed2___displaypos___9" ));


this.outGoing.put("return", createArrayListFrom(  "return___checkSD0___2" ));


this.outGoing.put("computespeed", createArrayListFrom(  "computespeed___applyspeed1___7" ));


this.outGoing.put("displaypos", createArrayListFrom(  "displaypos___checkgoal0___10" ));


this.outGoing.put("checkgoal1", createArrayListFrom(  "checkgoal1___vrfinal___5" , "checkgoal1___computespeed___6" ));


this.outGoing.put("checkSD0", createArrayListFrom(  "checkSD0___checkgoal1___3" ));


this.outGoing.put("checkgoal0", createArrayListFrom(  "checkgoal0___checkgoal1___4" ));


transitionLabels.put("vri1___return___1","display(\"Vehicle \" + vname + \" starts\")");
transitionLabels.put("return___checkSD0___2","SENDRESULT");
transitionLabels.put("checkSD0___checkgoal1___3","safeDist := !!safeDistance");
transitionLabels.put("checkgoal0___checkgoal1___4","goalreached := !!isgoalreached(lastpos)");
transitionLabels.put("checkgoal1___vrfinal___5","[goalreached]display(\"Vehicle \" + vname + \" arrived\")");
transitionLabels.put("checkgoal1___computespeed___6","[not goalreached]display(\"Vehicle \" + vname + \"getting info\")");
transitionLabels.put("computespeed___applyspeed1___7","newspeed := !!computeSpeed(safeDist)");
transitionLabels.put("applyspeed1___applyspeed2___8","!!applySpeed(newspeed)");
transitionLabels.put("applyspeed2___displaypos___9","??applySpeed");
transitionLabels.put("displaypos___checkgoal0___10","display(\"Vehicle \" + vname + \" new speed applied pos: \" + lastpos + \" speed:\" + vspeed)");

transitionCommunications.put("return___checkSD0___2",new SimpleCommunication("run",null,"__CALLER",32));
transitionCommunications.put("checkSD0___checkgoal1___3",new SimpleCommunication("safeDistance",null,"_safeDistance",1));
transitionCommunications.put("checkgoal0___checkgoal1___4",new SimpleCommunication("isgoalreached",null,"_isgoalreached",1));


transitionCommunications.put("computespeed___applyspeed1___7",new SimpleCommunication("computeSpeed",null,"_computeSpeed",1));
transitionCommunications.put("applyspeed1___applyspeed2___8",new SimpleCommunication("applySpeed",null,"_applySpeed",1));
transitionCommunications.put("applyspeed2___displaypos___9",new SimpleCommunication("applySpeed",null,"_applySpeed",4));

 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("vri1___return___1".equals(transition)) return this.service.guard_vri1___return___1();
if ("return___checkSD0___2".equals(transition)) return this.service.guard_return___checkSD0___2();
if ("checkSD0___checkgoal1___3".equals(transition)) return this.service.guard_checkSD0___checkgoal1___3();
if ("checkgoal0___checkgoal1___4".equals(transition)) return this.service.guard_checkgoal0___checkgoal1___4();
if ("checkgoal1___vrfinal___5".equals(transition)) return this.service.guard_checkgoal1___vrfinal___5();
if ("checkgoal1___computespeed___6".equals(transition)) return this.service.guard_checkgoal1___computespeed___6();
if ("computespeed___applyspeed1___7".equals(transition)) return this.service.guard_computespeed___applyspeed1___7();
if ("applyspeed1___applyspeed2___8".equals(transition)) return this.service.guard_applyspeed1___applyspeed2___8();
if ("applyspeed2___displaypos___9".equals(transition)) return this.service.guard_applyspeed2___displaypos___9();
if ("displaypos___checkgoal0___10".equals(transition)) return this.service.guard_displaypos___checkgoal0___10();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("vri1___return___1".equals(transition))  {this.service.vri1___return___1();return;}
if ("return___checkSD0___2".equals(transition))  {this.service.return___checkSD0___2();return;}
if ("checkSD0___checkgoal1___3".equals(transition))  {this.service.checkSD0___checkgoal1___3();return;}
if ("checkgoal0___checkgoal1___4".equals(transition))  {this.service.checkgoal0___checkgoal1___4();return;}
if ("checkgoal1___vrfinal___5".equals(transition))  {this.service.checkgoal1___vrfinal___5();return;}
if ("checkgoal1___computespeed___6".equals(transition))  {this.service.checkgoal1___computespeed___6();return;}
if ("computespeed___applyspeed1___7".equals(transition))  {this.service.computespeed___applyspeed1___7();return;}
if ("applyspeed1___applyspeed2___8".equals(transition))  {this.service.applyspeed1___applyspeed2___8();return;}
if ("applyspeed2___displaypos___9".equals(transition))  {this.service.applyspeed2___displaypos___9();return;}
if ("displaypos___checkgoal0___10".equals(transition))  {this.service.displaypos___checkgoal0___10();return;}
}	




}