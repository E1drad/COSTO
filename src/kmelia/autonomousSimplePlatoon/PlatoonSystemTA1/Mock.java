package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;

import costo.kml2java.framework.*;

public class Mock extends DoubleIntegerMock {

	public Mock(String name, ExecutionContext owner, String id){
		super(name, owner, id);
	}


	public Mock(String name, ExecutionContext owner){
		super(name, owner);
	}

	public Mock(){
		super();
	}

	// Component state
	String mockIntData1 = new String();
	String mockIntData2 = new String();
	Integer count1;
	Integer count2;
	
	public String getDataname1(){
		return this.mockIntData1;
	}
	public String getDataname2(){
		return this.mockIntData2;
	}
	public Integer getCount2(){
		return this.count2;
	}
	public Integer getCount1(){
		return this.count1;
	}

	// constants

	// delegatesandcalculatedvar

	// SUB Components

	// Promoted variables
	// method for invariant

	@Override
	public void createServices(){
		this.name="DoubleIntegerMock";
		MockIntData aMockIntData2 = new MockIntData();
		aMockIntData2.setOwner(this);
		aMockIntData2.setNumber(2);
		aMockIntData2.setName("mockIntData2");
		this.providedservices.put("mockIntData2", aMockIntData2);
		//aDoubleIntegerMock_intdata2.init();
		MockIntData aMockIntData1 = new MockIntData();
		aMockIntData1.setOwner(this);
		aMockIntData1.setNumber(1);
		aMockIntData1.setName("mockIntData1");
		this.providedservices.put("mockIntData1", aMockIntData1);
		//aDoubleIntegerMock_intdata1.init();
		DoubleIntegerMock_conf aDoubleIntegerMock_conf = new DoubleIntegerMock_conf();
		aDoubleIntegerMock_conf.setOwner(this);
		aDoubleIntegerMock_conf.setName("conf");
		this.providedservices.put("conf", aDoubleIntegerMock_conf);
		//aDoubleIntegerMock_conf.init();
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
		count2 = 0;
		count1 = 0;
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
		if (!(o instanceof DoubleIntegerMock)){
			return false;
		}
		DoubleIntegerMock other=(DoubleIntegerMock)o;
		if (!other.dataname1.equals(this.mockIntData1)){
			return false;
		}
		if (!other.dataname2.equals(this.mockIntData2)){ 
			return false;
		}
		if (!other.count2.equals(this.count2)){ 
			return false;
		}
		if (!other.count1.equals(this.count1)){ 
			return false;
		}
		return true;
	}


	@Override
	public String toString(){
		StringBuffer result=new StringBuffer("Mock: [");
		result.append("dataname1");
		result.append(":");
		result.append(mockIntData1);
		result.append(", ");
		result.append("dataname2");
		result.append(":");
		result.append(mockIntData2);
		result.append(", ");
		result.append("count2");
		result.append(":");
		result.append(count2);
		result.append(", ");
		result.append("count1");
		result.append(":");
		result.append(count1);
		result.append("]");
		return result.toString();
	}

}
