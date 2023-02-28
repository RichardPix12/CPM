package igu;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import logica.*;

public class Main {
	/**
	 * Inicializa la aplicación
	 * @param args
	 */
	public static void main(String[] args) {
		Carta carta = new Carta();
		Pedido pedido = new Pedido();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(carta,pedido);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
