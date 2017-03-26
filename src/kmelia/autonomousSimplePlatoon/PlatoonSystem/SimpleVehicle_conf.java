package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.display;
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

public  class SimpleVehicle_conf extends ProvidedService {
// component owner
protected SimpleVehicle owner;



// protected ? 
//parameters
@KmlElement(type={KmlElementType.PARAMETER})
protected  String pvname;
@KmlElement(type={KmlElementType.PARAMETER})
public String getPvname(){ return this.pvname;}
@KmlElement(type={KmlElementType.PARAMETER})
protected  Integer currentPos;
@KmlElement(type={KmlElementType.PARAMETER})
public Integer getCurrentPos(){ return this.currentPos;}
@KmlElement(type={KmlElementType.PARAMETER})
protected  Integer currentSpeed;
@KmlElement(type={KmlElementType.PARAMETER})
public Integer getCurrentSpeed(){ return this.currentSpeed;}

// protected ? 

public void initLTS(){
SimpleVehicle_confLTS lts=new SimpleVehicle_confLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="conf";

}

public void setOwner(SimpleVehicle cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants



//
 
 Boolean guard_initvi___initve1___1(){
return true;
}
//
 
 Boolean guard_initve1___initve2___2(){
return true;
}
//
 
 Boolean guard_initve2___initve3___3(){
return true;
}
//
 
 Boolean guard_initve3___initvf___4(){
return true;
}
//
 
 Boolean anonymous1368Post(){
Boolean resultA;
resultA=owner.getLastpos().equals(getCurrentPos()) && owner.getVspeed().equals(getCurrentSpeed());
this.assertStatus("anonymous1368Post()",resultA.toString());
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
resultA &=anonymous1368Post();
return resultA;
}


public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".SimpleVehicle_conf: [");
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
pvname= (String)params[0] ;
currentPos= (Integer)params[1] ;
currentSpeed= (Integer)params[2] ;
}catch (Exception e){
e.printStackTrace();
return false;
}

return  this.isPreConditionSatisfied();
}
public  void executeStartingTransaction(){
Object[] rcvresult=this.receiveServiceCall("__CALLER","conf",new Class<?>[]{
String.class,
Integer.class,
Integer.class},this);
pvname= (String)rcvresult[0] ;
currentPos= (Integer)rcvresult[1] ;
currentSpeed= (Integer)rcvresult[2] ;
}




//lastpos := currentPos
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void initvi___initve1___1(){
owner.lastpos = getCurrentPos();
}
//vname := pvname
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void initve1___initve2___2(){
owner.vname = getPvname();
}
//vspeed := currentSpeed
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void initve2___initve3___3(){
owner.vspeed = getCurrentSpeed();
}
//display(vname + " is initialised at currentpos: " + currentPos + " speed: " + currentSpeed)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void initve3___initvf___4(){
display(owner.getVname() + " is initialised at currentpos: " + getCurrentPos() + " speed: " + getCurrentSpeed());;
}


}