package logica;

public class Tablero {
	
	public static final int DIM = 8;
	Casilla[] casillas;
	
	public Tablero() {
		casillas = new Casilla[DIM];
		for (int i=0;i<DIM;i++)
			casillas[i] = new Espacio(i);
		// Nuevo
		colocaInvasor();
		colocaMeteorito();
	}

	private void colocaInvasor() {
		int posicionInvasor = (int) (Math.random() * DIM);
		casillas[posicionInvasor] = new Invasor(posicionInvasor);
		System.out.println("Invasor" + (posicionInvasor+1));
	}
	
	private void colocaMeteorito() {
		int posicionMeteorito = (int) (Math.random() * DIM);
		int i = 1;
		
		while(i>0) {
			if(casillas[posicionMeteorito] instanceof Espacio) {
				casillas[posicionMeteorito] = new Meteorito(posicionMeteorito);
				i--;
			}
			else {
				posicionMeteorito = (int) (Math.random() * DIM);
			}
		}						
		System.out.println("Meteorito" + (posicionMeteorito+1));
	}

	public Casilla[] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[] casillas) {
		this.casillas = casillas;
	}

}
