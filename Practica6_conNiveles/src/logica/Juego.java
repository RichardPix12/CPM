package logica;

public class Juego {
	
	public static int maxDisparos = 4;
	int puntos;
	
	//Ampliacion por niveles
	
	int nivel;
	int disparos;
	private Tablero tablero; 
	private boolean invasorEncontrado;
	private boolean meteoritoEncontrado;
	
	public Tablero getTablero() {
		return tablero;
	}

	public Juego(){
		inicializarJuego(2);
	}
	
	public void inicializarJuego(int nivel){
		this.nivel = nivel;
		
		tablero = new Tablero(nivel);
		puntos = 800;
		disparos = 0;
		invasorEncontrado = false;
		meteoritoEncontrado = false;
	}

	public void dispara(int i){
		disparos --;
		if (tablero.getCasillas()[i] instanceof Invasor) {
			invasorEncontrado = true;
		}
		else if(tablero.getCasillas()[i] instanceof Meteorito) {
			meteoritoEncontrado = true;
			puntos = tablero.getCasillas()[i].getPuntos();
		}
		puntos += tablero.getCasillas()[i].getPuntos();
	}
	
	public boolean isPartidaFinalizada() {
		return (invasorEncontrado || disparos == 0 || meteoritoEncontrado);
	}

	public int getPuntos() {
		return puntos;
	}

	public void lanzar() {
		disparosMaximos();
		setDisparos(Dado.lanzar());	
		System.out.println("Disparos =" + disparos);
	}
	
	private void disparosMaximos() {
		if (nivel == 1) {
			maxDisparos = 5;
		}
		if(nivel == 2) {
			maxDisparos = 4;
		}
		if(nivel ==3) {
			maxDisparos = 3;
		}
		
	}

	public int getDisparos() {
		return disparos;
	}

	private void setDisparos(int disparos) {
		this.disparos = disparos;
	}
	
	public boolean getInvasorEncontrado() {
		return invasorEncontrado;
	}
	
	public boolean getMeteoritoEncontrado() {
		return meteoritoEncontrado;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int getDimensiones() {
		return tablero.dimensiones;
	}
	
	
}
