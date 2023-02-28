package logica;

import java.io.*;
import java.util.*;

public abstract class FileUtil {
	
	/**
	 * Metodo para cargar los datos de un fichero	
	 * @param nombreFicheroEntrada de tipo String, fichero del que se leen los datos
	 * @param listaCatalogo de tipo List<Articulo>, lista donde se graban los datos
	 */
	public static void loadFile (String nombreFicheroEntrada, List<Articulo> listaCatalogo) {
		
	    String linea;
	    String[] datosArticulo= null;	   
	    
	    try {
	    	   BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
	    		while (fichero.ready()) {
	    			linea = fichero.readLine();
	    			datosArticulo = linea.split("@");
	    			listaCatalogo.add(new Articulo(datosArticulo[0],datosArticulo[1],datosArticulo[2],Float.parseFloat(datosArticulo[3]),0));
	    		}
	    		fichero.close();
	    }
	    catch (FileNotFoundException fnfe) {
	      System.out.println("El archivo no se ha encontrado.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("Error de entrada/salida.");
	    } 
	  }

	/**
	 * Metodo para grabar en fichero los datos de una lista
	 * @param nombreFicheroSalida de tipo String, fichero donde se graban los datos
	 * @param listaPedido de tipo List<Articulo>, lista de donde se sacan los datos
	 */
	public static void saveToFile(String nombreFicheroSalida, List<Articulo> listaPedido ,String tipo){
		try {
		        BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFicheroSalida + ".dat"));
		        String linea = listaPedido.toString();
		        fichero.write(linea);
		        fichero.write( " " + tipo);
		        fichero.close();
			}

		catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha podido guardar");
		    }
		catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}
	  }
	
	/**
	 * Metodo para dar un codigo de 8 digitos aleatorio, utilizado para elegir el codigo de espera que sera el nombre del fichero donde se graba
	 * @return codigo de tipo String, codigo de espera
	 */
	public static String setFileName(){
		String codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for(int i=0; i<longitudCodigo;i++){ 
			int numero = (int)(Math.random()*(base.length())); 
			codigo += base.charAt(numero);
		}
		return codigo;
	}
}
