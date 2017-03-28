package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;

import costo.kml2java.framework.ExecutableLTS;
import costo.kml2java.framework.IProvidedService;
import costo.kml2java.framework.ProvidedService;
import costo.kml2java.framework.channels.SimpleCommunication;

public class MockLTS extends DoubleIntegerMock_intdata1LTS {

	private MockIntData service;

	public void setService(MockIntData theservice){
		this.service=theservice;
	}

	public ProvidedService getService(){
		return this.service;
	}
	
	public void init(){
		if(this.service.getNumber() == 1){
			this.initialState="i";
			this.currentState=initialState;
			this.outGoing.put("f", createArrayListFrom( ));
			this.finalStates.add("f");
			this.outGoing.put("i", createArrayListFrom(  "i___i1___1" ));
			this.outGoing.put("i1", createArrayListFrom(  "i1___f___2" ));
			transitionLabels.put("i___i1___1","count1 := getData(MockDataName)");
			transitionLabels.put("i1___f___2","SENDRESULT(count1)");
			transitionCommunications.put("i1___f___2",new SimpleCommunication("mockIntData1",null,"__CALLER",32));			
		}else{
			this.initialState="i";
			this.currentState=initialState;
			this.outGoing.put("f", createArrayListFrom( ));
			this.finalStates.add("f");
			this.outGoing.put("i", createArrayListFrom(  "i___i1___1" ));
			this.outGoing.put("i1", createArrayListFrom(  "i1___f___2" ));
			transitionLabels.put("i___i1___1","count2 := getData(MockDataName)");
			transitionLabels.put("i1___f___2","SENDRESULT(count2)");
			transitionCommunications.put("i1___f___2",new SimpleCommunication("mockIntData2",null,"__CALLER",32));
		}
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
