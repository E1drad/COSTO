package kmelia.autonomousSimplePlatoon.ComputeTest;

import java.lang.Thread.State;

import costo.kml2java.framework.AssemblyContext;
import costo.kml2java.framework.ExecutableComponent;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle;

public class PlatoonSystemMock2 extends ExecutableComponent{

	// SUB Components
	SimpleDriver driver  ;
	public SimpleDriver getDriver(){ return this.driver;}
	public void setdriver(SimpleDriver comp){ this.driver=comp;}
	SimpleVehicle mid  ;
	public SimpleVehicle getMid(){ return this.mid;}
	public void setmid(SimpleVehicle comp){ this.mid=comp;}
	SimpleVehicle last  ;
	public SimpleVehicle getLast(){ return this.last;}
	public void setlast(SimpleVehicle comp){this.last=comp;}
	AssemblyContext aContext;
	State state;
	
	// Init subcomponents
	public PlatoonSystemMock2() {
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
}
