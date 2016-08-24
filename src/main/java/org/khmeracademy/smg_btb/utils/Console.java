package org.khmeracademy.smg_btb.utils;

public class Console {
	public static void log(Object object){
		System.out.println("[==>>" + object + " ]");
	}
	public static void logError(Object object){
		System.err.println("[==>>" + object + " ]");
	}
}
