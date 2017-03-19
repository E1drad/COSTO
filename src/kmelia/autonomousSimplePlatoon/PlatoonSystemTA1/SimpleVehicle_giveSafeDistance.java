package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import costo.kml2java.framework.*;
import costo.kml2java.framework.kmllibs.*;
import costo.kml2java.framework.channels.*;
import costo.kml2java.framework.annotations.*;
import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.*;

import static kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.SimpleVehicle.*;
import static kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.PLATOONLIB.*;
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
 
 Boolean guard_i___f___1(){
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




//SENDRESULT(10)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i___f___1(){
this.returnService("__CALLER","giveSafeDistance",new Object[]{10},this);;
}


}