package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import costo.kml2java.framework.ExecutableComponent;
import costo.kml2java.framework.RequiredService;
import costo.kml2java.framework.annotations.KmlElement;
import costo.kml2java.framework.annotations.KmlElementType;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */

public  class SimpleVehicle_pilotpos extends RequiredService {
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
}

public void initState(){
this.name="pilotpos";

}

public void setOwner(SimpleVehicle cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants





public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".SimpleVehicle_pilotpos: [");
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






}