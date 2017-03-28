package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;

import costo.kml2java.framework.ExecutableComponent;
import costo.kml2java.framework.ProvidedService;
import costo.kml2java.framework.annotations.KmlElement;
import costo.kml2java.framework.annotations.KmlElementType;

public class MockIntData extends DoubleIntegerMock_intdata1 {

	private Mock owner;
	private int number;	

	@KmlElement(type={KmlElementType.VARIABLE})
	protected Integer Result;
	@KmlElement(type={KmlElementType.VARIABLE})
	public Integer getResult(){
		return this.Result;
	}
	
	public void initLTS(){
		MockLTS lts=new MockLTS();
		this.setLTS(lts);
		lts.setService(this);
		lts.init();
	}

	public void initState(){
		this.name="intdata2";
	}
	
	@Override
	public ExecutableComponent getOwner() {
		return this.owner;
	}
	
	@KmlElement(type={KmlElementType.TRANSITION})
	public void i___i1___1() {
		// TODO Auto-generated method stub
		System.out.println("MockIntData.i___i1___1() has been call");
		if(number == 1){
			owner.count1 = mylib.PlatoonTestlibMap.getData(owner.getDataname1());
		}else{
			owner.count2 = mylib.PlatoonTestlibMap.getData(owner.getDataname2());
		}
	}
	@KmlElement(type={KmlElementType.TRANSITION})
	public void i1___f___2() {
		// TODO Auto-generated method stub
		System.out.println("MockIntData.i1___f___2() has been call");
		if(number == 1){
			this.returnService("__CALLER","mockIntData1",new Object[]{owner.getCount1()},this);;
		}else{
			this.returnService("__CALLER","mockIntData2",new Object[]{owner.getCount2()},this);;
		}
	}

	public Boolean guard_i___i1___1() {
		// TODO Auto-generated method stub
		System.out.println("MockIntData.guard_i___i1___1() has been call");
		return true;
	}

	public Boolean guard_i1___f___2() {
		// TODO Auto-generated method stub
		System.out.println("MockIntData.guard_i1___f___2() has been call");
		return true;
	}

	public void setOwner(Mock mock) {
		this.owner = mock;
	}

	public String toString(){
		StringBuffer result=new StringBuffer("");
		result.append(getOwner().getIdJFK());
		result.append(".MockIntData ");
		result.append(this.number);
		result.append(" : [");
		result.append("Result");
		result.append(":");
		result.append(Result);
		result.append("]");
		return result.toString();
	}
	
	@Override 
	public String getStateSpace(){
		return super.getStateSpace() + this.toString();
	} 

	public void setResult(Object param){
		this.Result = (Integer) param; 
	}

	public boolean isPreSatisfiedWithTheseParameters(Object[] params){
		try{
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return  this.isPreConditionSatisfied();
	}
	public  void executeStartingTransaction(){
		Object[] rcvresult=this.receiveServiceCall("__CALLER","intdata2",new Class<?>[]{},this);
	}

	
	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
	
}
