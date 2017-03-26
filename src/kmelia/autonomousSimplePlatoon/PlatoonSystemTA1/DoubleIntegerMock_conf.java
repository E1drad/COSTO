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

public  class DoubleIntegerMock_conf extends ProvidedService {
// component owner
protected DoubleIntegerMock owner;



// protected ? 
//parameters
@KmlElement(type={KmlElementType.PARAMETER})
protected  String dname1;
@KmlElement(type={KmlElementType.PARAMETER})
public String getDname1(){ return this.dname1;}
@KmlElement(type={KmlElementType.PARAMETER})
protected  String dname2;
@KmlElement(type={KmlElementType.PARAMETER})
public String getDname2(){ return this.dname2;}

// protected ? 

public void initLTS(){
DoubleIntegerMock_confLTS lts=new DoubleIntegerMock_confLTS();
this.setLTS(lts);
lts.setService(this);
lts.init();
}

public void initState(){
this.name="conf";

}

public void setOwner(DoubleIntegerMock cowner){
this.owner=cowner;
}


public ExecutableComponent getOwner(){
return this.owner;
}



// constants



//
 
 Boolean guard_i___s1___1(){
return true;
}
//
 
 Boolean guard_s1___f___2(){
return true;
}


public String toString(){
StringBuffer result=new StringBuffer("");
result.append(getOwner().getIdJFK());
result.append(".DoubleIntegerMock_conf: [");
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
dname1= (String)params[0] ;
dname2= (String)params[1] ;
}catch (Exception e){
e.printStackTrace();
return false;
}

return  this.isPreConditionSatisfied();
}
public  void executeStartingTransaction(){
Object[] rcvresult=this.receiveServiceCall("__CALLER","conf",new Class<?>[]{
String.class,
String.class},this);
dname1= (String)rcvresult[0] ;
dname2= (String)rcvresult[1] ;
}




//dataname1 := dname1
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void i___s1___1(){
owner.dataname1 = getDname1();
}
//dataname2 := dname2
 
 @KmlElement(type={KmlElementType.TRANSITION})
 void s1___f___2(){
owner.dataname2 = getDname2();
}


}