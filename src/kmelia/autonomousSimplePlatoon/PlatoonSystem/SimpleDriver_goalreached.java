package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import costo.kml2java.framework.*;
import costo.kml2java.framework.kmllibs.*;
import costo.kml2java.framework.channels.*;
import costo.kml2java.framework.annotations.*;
import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.*;

import static kmelia.autonomousSimplePlatoon.PlatoonSystem.SimpleDriver.*;
import static kmelia.autonomousSimplePlatoon.PlatoonSystem.PLATOONLIB.*;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */

public  class SimpleDriver_goalreached extends ProvidedService {
// component owner
protected SimpleDriver owner;



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
SimpleDriver_goalreachedLTS lts=new SimpleDriver_goalreachedLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="goalreached";

}

public void setOwner(SimpleDriver cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants



//
 
 Boolean guard_i___i2___1(){
return true;
}
//
 
 Boolean guard_i2___e2___2(){
return true;
}
//
 
 Boolean guard_e2___f___3(){
return true;
}


public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".SimpleDriver_goalreached: [");
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




//msg(" driver goalreached " + followerpos)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i___i2___1(){
 mylib.PlatoonlibMap.msgFrom(" driver goalreached " + getFollowerpos(),this);
}
//ok := (goal - followerpos <= idealDistance)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i2___e2___2(){
ok = (owner.getGoal() - getFollowerpos() <= idealDistance);
}
//SENDRESULT(ok)
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void e2___f___3(){
this.returnService("__CALLER","goalreached",new Object[]{getOk()},this);;
}


}