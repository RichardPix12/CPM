package logica;

public class Juego {
	
	public static final int maxDisparos = 4;
	int puntos;
	int disparos;
	private Tablero tablero; 
	private boolean invasorEncontrado;
	private boolean meteoritoEncontrado;
	
	public Tablero getTablero() {
		return tablero;
	}

	public Juego(){
		inicializarJuego();
	}
	
	public void inicializarJuego(){
		tablero = new Tablero();
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
		setDisparos(Dado.lanzar());	
		System.out.println("Disparos =" + disparos);
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
	
}
