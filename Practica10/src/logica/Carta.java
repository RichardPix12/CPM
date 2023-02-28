package logica;

import java.util.*;

public class Carta {
	
	private static final String FICHERO_ARTICULOS = "files/articulos.dat";
	private List<Articulo> listaArticulos = null;
	
	public Carta(){
		listaArticulos = new ArrayList<Articulo>();
		cargarArticulos();
	}

	private void cargarArticulos(){
		FileUtil.loadFile (FICHERO_ARTICULOS, listaArticulos);
	  }

	public List<Articulo> getListaArticulos(){
		return listaArticulos;	
	}
	
	public List<Articulo> getArticulosFiltrados(String tipo){
		List<Articulo> lista = new ArrayList<Articulo>();
		
		for (Articulo ar : listaArticulos) {
			if (ar.getTipo() == tipo) {
				lista.add(ar);
			}
		}
		
		return lista;
	}
	
}
