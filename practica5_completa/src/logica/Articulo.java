package logica;


public class Articulo {
	
	private String codigo;
	private String tipo;
	private String denominacion;
	private float precio;
	private int unidades;
	private String foto;
	
	/**
	 * Constructor con parámetros
	 * @param codigo de tipo String
	 * @param tipo de tipo String 
	 * @param denominacion de tipo String
	 * @param precio de tipo float
	 * @param unidades de tipo int
	 */
	public Articulo(String codigo, String tipo, String denominacion, float precio, int unidades){
		this.codigo = codigo;
		this.tipo = tipo;
		this.denominacion = denominacion;
		this.precio = precio;
		this.unidades = unidades;
		this.foto = "/img/" +codigo+".png";
	}
	
	/**
	 * Constructor con un parametro articulo, que utiliza el constructor principal de base
	 * @param otroArticulo de tipo Articulo
	 */
	public Articulo (Articulo otroArticulo) {
        this(otroArticulo.codigo, otroArticulo.tipo, otroArticulo.denominacion, otroArticulo.precio, otroArticulo.unidades);
    }
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo que te dice la foto que es
	 * @return foto de tipo String
	 */
	public String getFoto() {
		return foto;
	}
	
	/**
	 * Metodo para elegir la foto
	 * @param foto de tipo String 
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	/**
	 * Metodo que te dice la denominación
	 * @return denominacion de tipo Stirng
	 */
	public String getDenominacion() {
		return denominacion;
	}
	
	/**
	 * Metodo para elegir la denominacion
	 * @param denominacion de tipo String
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	/**
	 * Metodo para saber el precio
	 * @return precio de tipo float
	 */
	public float getPrecio() {
		return precio;
	}
	
	/**
	 * Metodo para elegir el precio
	 * @param precio de tipo float
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	/**
	 * Metodo para saber el codigo
	 * @return codigo de tipo String
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo para elegir el codigo
	 * @param codigo de tipo String
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo para saber las unidades
	 * @return unidades de tipo int
	 */
	public int getUnidades() {
		return unidades;
	}
	
	/**
	 * Metodo para elegir las unidades
	 * @param unidades de tipo int
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	/**
	 * Metodo toString
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.tipo);
		buffer.append(" - ");
		buffer.append(this.denominacion);
		buffer.append(" - ");
		buffer.append(this.precio);
		buffer.append(" €");
		//Ya no hace falta para que el combo haga de carrito pero sí para guardar el pedido en el fichero
		if (this.unidades!=0){
			buffer.append(" (");
			buffer.append(this.unidades);
			buffer.append(" uds)");
			}
		return buffer.toString();
	   }
}
