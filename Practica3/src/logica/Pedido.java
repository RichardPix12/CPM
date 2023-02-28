package logica;

import java.util.*;

public class Pedido {
	
	private List<Articulo> listaPedido = null;
	private String estado;
	
	/**
	 * Constructor de pedido
	 */
	public Pedido(){
		listaPedido = new ArrayList<Articulo>();
		setEstado("Local");
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
		
	}

	/**
	 * Metodo para añadir articulos a la lista de pedido
	 * @param articuloDelCatalogo de tipo Articulo, articulo que quieres añadir
	 * @param unidades de tipo int, numero de articulos que quieres añadir
	 */
	public void add(Articulo articuloDelCatalogo, int unidades){
		Articulo articuloEnPedido = null;
	
		for (Articulo a : listaPedido){
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo()))
				articuloEnPedido = a;
		}
		
		if (articuloEnPedido == null){
			Articulo articuloAPedido = new Articulo(articuloDelCatalogo);
			articuloAPedido.setUnidades(unidades);
			listaPedido.add(articuloAPedido);
		}
		else{
			int totalUnidades = articuloEnPedido.getUnidades() + unidades;
			articuloEnPedido.setUnidades(totalUnidades);
		}
	}
	/**
	 * Metodo para eliminar articulos a la lista de pedido
	 * @param articuloDelCatalogo de tipo Articulo, articulo que quieres eliminar
	 * @param unidades de tipo int, numero de articulos que quieres eliminar
	 */
	public void remove(Articulo articuloEnPedido, int unidades) {
		
		int unidadesNuevas = articuloEnPedido.getUnidades() - unidades ;
		
		// Menos unidades de las que quieres eliminar	
		
		 if(articuloEnPedido.getUnidades()<=unidades) {
			for(int i = 0; i<listaPedido.size();i++) {
				if(listaPedido.get(i).getCodigo() == articuloEnPedido.getCodigo()) 
				listaPedido.remove(i);
			}
		}
		
		// Mas unidades de las que quieres eliminar 
		 
		 for(int i = 0; i<listaPedido.size();i++) {
				if(listaPedido.get(i).getCodigo() == articuloEnPedido.getCodigo()) {
					listaPedido.get(i).setUnidades(unidadesNuevas);
				}
		 }	
	}
	
	/**
	 * Metodo para calcular el precio total de todos los articulos de la lista pedido
	 * @return total de tipo Float
	 */
	public float calcularTotal(){
		float total = 0.0f;
		for (Articulo a : listaPedido){
			total += a.getPrecio()* a.getUnidades();
		}

		if(total > 50) {
			total = (float) (total * 0.9);
		}
		return total;
	}
	
	/**
	 * Metodo para grabar el pedido en un fichero
	 * @param nombreFichero de tipo String, fichero donde quieres grabar el pedido
	 */
	public void grabarPedido(String nombreFichero){
		FileUtil.saveToFile(nombreFichero, listaPedido, estado);
	  }
	
	/**
	 * Metodo para inicializar el pedido
	 */
	public void inicializar(){
		listaPedido.clear();
	}
	
	/**
	 * Metodo para saber las unidades que hay de un articulo en la lista
	 * @param articulo de tipo Articulo, articulo del que quieres buscar las unidades
	 * @return el numero de unidades de ese articulo de tipo int
	 */
	public int unidades(Articulo articulo) {
		for (Articulo a : listaPedido){
			if(a.getCodigo().equals(articulo.getCodigo()))
				return  a.getUnidades();
		}
		return 0;
	}
	
	/**
	 * Metodo para saber si el pedido esta vadio
	 * @return true de tipo boolean si esta vacio
	 * @return false de tipo boolean si no esta vacio
	 */
	public boolean isVacio() {
		return listaPedido.size() == 0;
	}
	
	/**
	 * Metodo para convertir el precio en un String con dos decimales
	 * @return el precio
	 */
	public String totalDosDecimales() {
		return String.format("%.2f", calcularTotal());
	}

	
	/**
	 * Metodo toString para utilizar al grabar en fichero
	 */
	@Override
	public String toString() {
		String sr = "";
		
		for(Articulo ar : listaPedido) {
			sr += ar.getDenominacion() + " - " + ar.getUnidades() + " uds.";
			sr += "\n";
		}
		sr += "Total: " + totalDosDecimales() + "€" + estado;
		return sr;
	}


	
	
}

