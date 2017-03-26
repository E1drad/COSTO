package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import costo.kml2java.framework.ExecutableComponent;
import costo.kml2java.framework.ExecutionContext;
import costo.kml2java.framework.channels.AssemblyBinding;
import costo.kml2java.framework.test.ServiceEvolutionValidator;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */
public class PlatoonSystem_TA1 extends ExecutableComponent {


public PlatoonSystem_TA1(String name, ExecutionContext owner, String id){
super(name, owner, id);
}


public PlatoonSystem_TA1(String name, ExecutionContext owner){
super(name, owner);
}

public PlatoonSystem_TA1(){
super();
}

// Component state
Integer vs    ; ;
public Integer getVs(){ return this.vs;}
Integer vp    ; ;
public Integer getVp(){ return this.vp;}



// constants


// delegatesandcalculatedvar


// SUB Components
DoubleIntegerMock drivermock  ;
public DoubleIntegerMock getDrivermock(){ return this.drivermock;}
public void setdrivermock(DoubleIntegerMock comp){ this.drivermock=comp;}
SimpleVehicle mid  ;
public SimpleVehicle getMid(){ return this.mid;}
public void setmid(SimpleVehicle comp){ this.mid=comp;}
VehicleTester tc  ;
public VehicleTester getTc(){ return this.tc;}
public void settc(VehicleTester comp){ this.tc=comp;}

// Promoted variables
// method for invariant


@Override
public void createServices(){
this.name="PlatoonSystem_TA1";
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
vs = mylib.PlatoonTestlibMap.getData("vspeed");
vp = mylib.PlatoonTestlibMap.getData("lastpos");
}

@Override
public void initSubComponents(){

// Init subcomponents
drivermock = new DoubleIntegerMock("DoubleIntegerMock", innerContext,"drivermock");
this.innerContext.addInstance("drivermock",drivermock);



mid = new SimpleVehicle("SimpleVehicle", innerContext,"mid");
this.innerContext.addInstance("mid",mid);



tc = new VehicleTester("VehicleTester", innerContext,"tc");
this.innerContext.addInstance("tc",tc);



this.innerContext.setOwner(this);

mid.setConfig("conf","mid",getVp(),getVs());

drivermock.setConfig("conf","pilotspeed","pilotpos");


}

@Override
public void initBindings(){
this.innerContext.addBinding( new AssemblyBinding("tccomputeSpeed",
innerContext, "tc", "mid", "computeSpeed", "computeSpeed"));
this.innerContext.addBinding( new AssemblyBinding("midpilotspeed",
innerContext, "mid", "drivermock", "pilotspeed", "intdata1"));
this.innerContext.addBinding( new AssemblyBinding("midpilotpos",
innerContext, "mid", "drivermock", "pilotpos", "intdata2"));
}

@Override
public boolean equals(Object o){
if (!(o instanceof PlatoonSystem_TA1)) return false;
PlatoonSystem_TA1 other=(PlatoonSystem_TA1)o;
if (!other.vs.equals(this.vs)) return false;
if (!other.vp.equals(this.vp)) return false;
return true;
}


@Override
public String toString(){
StringBuffer result=new StringBuffer("PlatoonSystem_TA1: [");
result.append("vs");
result.append(":");
result.append(vs);
result.append(", ");
result.append("vp");
result.append(":");
result.append(vp);

result.append("]");
return result.toString();
}

 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlatoonSystem_TA1 comp = new PlatoonSystem_TA1("run",null);
	
		comp.addServiceListener(new ServiceEvolutionValidator());
		comp.init();
		
	}

}