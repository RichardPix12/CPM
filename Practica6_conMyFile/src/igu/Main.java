package igu;

import java.awt.EventQueue;
import java.util.Properties;
import player.MusicPlayer;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.jtattoo.plaf.hifi.*;


public class Main {
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties props = new Properties();
					props.put("logoString", "");
					HiFiLookAndFeel.setCurrentTheme(props);
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					MusicPlayer mp = new MusicPlayer();
					VentanaPrincipal frame = new VentanaPrincipal(mp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
