package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception {
	public static String Persistence_Exception_SAVE= "Guardar no completado: Problemas al intentar guardar";
	public static String Persistence_Exception_LOAD= "Cargar no completado: Problemas al intentar cargar";
	
	public PersistenceException(String message) {
		super(message);
	}
	
	public PersistenceException(String message, Exception e) {
		super(message);
		e.printStackTrace();
	}
}