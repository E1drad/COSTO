package mylib;

import java.util.Arrays;
import java.util.Random;

import costo.kml2java.framework.IProvidedService;
import costo.kml2java.framework.kmllibs.KmlSet;

public class PlatoonlibMap {

	static int pos = 10;
	static boolean msgDisplay = false;
	static boolean processHandling = false;
	static Random r = new Random();

	public static KmlSet<Integer> fromArray(Integer[] other) {
		KmlSet<Integer> newset = new KmlSet<Integer>();

		newset.addAll(Arrays.asList(other));
		return newset;
	}

	public static void msg(Object o) {
		System.out.println("msg" + o.toString());
	}

	public static void msgFrom(Object o, IProvidedService p) {
		if (msgDisplay)
			System.out.println("msg>> " + o.toString() + " from "
					+ p.getLongName());
	}

	public static Integer givePos() {
		pos = pos + 10;
		return pos;
	}

	public static Integer giveSpeed() {
		return r.nextInt(20) + 20;
	}

	public static void waiting(Integer millis) {
		if (processHandling) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void yield() {
		if (processHandling) Thread.yield();
	}
}
