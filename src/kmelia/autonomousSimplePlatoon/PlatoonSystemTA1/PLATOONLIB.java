package kmelia.autonomousSimplePlatoon.PlatoonSystemTA1;
import costo.kml2java.framework.IProvidedService;


/**
 * 
 * @author costo kml2Java Generator
 * this code requires costo.kml2java.jar
 * 
 */
public class PLATOONLIB {






//
 
public static void msg(Object theO955, IProvidedService thisparam){
 mylib.PlatoonlibMap.msgFrom( theO955,thisparam);
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
 
public static void displaySpeed(String theS956){
System.out.println( theS956);
}
//
 
public static void displayInt(Integer theI957){
System.out.println( theI957);
}
//
 
public static void displayErr(String theS958){
System.err.println( theS958);
}
//
 
public static void print(String theS959){
System.out.print( theS959);
}
//
 
public static void println(String theS960){
System.out.println ( theS960);
}
//
 
public static void printlnString(String theS961){
System.out.println( theS961);
}
//
 
public static void printString(String theS962){
System.out.print( theS962);
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