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

public  class SimpleDriver_conf extends ProvidedService {
// component owner
protected SimpleDriver owner;



// protected ? 
//parameters
@KmlElement(type={KmlElementType.PARAMETER})
protected  Integer thegoal;
@KmlElement(type={KmlElementType.PARAMETER})
public Integer getThegoal(){ return this.thegoal;}

// protected ? 

public void initLTS(){
SimpleDriver_confLTS lts=new SimpleDriver_confLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="conf";

}

public void setOwner(SimpleDriver cowner){
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
result.append(".SimpleDriver_conf: [");
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
thegoal= (Integer)params[0] ;
}catch (Exception e){
e.printStackTrace();
return false;
}

return  this.isPreConditionSatisfied();
}
public  void executeStartingTransaction(){
Object[] rcvresult=this.receiveServiceCall("__CALLER","conf",new Class<?>[]{
Integer.class},this);
thegoal= (Integer)rcvresult[0] ;
}




//goal := thegoal
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i___f___1(){
owner.goal = getThegoal();
}


}