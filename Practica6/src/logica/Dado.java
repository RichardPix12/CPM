package logica;

public class Dado {
	
	public static int lanzar()
	{ 
		//genera un valor entre 1 y Juego.maxDisparos
		return ((int) (Math.random() * Juego.maxDisparos) + 1);
	}


}
