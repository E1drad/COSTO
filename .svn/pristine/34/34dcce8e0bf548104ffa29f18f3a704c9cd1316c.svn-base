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
public class SimpleDriver extends ExecutableComponent {


public SimpleDriver(String name, ExecutionContext owner, String id){
super(name, owner, id);
}


public SimpleDriver(String name, ExecutionContext owner){
super(name, owner);
}

public SimpleDriver(){
super();
}

// Component state
Integer goal    ; ;
public Integer getGoal(){ return this.goal;}



// constants


// delegatesandcalculatedvar


// SUB Components

// Promoted variables
// method for invariant


@Override
public void createServices(){
this.name="SimpleDriver";
SimpleDriver_giveSafeDistance aSimpleDriver_giveSafeDistance = new SimpleDriver_giveSafeDistance();
aSimpleDriver_giveSafeDistance.setOwner(this);
aSimpleDriver_giveSafeDistance.setName("giveSafeDistance");
this.providedservices.put("giveSafeDistance", aSimpleDriver_giveSafeDistance);
//aSimpleDriver_giveSafeDistance.init();
SimpleDriver_speed aSimpleDriver_speed = new SimpleDriver_speed();
aSimpleDriver_speed.setOwner(this);
aSimpleDriver_speed.setName("speed");
this.providedservices.put("speed", aSimpleDriver_speed);
//aSimpleDriver_speed.init();
SimpleDriver_conf aSimpleDriver_conf = new SimpleDriver_conf();
aSimpleDriver_conf.setOwner(this);
aSimpleDriver_conf.setName("conf");
this.providedservices.put("conf", aSimpleDriver_conf);
//aSimpleDriver_conf.init();
SimpleDriver_goalreached aSimpleDriver_goalreached = new SimpleDriver_goalreached();
aSimpleDriver_goalreached.setOwner(this);
aSimpleDriver_goalreached.setName("goalreached");
this.providedservices.put("goalreached", aSimpleDriver_goalreached);
//aSimpleDriver_goalreached.init();
SimpleDriver_pos aSimpleDriver_pos = new SimpleDriver_pos();
aSimpleDriver_pos.setOwner(this);
aSimpleDriver_pos.setName("pos");
this.providedservices.put("pos", aSimpleDriver_pos);
//aSimpleDriver_pos.init();
//initServices();
}

@Override
public void resolvePromotedServices(){
// TODO : forall promoted, set their origin ...
// du genre prompted.setOrigin(c1.getService("machin")
}

@Override
public void initState(){
this.autorun="";
goal = 0;
}

@Override
public void initSubComponents(){

// Init subcomponents


}

@Override
public void initBindings(){
}

@Override
public boolean equals(Object o){
if (!(o instanceof SimpleDriver)) return false;
SimpleDriver other=(SimpleDriver)o;
if (!other.goal.equals(this.goal)) return false;
return true;
}


@Override
public String toString(){
StringBuffer result=new StringBuffer("SimpleDriver: [");
result.append("goal");
result.append(":");
result.append(goal);

result.append("]");
return result.toString();
}


}