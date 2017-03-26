package kmelia.autonomousSimplePlatoon.PlatoonSystem;
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

public  class SimpleVehicle_giveSafeDistance extends ProvidedService {
// component owner
protected SimpleVehicle owner;



// protected ? 
//parameters

// protected ? 
@KmlElement(type={KmlElementType.VARIABLE})
protected Integer Result   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Integer getResult(){ return this.Result;}

public void initLTS(){
SimpleVehicle_giveSafeDistanceLTS lts=new SimpleVehicle_giveSafeDistanceLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="giveSafeDistance";

}

public void setOwner(SimpleVehicle cowner){
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
result.append(".SimpleVehicle_giveSafeDistance: [");
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
Object[] rcvresult=this.receiveServiceCall("__CALLER","giveSafeDistance",new Class<?>[]{},this);
}




//msg(" vehicule " + vname + " give safedistance")
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i___i1___1(){
 mylib.PlatoonlibMap.msgFrom(" vehicule " + owner.getVname() + " give safedistance",this);
}
//SENDRESULT(10)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i1___f___2(){
this.returnService("__CALLER","giveSafeDistance",new Object[]{10},this);;
}


}