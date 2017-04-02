package kmelia.autonomousSimplePlatoon.ComputeTest;

import java.lang.Thread.State;

import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver;
import kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleVehicle;
import costo.kml2java.framework.AssemblyContext;
import costo.kml2java.framework.ExecutableComponent;

public class PlatoonSystemMock3 extends ExecutableComponent{

	// SUB Components
		MockDriver driver  ;
		public MockDriver getDriver(){ return this.driver;}
		public void MockDriver(MockDriver comp){ this.driver=comp;}
		SimpleVehicle mid  ;
		public SimpleVehicle getMid(){ return this.mid;}
		public void setmid(SimpleVehicle comp){ this.mid=comp;}
		SimpleVehicle last  ;
		public SimpleVehicle getLast(){ return this.last;}
		public void setlast(SimpleVehicle comp){this.last=comp;}
		AssemblyContext aContext;
		State state;
		
		// Init subcomponents
		public PlatoonSystemMock3() {
			driver = new MockDriver("SimpleDriver", innerContext,"driver");
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
