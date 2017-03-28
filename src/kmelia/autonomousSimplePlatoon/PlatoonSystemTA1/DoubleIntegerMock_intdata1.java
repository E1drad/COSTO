package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import costo.kml2java.framework.*;
import costo.kml2java.framework.kmllibs.*;
import costo.kml2java.framework.channels.*;
import costo.kml2java.framework.annotations.*;
import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.*;

import static kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.DoubleIntegerMock.*;
import static kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.PLATOONTESTLIB.*;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */

public  class DoubleIntegerMock_intdata1 extends ProvidedService {
	// component owner
	protected DoubleIntegerMock owner;

	// protected ? 
	//parameters

	// protected ? 
	@KmlElement(type={KmlElementType.VARIABLE})
	protected Integer Result   ;
	@KmlElement(type={KmlElementType.VARIABLE})
	public Integer getResult(){ return this.Result;}

	public void initLTS(){
		DoubleIntegerMock_intdata1LTS lts=new DoubleIntegerMock_intdata1LTS();
		this.setLTS(lts);
		lts.setService(this);
		lts.init();
	}

	public void initState(){
		this.name="intdata1";
	}

	public void setOwner(DoubleIntegerMock cowner){
		this.owner=cowner;
	}

	public ExecutableComponent getOwner(){
		return this.owner;
	}

	// constants

	//

	Boolean guard_i___i1___1(){
		return true;
	}
	//

	Boolean guard_i1___f___2(){
		return true;
	}

	public String toString(){
		StringBuffer result=new StringBuffer("");
		result.append(getOwner().getIdJFK());
		result.append(".DoubleIntegerMock_intdata1: [");
		result.append("Result");
		result.append(":");
		result.append(Result);
		result.append("]");
		return result.toString();
	}
	
	@Override 
	public String getStateSpace(){
		return super.getStateSpace()+this.toString();
	} 

	public void setResult(Object param){
		Result=(Integer) param; 
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
		Object[] rcvresult=this.receiveServiceCall("__CALLER","intdata1",new Class<?>[]{},this);
	}

	//count1 := getData(dataname1)

	@KmlElement(type={KmlElementType.TRANSITION})
	void i___i1___1(){
		owner.count1 = mylib.PlatoonTestlibMap.getData(owner.getDataname1());
	}
	//SENDRESULT(count1)

	@KmlElement(type={KmlElementType.TRANSITION})
	void i1___f___2(){
		this.returnService("__CALLER","intdata1",new Object[]{owner.getCount1()},this);;
	}
}