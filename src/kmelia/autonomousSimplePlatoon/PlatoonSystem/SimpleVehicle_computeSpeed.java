package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.display;
import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.implies;
import static kmelia.autonomousSimplePlatoon.PlatoonSystem.PLATOONLIB.distanceStep;
import static kmelia.autonomousSimplePlatoon.PlatoonSystem.PLATOONLIB.maxSpeed;
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

public  class SimpleVehicle_computeSpeed extends ProvidedService {
// component owner
protected SimpleVehicle owner;



// protected ? 
//parameters
@KmlElement(type={KmlElementType.PARAMETER})
protected  Integer safeDistance;
@KmlElement(type={KmlElementType.PARAMETER})
public Integer getSafeDistance(){ return this.safeDistance;}

// protected ? 
@KmlElement(type={KmlElementType.VARIABLE})
protected Integer Result   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Integer getResult(){ return this.Result;}
@KmlElement(type={KmlElementType.VARIABLE})
protected Integer newspeed   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Integer getNewspeed(){ return this.newspeed;}
@KmlElement(type={KmlElementType.VARIABLE})
protected Integer distance   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Integer getDistance(){ return this.distance;}
@KmlElement(type={KmlElementType.VARIABLE})
protected Integer ppos   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Integer getPpos(){ return this.ppos;}
@KmlElement(type={KmlElementType.VARIABLE})
protected Integer pspeed   ;
@KmlElement(type={KmlElementType.VARIABLE})
public Integer getPspeed(){ return this.pspeed;}

public void initLTS(){
SimpleVehicle_computeSpeedLTS lts=new SimpleVehicle_computeSpeedLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="computeSpeed";

}

public void setOwner(SimpleVehicle cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants



//
 
 Boolean guard_i___displaystate___1(){
return true;
}
//
 
 Boolean guard_displaystate___getppos1___2(){
return true;
}
//
 
 Boolean guard_getppos1___getppos2___3(){
return true;
}
//
 
 Boolean guard_getppos2___getpspeed1___4(){
return true;
}
//
 
 Boolean guard_getpspeed1___displayspeed___5(){
return true;
}
//
 
 Boolean guard_displayspeed___calcdist___6(){
return true;
}
//
 
 Boolean guard_calcdist___e1___7(){
return true;
}
//distance > safeDistance and vspeed <= pspeed
 
 Boolean guard_e1___e2___8(){
return getDistance() > getSafeDistance() && owner.getVspeed() <= getPspeed();
}
//distance > safeDistance and vspeed > pspeed
 
 Boolean guard_e1___e2___9(){
return getDistance() > getSafeDistance() && owner.getVspeed() > getPspeed();
}
//distance <= safeDistance
 
 Boolean guard_e1___e2___10(){
return getDistance() <= getSafeDistance();
}
//newspeed < 0
 
 Boolean guard_e2___f___11(){
return getNewspeed() < 0;
}
//newspeed > maxSpeed
 
 Boolean guard_e2___f___12(){
return getNewspeed() > maxSpeed;
}
//newspeed <= maxSpeed and newspeed >= 0
 
 Boolean guard_e2___f___13(){
return getNewspeed() <= maxSpeed && getNewspeed() >= 0;
}
//
 
 Boolean anonymous1370Pre(){
Boolean resultA;
resultA=getSafeDistance() >= 0;
this.assertStatus("anonymous1370Pre()",resultA.toString());
return resultA;
}
//
 
public  Boolean isObsPreConditionSatisfied(){
Boolean resultA=true;
resultA &=anonymous1370Pre();
return resultA;
}
//
 
public  Boolean isNonObsPreConditionSatisfied(){
Boolean resultA=true;
return resultA;
}
//
 
 Boolean anonymous1371Post(){
Boolean resultA;
resultA=getResult() >= 0 && getResult() <= maxSpeed && implies(((getPpos() - owner.getLastpos()) < getSafeDistance()),getResult().equals(0));
this.assertStatus("anonymous1371Post()",resultA.toString());
return resultA;
}
//
 
public  Boolean isObsPostConditionSatisfied(){
Boolean resultA=true;
return resultA;
}
//
 
public  Boolean isNonObsPostConditionSatisfied(){
Boolean resultA=true;
resultA &=anonymous1371Post();
return resultA;
}


public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".SimpleVehicle_computeSpeed: [");
result.append("Result");
result.append(":");
result.append(Result);
result.append(", ");
result.append("newspeed");
result.append(":");
result.append(newspeed);
result.append(", ");
result.append("distance");
result.append(":");
result.append(distance);
result.append(", ");
result.append("ppos");
result.append(":");
result.append(ppos);
result.append(", ");
result.append("pspeed");
result.append(":");
result.append(pspeed);

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
safeDistance= (Integer)params[0] ;
}catch (Exception e){
e.printStackTrace();
return false;
}

return  this.isPreConditionSatisfied();
}
public  void executeStartingTransaction(){
Object[] rcvresult=this.receiveServiceCall("__CALLER","computeSpeed",new Class<?>[]{
Integer.class},this);
safeDistance= (Integer)rcvresult[0] ;
}




//display("computeSpeed called with safeDistance: " + safeDistance)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i___displaystate___1(){
display("computeSpeed called with safeDistance: " + getSafeDistance());;
}
//display("Vehicle " + vname + " has lastpos: " + lastpos + " and  vspeed: " + vspeed)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void displaystate___getppos1___2(){
display("Vehicle " + owner.getVname() + " has lastpos: " + owner.getLastpos() + " and  vspeed: " + owner.getVspeed());;
}
//ppos := !!pilotpos
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void getppos1___getppos2___3(){
this.callService("_pilotpos","pilotpos",new Object[]{},this);
Object[] rcvresult=this.receiveServiceReturn("_pilotpos","pilotpos",new Class<?>[]{Integer.class},this);
ppos = (Integer) rcvresult[0 ];
;
}
//display("Vehicle " + vname + " gets pilotpos" + ppos)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void getppos2___getpspeed1___4(){
display("Vehicle " + owner.getVname() + " gets pilotpos" + getPpos());;
}
//pspeed := !!pilotspeed
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void getpspeed1___displayspeed___5(){
this.callService("_pilotspeed","pilotspeed",new Object[]{},this);
Object[] rcvresult=this.receiveServiceReturn("_pilotspeed","pilotspeed",new Class<?>[]{Integer.class},this);
pspeed = (Integer) rcvresult[0 ];
;
}
//display("Vehicle " + vname + " gets pilotspeed" + pspeed)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void displayspeed___calcdist___6(){
display("Vehicle " + owner.getVname() + " gets pilotspeed" + getPspeed());;
}
//distance := ppos - lastpos
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void calcdist___e1___7(){
distance = getPpos() - owner.getLastpos();
}
//newspeed := vspeed + distanceStep
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e1___e2___8(){
newspeed = owner.getVspeed() + distanceStep;
}
//newspeed := vspeed - distanceStep
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e1___e2___9(){
newspeed = owner.getVspeed() - distanceStep;
}
//newspeed := 0
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e1___e2___10(){
newspeed = 0;
}
//SENDRESULT(0)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e2___f___11(){
this.returnService("__CALLER","computeSpeed",new Object[]{0},this);;
}
//SENDRESULT(maxSpeed)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e2___f___12(){
this.returnService("__CALLER","computeSpeed",new Object[]{maxSpeed},this);;
}
//SENDRESULT(newspeed)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e2___f___13(){
this.returnService("__CALLER","computeSpeed",new Object[]{getNewspeed()},this);;
}


}