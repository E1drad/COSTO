package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import static kmelia.autonomousSimplePlatoon.PlatoonSystem.PLATOONLIB.idealDistance;
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

public  class SimpleVehicle_goalreached extends ProvidedService {
// component owner
protected SimpleVehicle owner;



// protected ? 
//parameters
@KmlElement(type={KmlElementType.PARAMETER})
protected  Integer followerpos;
@KmlElement(type={KmlElementType.PARAMETER})
public Integer getFollowerpos(){ return this.followerpos;}

// protected ? 
@KmlElement(type={KmlElementType.VARIABLE})
protected Boolean Result   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Boolean getResult(){ return this.Result;}
@KmlElement(type={KmlElementType.VARIABLE})
protected Boolean ok   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Boolean getOk(){ return this.ok;}

public void initLTS(){
SimpleVehicle_goalreachedLTS lts=new SimpleVehicle_goalreachedLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="goalreached";

}

public void setOwner(SimpleVehicle cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants



//
 
 Boolean guard_i___e2___1(){
return true;
}
//
 
 Boolean guard_e2___f___2(){
return true;
}


public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".SimpleVehicle_goalreached: [");
result.append("Result");
result.append(":");
result.append(Result);
result.append(", ");
result.append("ok");
result.append(":");
result.append(ok);

result.append("]");
return result.toString();
}
@Override 
public String getStateSpace(){
return super.getStateSpace()+this.toString();
} 

public void setResult(Object param){
Result=(Boolean) param; 
}

public boolean isPreSatisfiedWithTheseParameters(Object[] params){
try{
followerpos= (Integer)params[0] ;
}catch (Exception e){
e.printStackTrace();
return false;
}

return  this.isPreConditionSatisfied();
}
public  void executeStartingTransaction(){
Object[] rcvresult=this.receiveServiceCall("__CALLER","goalreached",new Class<?>[]{
Integer.class},this);
followerpos= (Integer)rcvresult[0] ;
}




//ok := goalreached and (lastpos - followerpos <= idealDistance)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i___e2___1(){
ok = owner.getGoalreached() && (owner.getLastpos() - getFollowerpos() <= idealDistance);
}
//SENDRESULT(ok)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e2___f___2(){
this.returnService("__CALLER","goalreached",new Object[]{getOk()},this);;
}


}