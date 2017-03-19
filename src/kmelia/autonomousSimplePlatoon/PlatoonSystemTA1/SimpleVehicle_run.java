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

public  class SimpleVehicle_run extends ProvidedService {
// component owner
protected SimpleVehicle owner;



// protected ? 
//parameters

// protected ? 
@KmlElement(type={KmlElementType.VARIABLE})
protected Integer newspeed   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Integer getNewspeed(){ return this.newspeed;}
@KmlElement(type={KmlElementType.VARIABLE})
protected Integer safeDist   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Integer getSafeDist(){ return this.safeDist;}

public void initLTS(){
SimpleVehicle_runLTS lts=new SimpleVehicle_runLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="run";

}

public void setOwner(SimpleVehicle cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants



//
 
 Boolean guard_vri1___return___1(){
return true;
}
//
 
 Boolean guard_return___checkSD0___2(){
return true;
}
//
 
 Boolean guard_checkSD0___checkgoal1___3(){
return true;
}
//
 
 Boolean guard_checkgoal0___checkgoal1___4(){
return true;
}
//goalreached
 
 Boolean guard_checkgoal1___vrfinal___5(){
return owner.getGoalreached();
}
//not goalreached
 
 Boolean guard_checkgoal1___computespeed___6(){
return  ! owner.getGoalreached();
}
//
 
 Boolean guard_computespeed___applyspeed1___7(){
return true;
}
//
 
 Boolean guard_applyspeed1___applyspeed2___8(){
return true;
}
//
 
 Boolean guard_applyspeed2___displaypos___9(){
return true;
}
//
 
 Boolean guard_displaypos___checkgoal0___10(){
return true;
}


public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".SimpleVehicle_run: [");
result.append("newspeed");
result.append(":");
result.append(newspeed);
result.append(", ");
result.append("safeDist");
result.append(":");
result.append(safeDist);

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
Object[] rcvresult=this.receiveServiceCall("__CALLER","run",new Class<?>[]{},this);
}




//display("Vehicle " + vname + " starts")
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void vri1___return___1(){
display("Vehicle " + owner.getVname() + " starts");;
}
//SENDRESULT
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void return___checkSD0___2(){
this.returnService("__CALLER","run",new Object[]{},this);;
}
//safeDist := !!safeDistance
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void checkSD0___checkgoal1___3(){
this.callService("_safeDistance","safeDistance",new Object[]{},this);
Object[] rcvresult=this.receiveServiceReturn("_safeDistance","safeDistance",new Class<?>[]{Integer.class},this);
safeDist = (Integer) rcvresult[0 ];
;
}
//goalreached := !!isgoalreached(lastpos)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void checkgoal0___checkgoal1___4(){
this.callService("_isgoalreached","isgoalreached",new Object[]{owner.getLastpos()},this);
Object[] rcvresult=this.receiveServiceReturn("_isgoalreached","isgoalreached",new Class<?>[]{Boolean.class},this);
owner.goalreached = (Boolean) rcvresult[0 ];
;
}
//display("Vehicle " + vname + " arrived")
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void checkgoal1___vrfinal___5(){
display("Vehicle " + owner.getVname() + " arrived");;
}
//display("Vehicle " + vname + "getting info")
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void checkgoal1___computespeed___6(){
display("Vehicle " + owner.getVname() + "getting info");;
}
//newspeed := !!computeSpeed(safeDist)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void computespeed___applyspeed1___7(){
this.callService("_computeSpeed","computeSpeed",new Object[]{getSafeDist()},this);
Object[] rcvresult=this.receiveServiceReturn("_computeSpeed","computeSpeed",new Class<?>[]{Integer.class},this);
newspeed = (Integer) rcvresult[0 ];
;
}
//!!applySpeed(newspeed)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void applyspeed1___applyspeed2___8(){
this.callService("_applySpeed","applySpeed",new Object[]{getNewspeed()},this);;
}
//??applySpeed
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void applyspeed2___displaypos___9(){
Object[] rcvresult=this.receiveServiceReturn("_applySpeed","applySpeed",new Class<?>[]{},this);;
}
//display("Vehicle " + vname + " new speed applied pos: " + lastpos + " speed:" + vspeed)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void displaypos___checkgoal0___10(){
display("Vehicle " + owner.getVname() + " new speed applied pos: " + owner.getLastpos() + " speed:" + owner.getVspeed());;
}


}