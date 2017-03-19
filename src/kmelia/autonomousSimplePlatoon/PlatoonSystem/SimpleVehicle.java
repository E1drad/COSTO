package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import costo.kml2java.framework.*;
import costo.kml2java.framework.test.*;
import costo.kml2java.framework.kmllibs.*;
import costo.kml2java.framework.channels.*;
import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.*;

 
import static kmelia.autonomousSimplePlatoon.PlatoonSystem.PLATOONLIB.*;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */
public class SimpleVehicle extends ExecutableComponent {


public SimpleVehicle(String name, ExecutionContext owner, String id){
super(name, owner, id);
}


public SimpleVehicle(String name, ExecutionContext owner){
super(name, owner);
}

public SimpleVehicle(){
super();
}

// Component state
Integer vspeed    ; ;
public Integer getVspeed(){ return this.vspeed;}
Integer lastpos    ; ;
public Integer getLastpos(){ return this.lastpos;}
String vname = new String()   ; ;
public String getVname(){ return this.vname;}
Boolean goalreached    ; ;
public Boolean getGoalreached(){ return this.goalreached;}



// constants


// delegatesandcalculatedvar


// SUB Components

// Promoted variables
// method for invariant


@Override
public void createServices(){
this.name="SimpleVehicle";
SimpleVehicle_pilotpos aSimpleVehicle_pilotpos = new SimpleVehicle_pilotpos();
aSimpleVehicle_pilotpos.setOwner(this);
aSimpleVehicle_pilotpos.setName("pilotpos");
this.requiredservices.put("pilotpos", aSimpleVehicle_pilotpos);
//aSimpleVehicle_pilotpos.init();
SimpleVehicle_pilotspeed aSimpleVehicle_pilotspeed = new SimpleVehicle_pilotspeed();
aSimpleVehicle_pilotspeed.setOwner(this);
aSimpleVehicle_pilotspeed.setName("pilotspeed");
this.requiredservices.put("pilotspeed", aSimpleVehicle_pilotspeed);
//aSimpleVehicle_pilotspeed.init();
SimpleVehicle_giveSafeDistance aSimpleVehicle_giveSafeDistance = new SimpleVehicle_giveSafeDistance();
aSimpleVehicle_giveSafeDistance.setOwner(this);
aSimpleVehicle_giveSafeDistance.setName("giveSafeDistance");
this.providedservices.put("giveSafeDistance", aSimpleVehicle_giveSafeDistance);
//aSimpleVehicle_giveSafeDistance.init();
SimpleVehicle_speed aSimpleVehicle_speed = new SimpleVehicle_speed();
aSimpleVehicle_speed.setOwner(this);
aSimpleVehicle_speed.setName("speed");
this.providedservices.put("speed", aSimpleVehicle_speed);
//aSimpleVehicle_speed.init();
SimpleVehicle_applySpeed aSimpleVehicle_applySpeed = new SimpleVehicle_applySpeed();
aSimpleVehicle_applySpeed.setOwner(this);
aSimpleVehicle_applySpeed.setName("applySpeed");
this.providedservices.put("applySpeed", aSimpleVehicle_applySpeed);
//aSimpleVehicle_applySpeed.init();
SimpleVehicle_safeDistance aSimpleVehicle_safeDistance = new SimpleVehicle_safeDistance();
aSimpleVehicle_safeDistance.setOwner(this);
aSimpleVehicle_safeDistance.setName("safeDistance");
this.requiredservices.put("safeDistance", aSimpleVehicle_safeDistance);
//aSimpleVehicle_safeDistance.init();
SimpleVehicle_computeSpeed aSimpleVehicle_computeSpeed = new SimpleVehicle_computeSpeed();
aSimpleVehicle_computeSpeed.setOwner(this);
aSimpleVehicle_computeSpeed.setName("computeSpeed");
this.providedservices.put("computeSpeed", aSimpleVehicle_computeSpeed);
//aSimpleVehicle_computeSpeed.init();
SimpleVehicle_conf aSimpleVehicle_conf = new SimpleVehicle_conf();
aSimpleVehicle_conf.setOwner(this);
aSimpleVehicle_conf.setName("conf");
this.providedservices.put("conf", aSimpleVehicle_conf);
//aSimpleVehicle_conf.init();
SimpleVehicle_run aSimpleVehicle_run = new SimpleVehicle_run();
aSimpleVehicle_run.setOwner(this);
aSimpleVehicle_run.setName("run");
this.providedservices.put("run", aSimpleVehicle_run);
//aSimpleVehicle_run.init();
SimpleVehicle_isgoalreached aSimpleVehicle_isgoalreached = new SimpleVehicle_isgoalreached();
aSimpleVehicle_isgoalreached.setOwner(this);
aSimpleVehicle_isgoalreached.setName("isgoalreached");
this.requiredservices.put("isgoalreached", aSimpleVehicle_isgoalreached);
//aSimpleVehicle_isgoalreached.init();
SimpleVehicle_goalreached aSimpleVehicle_goalreached = new SimpleVehicle_goalreached();
aSimpleVehicle_goalreached.setOwner(this);
aSimpleVehicle_goalreached.setName("goalreached");
this.providedservices.put("goalreached", aSimpleVehicle_goalreached);
//aSimpleVehicle_goalreached.init();
SimpleVehicle_pos aSimpleVehicle_pos = new SimpleVehicle_pos();
aSimpleVehicle_pos.setOwner(this);
aSimpleVehicle_pos.setName("pos");
this.providedservices.put("pos", aSimpleVehicle_pos);
//aSimpleVehicle_pos.init();
//initServices();
}

@Override
public void resolvePromotedServices(){
// TODO : forall promoted, set their origin ...
// du genre prompted.setOrigin(c1.getService("machin")
}

@Override
public void initState(){
this.autorun="run";
vspeed = 0;
lastpos = 0;
vname = "Anonymous";
goalreached = false;
}

@Override
public void initSubComponents(){

// Init subcomponents


}

@Override
public void initBindings(){
}
//
 Boolean bornedInv(){
Boolean resultA;
resultA=0 <= getVspeed() && getVspeed() <= maxSpeed;
this.assertStatus("bornedInv()",resultA.toString());
return resultA;
}
//
public  Boolean isObsInvariantSatisfied(){
Boolean resultA=true;
return resultA;
}
//
public  Boolean isNonObsInvariantSatisfied(){
Boolean resultA=true;
resultA &=bornedInv();
return resultA;
}

@Override
public boolean equals(Object o){
if (!(o instanceof SimpleVehicle)) return false;
SimpleVehicle other=(SimpleVehicle)o;
if (!other.vspeed.equals(this.vspeed)) return false;
if (!other.lastpos.equals(this.lastpos)) return false;
if (!other.vname.equals(this.vname)) return false;
if (!other.goalreached.equals(this.goalreached)) return false;
return true;
}


@Override
public String toString(){
StringBuffer result=new StringBuffer("SimpleVehicle: [");
result.append("vspeed");
result.append(":");
result.append(vspeed);
result.append(", ");
result.append("lastpos");
result.append(":");
result.append(lastpos);
result.append(", ");
result.append("vname");
result.append(":");
result.append(vname);
result.append(", ");
result.append("goalreached");
result.append(":");
result.append(goalreached);

result.append("]");
return result.toString();
}


}