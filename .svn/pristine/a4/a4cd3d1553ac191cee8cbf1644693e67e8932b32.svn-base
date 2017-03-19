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
public class PlatoonSystem extends ExecutableComponent {


public PlatoonSystem(String name, ExecutionContext owner, String id){
super(name, owner, id);
}


public PlatoonSystem(String name, ExecutionContext owner){
super(name, owner);
}

public PlatoonSystem(){
super();
}

// Component state



// constants


// delegatesandcalculatedvar


// SUB Components
SimpleDriver driver  ;
public SimpleDriver getDriver(){ return this.driver;}
public void setdriver(SimpleDriver comp){ this.driver=comp;}
SimpleVehicle mid  ;
public SimpleVehicle getMid(){ return this.mid;}
public void setmid(SimpleVehicle comp){ this.mid=comp;}
SimpleVehicle last  ;
public SimpleVehicle getLast(){ return this.last;}
public void setlast(SimpleVehicle comp){ this.last=comp;}

// Promoted variables
// method for invariant


@Override
public void createServices(){
this.name="PlatoonSystem";
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
}

@Override
public void initSubComponents(){

// Init subcomponents
driver = new SimpleDriver("SimpleDriver", innerContext,"driver");
this.innerContext.addInstance("driver",driver);



mid = new SimpleVehicle("SimpleVehicle", innerContext,"mid");
this.innerContext.addInstance("mid",mid);



last = new SimpleVehicle("SimpleVehicle", innerContext,"last");
this.innerContext.addInstance("last",last);



this.innerContext.setOwner(this);

driver.setConfig("conf",70);

mid.setConfig("conf","mid",48,0);

last.setConfig("conf","last",25,0);


}

@Override
public void initBindings(){
this.innerContext.addBinding( new AssemblyBinding("lastsafeDistance",
innerContext, "last", "mid", "safeDistance", "giveSafeDistance"));
this.innerContext.addBinding( new AssemblyBinding("lastpilotpos",
innerContext, "last", "mid", "pilotpos", "pos"));
this.innerContext.addBinding( new AssemblyBinding("midsafeDistance",
innerContext, "mid", "driver", "safeDistance", "giveSafeDistance"));
this.innerContext.addBinding( new AssemblyBinding("midisgoalreached",
innerContext, "mid", "driver", "isgoalreached", "goalreached"));
this.innerContext.addBinding( new AssemblyBinding("midpilotspeed",
innerContext, "mid", "driver", "pilotspeed", "speed"));
this.innerContext.addBinding( new AssemblyBinding("midpilotpos",
innerContext, "mid", "driver", "pilotpos", "pos"));
this.innerContext.addBinding( new AssemblyBinding("lastpilotspeed",
innerContext, "last", "mid", "pilotspeed", "speed"));
this.innerContext.addBinding( new AssemblyBinding("lastisgoalreached",
innerContext, "last", "mid", "isgoalreached", "goalreached"));
}

@Override
public boolean equals(Object o){
if (!(o instanceof PlatoonSystem)) return false;
PlatoonSystem other=(PlatoonSystem)o;
return true;
}


@Override
public String toString(){
StringBuffer result=new StringBuffer("PlatoonSystem: [");
result.append("]");
return result.toString();
}

 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlatoonSystem comp = new PlatoonSystem("run",null);
	
		comp.addServiceListener(new ServiceEvolutionValidator());
		comp.init();
		
	}

}