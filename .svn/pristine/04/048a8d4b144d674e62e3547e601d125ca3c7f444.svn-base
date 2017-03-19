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

public class SimpleVehicle_computeSpeedLTS extends ExecutableLTS {

private SimpleVehicle_computeSpeed service;

public void setService(SimpleVehicle_computeSpeed theservice){
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

this.outGoing.put("e1", createArrayListFrom(  "e1___e2___8" , "e1___e2___9" , "e1___e2___10" ));


this.outGoing.put("calcdist", createArrayListFrom(  "calcdist___e1___7" ));


this.outGoing.put("e2", createArrayListFrom(  "e2___f___11" , "e2___f___12" , "e2___f___13" ));


this.outGoing.put("displayspeed", createArrayListFrom(  "displayspeed___calcdist___6" ));


this.outGoing.put("getppos1", createArrayListFrom(  "getppos1___getppos2___3" ));


this.outGoing.put("getppos2", createArrayListFrom(  "getppos2___getpspeed1___4" ));


this.outGoing.put("getpspeed1", createArrayListFrom(  "getpspeed1___displayspeed___5" ));


this.outGoing.put("i", createArrayListFrom(  "i___displaystate___1" ));


this.outGoing.put("displaystate", createArrayListFrom(  "displaystate___getppos1___2" ));


transitionLabels.put("i___displaystate___1","display(\"computeSpeed called with safeDistance: \" + safeDistance)");
transitionLabels.put("displaystate___getppos1___2","display(\"Vehicle \" + vname + \" has lastpos: \" + lastpos + \" and  vspeed: \" + vspeed)");
transitionLabels.put("getppos1___getppos2___3","ppos := !!pilotpos");
transitionLabels.put("getppos2___getpspeed1___4","display(\"Vehicle \" + vname + \" gets pilotpos\" + ppos)");
transitionLabels.put("getpspeed1___displayspeed___5","pspeed := !!pilotspeed");
transitionLabels.put("displayspeed___calcdist___6","display(\"Vehicle \" + vname + \" gets pilotspeed\" + pspeed)");
transitionLabels.put("calcdist___e1___7","distance := ppos - lastpos");
transitionLabels.put("e1___e2___8","[distance > safeDistance and vspeed <= pspeed]newspeed := vspeed + distanceStep");
transitionLabels.put("e1___e2___9","[distance > safeDistance and vspeed > pspeed]newspeed := vspeed - distanceStep");
transitionLabels.put("e1___e2___10","[distance <= safeDistance]newspeed := 0");
transitionLabels.put("e2___f___11","[newspeed < 0]SENDRESULT(0)");
transitionLabels.put("e2___f___12","[newspeed > maxSpeed]SENDRESULT(maxSpeed)");
transitionLabels.put("e2___f___13","[newspeed <= maxSpeed and newspeed >= 0]SENDRESULT(newspeed)");


transitionCommunications.put("getppos1___getppos2___3",new SimpleCommunication("pilotpos",null,"_pilotpos",1));

transitionCommunications.put("getpspeed1___displayspeed___5",new SimpleCommunication("pilotspeed",null,"_pilotspeed",1));





transitionCommunications.put("e2___f___11",new SimpleCommunication("computeSpeed",null,"__CALLER",32));
transitionCommunications.put("e2___f___12",new SimpleCommunication("computeSpeed",null,"__CALLER",32));
transitionCommunications.put("e2___f___13",new SimpleCommunication("computeSpeed",null,"__CALLER",32));
 

}


public Boolean isGuardSatisfied(String transition) {
if (transition==null) return false;
if ("i___displaystate___1".equals(transition)) return this.service.guard_i___displaystate___1();
if ("displaystate___getppos1___2".equals(transition)) return this.service.guard_displaystate___getppos1___2();
if ("getppos1___getppos2___3".equals(transition)) return this.service.guard_getppos1___getppos2___3();
if ("getppos2___getpspeed1___4".equals(transition)) return this.service.guard_getppos2___getpspeed1___4();
if ("getpspeed1___displayspeed___5".equals(transition)) return this.service.guard_getpspeed1___displayspeed___5();
if ("displayspeed___calcdist___6".equals(transition)) return this.service.guard_displayspeed___calcdist___6();
if ("calcdist___e1___7".equals(transition)) return this.service.guard_calcdist___e1___7();
if ("e1___e2___8".equals(transition)) return this.service.guard_e1___e2___8();
if ("e1___e2___9".equals(transition)) return this.service.guard_e1___e2___9();
if ("e1___e2___10".equals(transition)) return this.service.guard_e1___e2___10();
if ("e2___f___11".equals(transition)) return this.service.guard_e2___f___11();
if ("e2___f___12".equals(transition)) return this.service.guard_e2___f___12();
if ("e2___f___13".equals(transition)) return this.service.guard_e2___f___13();

return true;
	}
	
protected void applyTransition(String transition) {
if (transition==null) return;
if ("i___displaystate___1".equals(transition))  {this.service.i___displaystate___1();return;}
if ("displaystate___getppos1___2".equals(transition))  {this.service.displaystate___getppos1___2();return;}
if ("getppos1___getppos2___3".equals(transition))  {this.service.getppos1___getppos2___3();return;}
if ("getppos2___getpspeed1___4".equals(transition))  {this.service.getppos2___getpspeed1___4();return;}
if ("getpspeed1___displayspeed___5".equals(transition))  {this.service.getpspeed1___displayspeed___5();return;}
if ("displayspeed___calcdist___6".equals(transition))  {this.service.displayspeed___calcdist___6();return;}
if ("calcdist___e1___7".equals(transition))  {this.service.calcdist___e1___7();return;}
if ("e1___e2___8".equals(transition))  {this.service.e1___e2___8();return;}
if ("e1___e2___9".equals(transition))  {this.service.e1___e2___9();return;}
if ("e1___e2___10".equals(transition))  {this.service.e1___e2___10();return;}
if ("e2___f___11".equals(transition))  {this.service.e2___f___11();return;}
if ("e2___f___12".equals(transition))  {this.service.e2___f___12();return;}
if ("e2___f___13".equals(transition))  {this.service.e2___f___13();return;}
}	




}