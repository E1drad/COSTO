package kmelia.autonomousSimplePlatoon.PlatoonSystem;
import costo.kml2java.framework.IProvidedService;


/**
 * 
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */
public class PLATOONLIB {






//
 
public static void msg(Object theO1387, IProvidedService thisparam){
 mylib.PlatoonlibMap.msgFrom( theO1387,thisparam);
}
//
 
public static Integer readSpeed(){
return mylib.PlatoonlibMap.giveSpeed();
}
//
 
public static Integer readPosition(){
return mylib.PlatoonlibMap.givePos();
}
//
 
public static void displaySpeed(String theS1388){
System.out.println( theS1388);
}
//
 
public static void displayInt(Integer theI1389){
System.out.println( theI1389);
}
//
 
public static void displayErr(String theS1390){
System.err.println( theS1390);
}
//
 
public static void print(String theS1391){
System.out.print( theS1391);
}
//
 
public static void println(String theS1392){
System.out.println ( theS1392);
}
//
 
public static void printlnString(String theS1393){
System.out.println( theS1393);
}
//
 
public static void printString(String theS1394){
System.out.print( theS1394);
}
//
 
public static void wait(Integer theI1395){
mylib.PlatoonlibMap.waiting( theI1395);
}
//
 
public static void yield(){
mylib.PlatoonlibMap.yield();
}

// constants
public static final Integer minAccel  = - 1 ;
public static final Integer alertDistance  = 3 ;
public static final Integer maxSpeed  = 130 ;
public static final Integer idealDistance  = 5 ;
public static final Integer distanceStep  = 10 ;
public static final Integer maxAccel  = 100 ;

public String toString(){
StringBuffer result=new StringBuffer("PLATOONLIB: [");
result.append("]");
return result.toString();
}

}