package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.LineBorder;

import logica.Dado;
import logica.Juego;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btDado;
	private JLabel lbNave;
	private JLabel lbPlaneta;
	private JTextField txPuntos;
	private JLabel lbPuntos;
	private JPanel pnDisparos;
	private JPanel pnTablero;
	private JButton bt0;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt7;
	private Juego juego;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnAyuda;
	private JMenuItem mnItNuevo;
	private JMenuItem mnItSalir;
	private JSeparator separardorJuego;
	private JMenuItem mnItContenidos;
	private JMenuItem mnItAcercaDe;
	private JSeparator separatorAyuda;
	private ProcesaBotones pBts;



	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Juego juego) {
		pBts= new ProcesaBotones();
		this.juego = juego;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/invader.jpg")));
		setTitle("Invasi\u00F3n Espacial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 422);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtDado());
		contentPane.add(getLbNave());
		contentPane.add(getLbPlaneta());
		contentPane.add(getTxPuntos());
		contentPane.add(getLbPuntos());
		contentPane.add(getPnDisparos());
		contentPane.add(getPnTablero());
		setLocationRelativeTo(null);
		habilitaTablero(false);
	}
	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton("");
			btDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			btDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					iniciarJuego();
				}
			});
			btDado.setToolTipText("Haga click para lanzar el dado");
			btDado.setBorderPainted(false);
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dice.jpg")));
			btDado.setBounds(33, 31, 111, 113);
		}
		return btDado;
	}
	
	private void reiniciarJuego() {
		//1.Logica
		
		//1.1 reiniciar juego
		juego.inicializarJuego();
		//2.Interfaz
			
			//2.1 deshabilitar tablero
			habilitaTablero(false);
			
			//2.2 Mostrar los disparos
			despintaDisparos();
			
			//2.3 Despinta tablero de juego
			despintaTablero();
			
			//2.4 mostrar los puntos iniciales
			getTxPuntos().setText(String.valueOf(juego.getPuntos()));
			
			//2.5 activa dado
			getBtDado().setEnabled(true);
		
	}
	
	private void iniciarJuego() {
		
		//1. lanzar dado
		juego.lanzar();
		
		//2. Mostrar los dispados
		pintaDisparos();
		
		//3. Habilitar tablero
		habilitaTablero(true);
		
		//4. Deshabilitar dado
		getBtDado().setEnabled(false);
		
	}
	
	private void pintaDisparos() {
		for(int i=0; i<juego.getDisparos();i++) {
			getPnDisparos().add(nuevoDisparo());
		}
		validate();
	}
	
	private void despintaDisparos() {	
		getPnDisparos().removeAll();			
	}
	
	private JLabel nuevoDisparo() {
		JLabel lbDisparo;

		lbDisparo = new JLabel("");
		lbDisparo.setIcon(ImagenFactoria.getImagen());
		lbDisparo.setBorder(new LineBorder(Color.GREEN));

		return lbDisparo;
	}
	
	private JLabel getLbNave() {
		if (lbNave == null) {
			lbNave = new JLabel("");
			lbNave.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/spaceship.png")));
			lbNave.setBounds(342, 25, 137, 97);
		}
		return lbNave;
	}
	private JLabel getLbPlaneta() {
		if (lbPlaneta == null) {
			lbPlaneta = new JLabel("");
			lbPlaneta.setHorizontalAlignment(SwingConstants.CENTER);
			lbPlaneta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/earth.jpg")));
			lbPlaneta.setBounds(797, 11, 185, 175);
		}
		return lbPlaneta;
	}
	private JTextField getTxPuntos() {
		if (txPuntos == null) {
			txPuntos = new JTextField();
			txPuntos.setEditable(false);
			txPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			txPuntos.setFont(new Font("Consolas", Font.BOLD, 30));
			txPuntos.setForeground(Color.GREEN);
			txPuntos.setBackground(Color.BLACK);
			txPuntos.setBounds(622, 64, 97, 36);
			txPuntos.setColumns(10);
			txPuntos.setText(String.valueOf(juego.getPuntos()));
		}
		return txPuntos;
	}
	private JLabel getLbPuntos() {
		if (lbPuntos == null) {
			lbPuntos = new JLabel("Puntos");
			lbPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			lbPuntos.setForeground(Color.WHITE);
			lbPuntos.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lbPuntos.setBounds(622, 31, 97, 27);
		}
		return lbPuntos;
	}
	private JPanel getPnDisparos() {
		if (pnDisparos == null) {
			pnDisparos = new JPanel();
			pnDisparos.setBackground(Color.BLACK);
			pnDisparos.setBounds(191, 131, 431, 86);
		}
		return pnDisparos;
	}
	private JPanel getPnTablero() {
		if (pnTablero == null) {
			pnTablero = new JPanel();
			pnTablero.setBackground(Color.BLUE);
			pnTablero.setBorder(new LineBorder(Color.BLUE, 5));
			pnTablero.setBounds(10, 263, 990, 98);
			pnTablero.setLayout(new GridLayout(1, 8, 5, 0));
			pnTablero.add(getBt0());
			pnTablero.add(getBt1());
			pnTablero.add(getBt2());
			pnTablero.add(getBt3());
			pnTablero.add(getBt4());
			pnTablero.add(getBt5());
			pnTablero.add(getBt6());
			pnTablero.add(getBt7());
		}
		return pnTablero;
	}
	
	private void dispara(int i) {
		//1 Lógica:
		juego.dispara(i);
		
		//2 Interfaz:
			//2.1 actualizar puntos
			getTxPuntos().setText(String.valueOf(juego.getPuntos()));
			
			//2.2 eliminar de la interfaz un disparo
			despintaDisparo();
			
			//2.3 pintar la casilla
			pintarCasilla(i);
			
			//2.4 desactivar ese botón para que no pueda volver a clickarse
			((JButton)getPnTablero().getComponents()[i]).setEnabled(false);
			
			//2.5 finalizar partida
			if(juego.isPartidaFinalizada()) {
			finalizarPartida();
			}
		
		
	}
	
	private void finalizarPartida() {

			if(juego.getInvasorEncontrado()) {
				habilitaTablero(false);
				JOptionPane.showMessageDialog(this, "Enhorabuena has ganado y has encontrado al invasor","Invasion espacial", JOptionPane.INFORMATION_MESSAGE);
				pintaTablero();
			}
			else if(juego.getMeteoritoEncontrado()) {
				habilitaTablero(false);
				JOptionPane.showMessageDialog(this, "Lo siento, te has encontrado el meteorito y has perdido ","Invasion espacial", JOptionPane.INFORMATION_MESSAGE);
				pintaTablero();
			}
			else{
				habilitaTablero(false);
				JOptionPane.showMessageDialog(this, "Lo siento, no has encontrado al invasor y has perdido","Invasion espacial", JOptionPane.INFORMATION_MESSAGE);
				pintaTablero();
			}
			
		
	}
	
	private void pintaTablero() {
		ImageIcon imagen = null;
		
		for(int i = 0; i<getPnTablero().getComponents().length;i++) {			
			imagen = ImagenFactoria.getImagen(juego.getTablero().getCasillas()[i]);			
			((JButton)getPnTablero().getComponents()[i]).setIcon(imagen);
			((JButton)getPnTablero().getComponents()[i]).setDisabledIcon(imagen);
		}
	}
	
	private void despintaTablero() {
		for(int i = 0; i<getPnTablero().getComponents().length;i++) {					
			((JButton)getPnTablero().getComponents()[i]).setIcon(null);
			((JButton)getPnTablero().getComponents()[i]).setDisabledIcon(null);	
		}
	}
	
	private void pintarCasilla(int i) {
		
		ImageIcon imagen = ImagenFactoria.getImagen(juego.getTablero().getCasillas()[i]);
		
		((JButton)getPnTablero().getComponents()[i]).setIcon(imagen);
		((JButton)getPnTablero().getComponents()[i]).setDisabledIcon(imagen);
	}
	
	private void despintaDisparo() {
		getPnDisparos().remove(0);
		getPnDisparos().repaint();
	}
	
	
	class ProcesaBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton)e.getSource();
			dispara(Integer.valueOf(boton.getActionCommand()));
			

		}
		
	}
	
	
	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton("");
			bt0.setActionCommand("0");
			bt0.addActionListener(pBts);
			/*bt0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(0);
				}
			});
			*/
			bt0.setForeground(Color.WHITE);
			bt0.setBackground(Color.BLACK);
		}
		return bt0;
	}
	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton("");
			bt1.setActionCommand("1");
			bt1.addActionListener(pBts);
			/*bt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(1);
				}
			});
			*/
			bt1.setForeground(Color.WHITE);
			bt1.setBackground(Color.BLACK);
		}
		return bt1;
	}
	private JButton getBt2() {
		if (bt2 == null) {
			bt2 = new JButton("");
			bt2.setActionCommand("2");
			bt2.addActionListener(pBts);
			/*
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(2);
				}
			});
			*/
			bt2.setForeground(Color.WHITE);
			bt2.setBackground(Color.BLACK);
		}
		return bt2;
	}
	private JButton getBt3() {
		if (bt3 == null) {
			bt3 = new JButton("");
			bt3.setActionCommand("3");
			bt3.addActionListener(pBts);
			/*
			bt3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(3);
				}
			});
			*/
			bt3.setForeground(Color.WHITE);
			bt3.setBackground(Color.BLACK);
		}
		return bt3;
	}
	private JButton getBt4() {
		if (bt4 == null) {
			bt4 = new JButton("");
			bt4.setActionCommand("4");
			bt4.addActionListener(pBts);
			/*
			bt4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(4);
				}
			});
			*/
			bt4.setForeground(Color.WHITE);
			bt4.setBackground(Color.BLACK);
		}
		return bt4;
	}
	private JButton getBt5() {
		if (bt5 == null) {
			bt5 = new JButton("");
			bt5.setActionCommand("5");
			bt5.addActionListener(pBts);
			/*
			bt5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(5);
				}
			});
			*/
			bt5.setForeground(Color.WHITE);
			bt5.setBackground(Color.BLACK);
		}
		return bt5;
	}
	private JButton getBt6() {
		if (bt6 == null) {
			bt6 = new JButton("");
			bt6.setActionCommand("0");
			bt6.addActionListener(pBts);
			/*
			bt6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(6);
				}
			});
			*/
			bt6.setForeground(Color.WHITE);
			bt6.setBackground(Color.BLACK);
		}
		return bt6;
	}
	private JButton getBt7() {
		if (bt7 == null) {
			bt7 = new JButton("");
			bt7.setActionCommand("7");
			bt7.addActionListener(pBts);
			/*
			bt7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispara(7);
				}
			});
			*/
			bt7.setForeground(Color.WHITE);
			bt7.setBackground(Color.BLACK);
		}
		return bt7;
	}
	
	private void habilitaTablero(boolean estado) {		
		for(int i = 0; i<getPnTablero().getComponents().length;i++) {			
			(getPnTablero().getComponents()[i]).setEnabled(estado);		
		}
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('J');
			mnJuego.add(getMnItNuevo());
			mnJuego.add(getSeparardorJuego());
			mnJuego.add(getMnItSalir());
		}
		return mnJuego;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('A');
			mnAyuda.add(getMnItContenidos());
			mnAyuda.add(getSeparatorAyuda());
			mnAyuda.add(getMnItAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMnItNuevo() {
		if (mnItNuevo == null) {
			mnItNuevo = new JMenuItem("Nuevo");
			mnItNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reiniciarJuego();
				}
			});
			mnItNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			mnItNuevo.setMnemonic('N');
		}
		return mnItNuevo;
	}
	private JMenuItem getMnItSalir() {
		if (mnItSalir == null) {
			mnItSalir = new JMenuItem("Salir");
			mnItSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mnItSalir.setMnemonic('S');
		}
		return mnItSalir;
	}
	private JSeparator getSeparardorJuego() {
		if (separardorJuego == null) {
			separardorJuego = new JSeparator();
		}
		return separardorJuego;
	}
	private JMenuItem getMnItContenidos() {
		if (mnItContenidos == null) {
			mnItContenidos = new JMenuItem("Contenidos");
			mnItContenidos.setMnemonic('C');
			mnItContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Ayuda no disponible", "Contenidos de la ayuda",JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mnItContenidos;
	}
	private JMenuItem getMnItAcercaDe() {
		if (mnItAcercaDe == null) {
			mnItAcercaDe = new JMenuItem("Acerca de");
			mnItAcercaDe.setMnemonic('R');
			mnItAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Aplicacion para Invasion Espacial v1.0 \n "
							+ "Prácticas CMP 20-21 \n EII Oviedo", "Acerca de Invasion Espacial",JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mnItAcercaDe;
	}
	private JSeparator getSeparatorAyuda() {
		if (separatorAyuda == null) {
			separatorAyuda = new JSeparator();
		}
		return separatorAyuda;
	}
}
