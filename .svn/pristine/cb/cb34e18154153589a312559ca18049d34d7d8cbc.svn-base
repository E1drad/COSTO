package mylib;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import costo.kml2java.framework.IProvidedService;

public class PlatoonTestlibMap {

	static Properties dataMap = null;

	static public void load() {
		try {
			dataMap = new Properties();
			// System.err.println("LOAD DATA");
			dataMap.load(new FileReader("src/testdata.txt"));
			// System.err.println("END LOAD DATA");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Integer getData(String dataname) {
		// System.err.println("DATA request"+dataname);
		Integer i = null;

		try {
			if (dataMap == null) {
				load();
			}
			i = Integer.parseInt((String) dataMap.get(dataname));

		} catch (Exception e) {
			System.err.println("exception while looking for data: " + dataname + " \n\t" + e.getMessage());
		}
		return i;
	}

	public static void assertT(boolean verdict, IProvidedService p) {
		System.out.println(">>TEST<< " + p.getLongName() + "verdict is " + verdict);
	}

	//public static void assertT(boolean verdict) {
	//	System.out.println(">>TEST<< " + "verdict is " + verdict);
	//}

}
