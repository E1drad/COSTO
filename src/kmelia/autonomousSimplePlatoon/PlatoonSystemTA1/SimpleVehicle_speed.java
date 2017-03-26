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

public  class SimpleVehicle_speed extends ProvidedService {
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
SimpleVehicle_speedLTS lts=new SimpleVehicle_speedLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="speed";

}

public void setOwner(SimpleVehicle cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants



//
 
 Boolean guard_i___f___1(){
return true;
}


public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".SimpleVehicle_speed: [");
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
Object[] rcvresult=this.receiveServiceCall("__CALLER","speed",new Class<?>[]{},this);
}




//__CALLER!!speed(vspeed)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i___f___1(){
this.returnService("__CALLER","speed",new Object[]{owner.getVspeed()},this);;
}


}