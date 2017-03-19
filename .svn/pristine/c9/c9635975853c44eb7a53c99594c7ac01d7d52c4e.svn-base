package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import costo.kml2java.framework.*;
import costo.kml2java.framework.test.*;
import costo.kml2java.framework.kmllibs.*;
import costo.kml2java.framework.channels.*;
import static costo.kml2java.framework.kmllibs.KmeliaDefaultLib.*;

 
import static kmelia.autonomousSimplePlatoon.PlatoonSystemTA1.PLATOONTESTLIB.*;
/**
 *
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */
public class DoubleIntegerMock extends ExecutableComponent {


public DoubleIntegerMock(String name, ExecutionContext owner, String id){
super(name, owner, id);
}


public DoubleIntegerMock(String name, ExecutionContext owner){
super(name, owner);
}

public DoubleIntegerMock(){
super();
}

// Component state
String dataname1 = new String()   ; ;
public String getDataname1(){ return this.dataname1;}
String dataname2 = new String()   ; ;
public String getDataname2(){ return this.dataname2;}
Integer count2    ; ;
public Integer getCount2(){ return this.count2;}
Integer count1    ; ;
public Integer getCount1(){ return this.count1;}



// constants


// delegatesandcalculatedvar


// SUB Components

// Promoted variables
// method for invariant


@Override
public void createServices(){
this.name="DoubleIntegerMock";
DoubleIntegerMock_intdata2 aDoubleIntegerMock_intdata2 = new DoubleIntegerMock_intdata2();
aDoubleIntegerMock_intdata2.setOwner(this);
aDoubleIntegerMock_intdata2.setName("intdata2");
this.providedservices.put("intdata2", aDoubleIntegerMock_intdata2);
//aDoubleIntegerMock_intdata2.init();
DoubleIntegerMock_intdata1 aDoubleIntegerMock_intdata1 = new DoubleIntegerMock_intdata1();
aDoubleIntegerMock_intdata1.setOwner(this);
aDoubleIntegerMock_intdata1.setName("intdata1");
this.providedservices.put("intdata1", aDoubleIntegerMock_intdata1);
//aDoubleIntegerMock_intdata1.init();
DoubleIntegerMock_conf aDoubleIntegerMock_conf = new DoubleIntegerMock_conf();
aDoubleIntegerMock_conf.setOwner(this);
aDoubleIntegerMock_conf.setName("conf");
this.providedservices.put("conf", aDoubleIntegerMock_conf);
//aDoubleIntegerMock_conf.init();
//initServices();
}

@Override
public void resolvePromotedServices(){
// TODO : forall promoted, set their origin ...
// du genre prompted.setOrigin(c1.getService("machin")
}

@Override
public void initState(){
this.autorun="";
count2 = 0;
count1 = 0;
}

@Override
public void initSubComponents(){

// Init subcomponents


}

@Override
public void initBindings(){
}

@Override
public boolean equals(Object o){
if (!(o instanceof DoubleIntegerMock)) return false;
DoubleIntegerMock other=(DoubleIntegerMock)o;
if (!other.dataname1.equals(this.dataname1)) return false;
if (!other.dataname2.equals(this.dataname2)) return false;
if (!other.count2.equals(this.count2)) return false;
if (!other.count1.equals(this.count1)) return false;
return true;
}


@Override
public String toString(){
StringBuffer result=new StringBuffer("DoubleIntegerMock: [");
result.append("dataname1");
result.append(":");
result.append(dataname1);
result.append(", ");
result.append("dataname2");
result.append(":");
result.append(dataname2);
result.append(", ");
result.append("count2");
result.append(":");
result.append(count2);
result.append(", ");
result.append("count1");
result.append(":");
result.append(count1);

result.append("]");
return result.toString();
}


}