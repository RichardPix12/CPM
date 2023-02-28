package logica;

public class McDonalds {
	
	private Carta carta;
	private Pedido pedido;
	
	public McDonalds() {
		this.carta = new Carta();
		this.pedido = new Pedido();
	}
	
	public void verCarta() {
		
		Articulo[] art = carta.getArticulos();
		
		for(Articulo ar : art) {
			ar.toString();
		}
	}
	
	public void añadirArticulo(Articulo articuloDelCatalogo,int unidades){
		pedido.add(articuloDelCatalogo, unidades);
		pedido.calcularTotal();
	}
	

	
	public void hacerPedido() {
		pedido.calcularTotal();
		pedido.grabarPedido("1XtYn7br2L.dat");
		pedido.inicializar();
		
	}
	
	
}
