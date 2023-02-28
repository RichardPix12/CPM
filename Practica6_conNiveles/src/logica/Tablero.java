package logica;

public class Tablero {


	Casilla[] casillas;
	int dimensiones;
	int meteoritos;
	int invasores;
	
	public Tablero(int nivel) {
		
		inicializaValores(nivel);
		
		casillas = new Casilla[dimensiones];
		for (int i=0;i<dimensiones;i++) {
			casillas[i] = new Espacio(i);
			System.out.print((i+1));
				
		}	
		// Nuevo
		colocaInvasor();
		colocaMeteorito();
	}
	
	public void inicializaValores(int nivel) {
		

		if (nivel == 1) {
			dimensiones = 10;
			invasores = 2;
			meteoritos = 0;
		}
		if(nivel == 2) {
			dimensiones = 8;
			invasores = 1;
			meteoritos = 1;
		}
		if(nivel ==3) {
			dimensiones = 6;
			invasores = 1;
			meteoritos = 2;
		}
	}

	private void colocaInvasor() {
		int posicionInvasor = (int) (Math.random() * dimensiones);
		int numeroInvasores = invasores;
		
		while(numeroInvasores>0) {
			if(casillas[posicionInvasor] instanceof Espacio) {
				casillas[posicionInvasor] = new Invasor(posicionInvasor);
				System.out.println(" Invasor" + (posicionInvasor+1));
				numeroInvasores--;
				posicionInvasor = (int) (Math.random() * dimensiones);
			}
			else {
				posicionInvasor = (int) (Math.random() * dimensiones);
			}
		}
	}
	
	private void colocaMeteorito() {
		int posicionMeteorito = (int) (Math.random() * dimensiones);
		int numeroMeteoritos = meteoritos ;
		
		while(numeroMeteoritos>0) {
			if(casillas[posicionMeteorito] instanceof Espacio) {
				casillas[posicionMeteorito] = new Meteorito(posicionMeteorito);
				numeroMeteoritos--;
				System.out.println("Meteorito" + (posicionMeteorito+1));
				posicionMeteorito = (int) (Math.random() * dimensiones);
			}
			else {
				posicionMeteorito = (int) (Math.random() * dimensiones);
			}
		}						

	}

	public Casilla[] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[] casillas) {
		this.casillas = casillas;
	}

}
