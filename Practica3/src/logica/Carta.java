package logica;

import java.util.*;

public class Carta {
	
	private static final String FICHERO_ARTICULOS = "files/articulos.dat";
	private List<Articulo> listaArticulos = null;
	
	/**
	 * Constructor de la carta
	 */
	public Carta(){
		listaArticulos = new ArrayList<Articulo>();
		cargarArticulos();
	}
	
	/**
	 * Metodo que lee los articulos de un fichero y los graba en la lista
	 */
	private void cargarArticulos(){
		FileUtil.loadFile (FICHERO_ARTICULOS, listaArticulos);
	  }
	
	/**
	 * Metodo que devuelve un Array con los articulos de la carta
	 * @return articulos de tipo Articulo[]
	 */
	public Articulo[] getArticulos(){
		Articulo[] articulos = listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		return articulos;	
	}
	
}
