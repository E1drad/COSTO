package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import costo.kml2java.framework.ExecutableComponent;
import costo.kml2java.framework.ProvidedService;
import costo.kml2java.framework.annotations.KmlElement;
import costo.kml2java.framework.annotations.KmlElementType;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */

public  class VehicleTester_testcase1 extends ProvidedService {
// component owner
protected VehicleTester owner;



// protected ? 
//parameters

// protected ? 
@KmlElement(type={KmlElementType.VARIABLE})
protected Integer computespeedresult   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Integer getComputespeedresult(){ return this.computespeedresult;}

public void initLTS(){
VehicleTester_testcase1LTS lts=new VehicleTester_testcase1LTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="testcase1";

}

public void setOwner(VehicleTester cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants



//
 
 Boolean guard_s0___s1___1(){
return true;
}
//
 
 Boolean guard_s1___s2___2(){
return true;
}
//
 
 Boolean guard_s2___s3___3(){
return true;
}
//
 
 Boolean guard_s3___s4___4(){
return true;
}


public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".VehicleTester_testcase1: [");
result.append("computespeedresult");
result.append(":");
result.append(computespeedresult);

result.append("]");
return result.toString();
}
@Override 
public String getStateSpace(){
return super.getStateSpace()+this.toString();
} 

public void setResult(Object param){
 
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
Object[] rcvresult=this.receiveServiceCall("__CALLER","testcase1",new Class<?>[]{},this);
}




//computespeedresult := !!computeSpeed(getData("safeDistance"))
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void s0___s1___1(){
this.callService("_computeSpeed","computeSpeed",new Object[]{mylib.PlatoonTestlibMap.getData("safeDistance")},this);
Object[] rcvresult=this.receiveServiceReturn("_computeSpeed","computeSpeed",new Class<?>[]{Integer.class},this);
computespeedresult = (Integer) rcvresult[0 ];
;
}
//verdict := (computespeedresult = getData("oracledata"))
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void s1___s2___2(){
owner.verdict = (getComputespeedresult().equals(mylib.PlatoonTestlibMap.getData("oracledata")));
}
//assertT(verdict)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void s2___s3___3(){
 mylib.PlatoonTestlibMap.assertT(owner.getVerdict(),this);
}
//SENDRESULT
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void s3___s4___4(){
this.returnService("__CALLER","testcase1",new Object[]{},this);;
}


}