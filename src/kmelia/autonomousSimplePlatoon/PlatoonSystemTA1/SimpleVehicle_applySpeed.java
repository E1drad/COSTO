package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import static kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.PLATOONLIB.maxSpeed;
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

public  class SimpleVehicle_applySpeed extends ProvidedService {
// component owner
protected SimpleVehicle owner;



// protected ? 
//parameters
@KmlElement(type={KmlElementType.PARAMETER})
protected  Integer thespeed;
@KmlElement(type={KmlElementType.PARAMETER})
public Integer getThespeed(){ return this.thespeed;}

// protected ? 

public void initLTS(){
SimpleVehicle_applySpeedLTS lts=new SimpleVehicle_applySpeedLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="applySpeed";

}

public void setOwner(SimpleVehicle cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants



//
 
 Boolean guard_i___e1___1(){
return true;
}
//
 
 Boolean guard_e1___e2___2(){
return true;
}
//
 
 Boolean guard_e2___f___3(){
return true;
}
//
 
 Boolean anonymous947Pre(){
Boolean resultA;
resultA=getThespeed() >= 0 && getThespeed() <= maxSpeed;
this.assertStatus("anonymous947Pre()",resultA.toString());
return resultA;
}
//
 
public  Boolean isObsPreConditionSatisfied(){
Boolean resultA=true;
resultA &=anonymous947Pre();
return resultA;
}
//
 
public  Boolean isNonObsPreConditionSatisfied(){
Boolean resultA=true;
return resultA;
}


public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".SimpleVehicle_applySpeed: [");
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
thespeed= (Integer)params[0] ;
}catch (Exception e){
e.printStackTrace();
return false;
}

return  this.isPreConditionSatisfied();
}
public  void executeStartingTransaction(){
Object[] rcvresult=this.receiveServiceCall("__CALLER","applySpeed",new Class<?>[]{
Integer.class},this);
thespeed= (Integer)rcvresult[0] ;
}




//lastpos := lastpos + thespeed
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i___e1___1(){
owner.lastpos = owner.getLastpos() + getThespeed();
}
//vspeed := thespeed
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e1___e2___2(){
owner.vspeed = getThespeed();
}
//SENDRESULT
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e2___f___3(){
this.returnService("__CALLER","applySpeed",new Object[]{},this);;
}


}