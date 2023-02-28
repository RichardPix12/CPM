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
	
	/**
	 * Metodo que devuelve una lista que sera utilizada para otro metodo y cambiar el tipo de la lista
	 * @param tipo de tipo String
	 * @return articulos de tipo List<Articulo>
	 */
	public List<Articulo> getArticulosSegunTipo(String tipo) {
		
	List<Articulo> articulos = new ArrayList<Articulo>();
		
		for(Articulo ar: listaArticulos) {
			if( ar.getTipo().equals(tipo)){
				articulos.add(ar);
			}
		}		
		return articulos;
	}
	
	/**
	 * Metodo que crea un array que sera devuelto para colocar en el combo
	 * 
	 */
	public Articulo[] getArticulosSeleccionados(String tipo) {
		
		List<Articulo> ar = getArticulosSegunTipo(tipo);
		Articulo[] articulo = ar.toArray(new Articulo[ar.size()]);
		return articulo;
	}
}
