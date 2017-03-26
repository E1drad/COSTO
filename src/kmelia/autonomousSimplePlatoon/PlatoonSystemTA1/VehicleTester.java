package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import costo.kml2java.framework.ExecutableComponent;
import costo.kml2java.framework.ExecutionContext;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */
public class VehicleTester extends ExecutableComponent {


public VehicleTester(String name, ExecutionContext owner, String id){
super(name, owner, id);
}


public VehicleTester(String name, ExecutionContext owner){
super(name, owner);
}

public VehicleTester(){
super();
}

// Component state
Boolean verdict    ; ;
public Boolean getVerdict(){ return this.verdict;}



// constants


// delegatesandcalculatedvar


// SUB Components

// Promoted variables
// method for invariant


@Override
public void createServices(){
this.name="VehicleTester";
VehicleTester_computeSpeed aVehicleTester_computeSpeed = new VehicleTester_computeSpeed();
aVehicleTester_computeSpeed.setOwner(this);
aVehicleTester_computeSpeed.setName("computeSpeed");
this.requiredservices.put("computeSpeed", aVehicleTester_computeSpeed);
//aVehicleTester_computeSpeed.init();
VehicleTester_testcase1 aVehicleTester_testcase1 = new VehicleTester_testcase1();
aVehicleTester_testcase1.setOwner(this);
aVehicleTester_testcase1.setName("testcase1");
this.providedservices.put("testcase1", aVehicleTester_testcase1);
//aVehicleTester_testcase1.init();
//initServices();
}

@Override
public void resolvePromotedServices(){
// TODO : forall promoted, set their origin ...
// du genre prompted.setOrigin(c1.getService("machin")
}

@Override
public void initState(){
this.autorun="testcase1";
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
if (!(o instanceof VehicleTester)) return false;
VehicleTester other=(VehicleTester)o;
if (!other.verdict.equals(this.verdict)) return false;
return true;
}


@Override
public String toString(){
StringBuffer result=new StringBuffer("VehicleTester: [");
result.append("verdict");
result.append(":");
result.append(verdict);

result.append("]");
return result.toString();
}


}