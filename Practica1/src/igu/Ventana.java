package igu;
import java.awt.Color;

import javax.swing.*;


public class Ventana extends JFrame {
	
	JPanel pnPrincipal;
	JButton btAceptar;
	JLabel lbNombre;  // text; setText(); getText();
	JTextField txNombre; // text; setText(); getText();

	public Ventana() {
		setTitle("Ventana Principal");   // Titulo
		setBounds(20, 20, 500, 500);     // Dimesion (x,y,altura,anchura)
		setLocationRelativeTo(null);	 // Coloca en el centro de la pantalla
		
		pnPrincipal = new JPanel(); 	//Creo el panel que va dentro del marco
		pnPrincipal.setBackground(Color.BLUE);  //Cambiar el color de fondo del panel
		pnPrincipal.setLayout(null);     // Metodo para poder dise�ar la pantalla, y m�s tarde coloco el Layout
		
		
		setContentPane(pnPrincipal); 	//Asocia el panel creado con el marco
		
		btAceptar = new JButton(); 		//Creo el boton que voy a a�adir al panel
		btAceptar.setText("Aceptar");   // Texto que habr� en el bot�n
		btAceptar.setBackground(Color.CYAN); // Color de fondo del bot�n
		btAceptar.setBounds(300, 400, 100, 25);

		
		pnPrincipal.add(btAceptar); 	//A�ado el boton al panel
		
		lbNombre = new JLabel();
		lbNombre.setText("Introduzca su nombre:");
		lbNombre.setBounds(50, 100, 145, 10);
		lbNombre.setForeground(Color.WHITE);
		
		pnPrincipal.add(lbNombre);

	}

	public static void main(String[] args) {
		
		Ventana v = new Ventana();
		v.setVisible(true);
	}

}
