package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import player.MusicPlayer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.help.*;
import java.net.*;
import java.io.*;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnPlay;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JMenuItem itOpen;
	private JMenuItem itExit;
	private JSeparator separator;
	private JMenuItem itNext;
	private JMenuItem itRandom;
	private JMenuItem itContents;
	private JMenuItem itAbout;
	private JSeparator separator_1;
	private JPanel pnNorte;
	private JPanel pnCentro;
	private JPanel pnSur;
	private JLabel lblNewLabel;
	private JLabel lbLogo;
	private JSlider slVolumen;
	private JLabel lbVol;
	private JTextField txVolumen;
	private JPanel pnLibrary;
	private JPanel pnPlay;
	private JLabel lbLibrary;
	private JScrollPane scListLibrary;
	
	
	private JList<File> listLibrary;
	private JList<File> listPlay;

	private DefaultListModel<File> modelListLibrary;
	private DefaultListModel<File> modelListPlay;
	
		
	private JPanel pnBtLibrary;
	private JButton btAddLib;
	private JButton btDelLib;
	private JLabel lbPLay;
	private JScrollPane scListPlay;
	private JPanel pnBtPlay;
	private JButton btRewind;
	private JButton btPlay;
	private JButton btStop;
	private JButton btForward;
	private JButton btDelete;
	private JPanel pnVolumen;
	private JFileChooser selector;
	
	private MusicPlayer mp;



	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(MusicPlayer mp) {
		this.mp = mp;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setTitle("EII Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 515);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		contentPane.add(getPnSur(), BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		cargaAyuda();
	}
	
	private void cargaAyuda() {

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();

		   hb.enableHelpKey(getRootPane(),"introduccion", hs);	//activa f1
		   hb.enableHelpOnButton(getItContents(), "introduccion", hs);	//asociar ayuda con elementos de menu o botones
		   hb.enableHelp(getBtAddLib(), "añadir", hs);
		   hb.enableHelp(getBtDelLib(), "eliminar", hs);
		   hb.enableHelp(getBtPlay(), "reproducir", hs);
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnPlay());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.setMnemonic('F');
			mnFile.add(getItOpen());
			mnFile.add(getSeparator());
			mnFile.add(getItExit());
		}
		return mnFile;
	}
	private JMenu getMnPlay() {
		if (mnPlay == null) {
			mnPlay = new JMenu("Play");
			mnPlay.setMnemonic('P');
			mnPlay.add(getItNext());
		}
		return mnPlay;
	}
	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.setMnemonic('O');
			mnOptions.add(getItRandom());
		}
		return mnOptions;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('H');
			mnHelp.add(getItContents());
			mnHelp.add(getSeparator_1());
			mnHelp.add(getItAbout());
		}
		return mnHelp;
	}
	private JMenuItem getItOpen() {
		if (itOpen == null) {
			itOpen = new JMenuItem("Open");
			itOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarFicheros();
				}
			});
			itOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			itOpen.setMnemonic('P');
		}
		return itOpen;
	}
	
	private JFileChooser getSelector() {
		if(selector==null) {
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);
			
			//crear un filtro
			selector.setFileFilter(new FileNameExtensionFilter("Archivos mp3", "mp3"));
			String path = System.getProperty("user.dir") + "/musica";
			selector.setCurrentDirectory(new File(path));

		}
		return selector;
	}
	/**
	 * Metodo para cargar ficheros a Library
	 */
	protected void cargarFicheros() {
		//Recorro lo que tengo seleccionado y lo añado al modelo de la lista library
		if(getSelector().showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			for(int i=0;i<getSelector().getSelectedFiles().length;i++) {
				modelListLibrary.addElement(getSelector().getSelectedFiles()[i]);
			}
		}
		
	}
	
	/**
	 * Metodo que borra de la lista de Library
	 */
	protected void borrarListLibrary() {
		// Lo borro del modelo para eliminarlo de la lista
		
		java.util.List<File> cancionesBorrar = getListLibrary().getSelectedValuesList();
		
		for(int i = 0; i<cancionesBorrar.size(); i++) {
			modelListLibrary.removeElement(cancionesBorrar.get(i));
		}
		
		
		
		/* Esta mal esta forma de borrar


		for(int i = 0; i<getListLibrary().getSelectedValuesList().size(); i++) {
			modelListLibrary.removeElement(getListLibrary().getSelectedValuesList().get(i));
			*/
		
	}


	private JMenuItem getItExit() {
		if (itExit == null) {
			itExit = new JMenuItem("Exit");
			itExit.setMnemonic('X');
			itExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return itExit;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getItNext() {
		if (itNext == null) {
			itNext = new JMenuItem("Next");
			itNext.setEnabled(false);
			itNext.setMnemonic('n');
		}
		return itNext;
	}
	private JMenuItem getItRandom() {
		if (itRandom == null) {
			itRandom = new JMenuItem("Random");
			itRandom.setEnabled(false);
			itRandom.setMnemonic('R');
		}
		return itRandom;
	}
	private JMenuItem getItContents() {
		if (itContents == null) {
			itContents = new JMenuItem("Contents");
			itContents.setMnemonic('C');
			itContents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return itContents;
	}
	private JMenuItem getItAbout() {
		if (itAbout == null) {
			itAbout = new JMenuItem("About");
			itAbout.setMnemonic('B');
		}
		return itAbout;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			pnNorte.setBackground(Color.BLACK);
			pnNorte.setLayout(new GridLayout(0, 3, 0, 0));
			pnNorte.add(getLbLogo());
			pnNorte.add(getSlVolumen());
			pnNorte.add(getPnVolumen());
		}
		return pnNorte;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(new GridLayout(0, 2, 0, 0));
			pnCentro.add(getPnLibrary());
			pnCentro.add(getPnPlay());
		}
		return pnCentro;
	}
	private JPanel getPnSur() {
		if (pnSur == null) {
			pnSur = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnSur.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnSur.add(getLblNewLabel());
		}
		return pnSur;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Reproduciendo cancion 1 ...");
		}
		return lblNewLabel;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lbLogo.setBackground(Color.BLACK);
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return lbLogo;
	}
	private JSlider getSlVolumen() {
		if (slVolumen == null) {
			slVolumen = new JSlider();
			slVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					cambiarVolumen();
				}
			});
			slVolumen.setFocusable(false);
			slVolumen.setPaintTicks(true);
			slVolumen.setFont(new Font("Dialog", Font.BOLD, 14));
			slVolumen.setBackground(Color.BLACK);
			slVolumen.setForeground(Color.WHITE);
			slVolumen.setPaintLabels(true);
			slVolumen.setMinorTickSpacing(10);
			slVolumen.setMajorTickSpacing(20);
		}
		return slVolumen;
	}
	protected void cambiarVolumen() {
		getTxVolumen().setText(String.valueOf(getSlVolumen().getValue()));
		mp.setVolume(getSlVolumen().getValue(), getSlVolumen().getMaximum());
		
	}

	private JLabel getLbVol() {
		if (lbVol == null) {
			lbVol = new JLabel("Vol:");
			lbVol.setHorizontalAlignment(SwingConstants.RIGHT);
			lbVol.setForeground(new Color(255, 127, 80));
			lbVol.setFont(new Font("Dialog", Font.BOLD, 32));
		}
		return lbVol;
	}
	private JTextField getTxVolumen() {
		if (txVolumen == null) {
			txVolumen = new JTextField();
			txVolumen.setHorizontalAlignment(SwingConstants.LEFT);
			txVolumen.setFont(new Font("Dialog", Font.BOLD, 32));
			txVolumen.setText("50");
			txVolumen.setEditable(false);
			txVolumen.setForeground(Color.WHITE);
			txVolumen.setBackground(Color.BLACK);
			txVolumen.setColumns(10);
		}
		return txVolumen;
	}
	private JPanel getPnLibrary() {
		if (pnLibrary == null) {
			pnLibrary = new JPanel();
			pnLibrary.setBackground(Color.BLACK);
			pnLibrary.setLayout(new BorderLayout(0, 0));
			pnLibrary.add(getLbLibrary(), BorderLayout.NORTH);
			pnLibrary.add(getScListLibrary(), BorderLayout.CENTER);
			pnLibrary.add(getPnBtLibrary(), BorderLayout.SOUTH);
		}
		return pnLibrary;
	}
	private JPanel getPnPlay() {
		if (pnPlay == null) {
			pnPlay = new JPanel();
			pnPlay.setBackground(Color.BLACK);
			pnPlay.setLayout(new BorderLayout(0, 0));
			pnPlay.add(getLbPLay(), BorderLayout.NORTH);
			pnPlay.add(getScListPlay(), BorderLayout.CENTER);
			pnPlay.add(getPnBtPlay(), BorderLayout.SOUTH);
		}
		return pnPlay;
	}
	private JLabel getLbLibrary() {
		if (lbLibrary == null) {
			lbLibrary = new JLabel("\u266A"+"Library:");
			lbLibrary.setFont(new Font("Dialog", Font.BOLD, 18));
			lbLibrary.setForeground(new Color(255, 127, 80));
		}
		return lbLibrary;
	}
	private JScrollPane getScListLibrary() {
		if (scListLibrary == null) {
			scListLibrary = new JScrollPane();
			scListLibrary.setBorder(new LineBorder(new Color(255, 140, 0), 4));
			scListLibrary.setViewportView(getListLibrary());
		}
		return scListLibrary;
	}
	private JList<File> getListLibrary() {
		if (listLibrary == null) {
			modelListLibrary = new DefaultListModel<File>();
			listLibrary = new JList<File>(modelListLibrary); //IMPORTANTE, asociar el modelo con el JList
			listLibrary.setBackground(Color.BLACK);
		}
		return listLibrary;
	}
	
	private JList<File> getListPlay() {
		if (listPlay == null) {
			modelListPlay = new DefaultListModel<File>();
			listPlay = new JList<File>(modelListPlay);
			listPlay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listPlay.setBackground(Color.BLACK);

		}
		return listPlay;
	}
	
	private JPanel getPnBtLibrary() {
		if (pnBtLibrary == null) {
			pnBtLibrary = new JPanel();
			pnBtLibrary.setBackground(Color.BLACK);
			pnBtLibrary.setLayout(new GridLayout(0, 2, 0, 0));
			pnBtLibrary.add(getBtAddLib());
			pnBtLibrary.add(getBtDelLib());
		}
		return pnBtLibrary;
	}
	private JButton getBtAddLib() {
		if (btAddLib == null) {
			btAddLib = new JButton("Add to playlist");
			btAddLib.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirAListPlay();
				}
			});
			btAddLib.setMnemonic('A');
			btAddLib.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btAddLib;
	}
	
	/**
	 * Metodo para pasar de la lista libreria a lisla Play
	 */
	protected void añadirAListPlay() {
		
		//Recorro lo que tengo seleccionado de la lista libreria y lo añado al modelo de la lista play
		for(int i = 0; i<getListLibrary().getSelectedValuesList().size(); i++) {
			modelListPlay.addElement(getListLibrary().getSelectedValuesList().get(i));
		}
	}

	private JButton getBtDelLib() {
		if (btDelLib == null) {
			btDelLib = new JButton("Delete");
			btDelLib.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarListLibrary();
				}
			});
			btDelLib.setMnemonic('D');
			btDelLib.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btDelLib;
	}
	

	private JLabel getLbPLay() {
		if (lbPLay == null) {
			lbPLay = new JLabel("\u266APlay:");
			lbPLay.setForeground(new Color(255, 127, 80));
			lbPLay.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return lbPLay;
	}
	private JScrollPane getScListPlay() {
		if (scListPlay == null) {
			scListPlay = new JScrollPane();
			scListPlay.setBorder(new LineBorder(new Color(255, 140, 0), 4));
			scListPlay.setViewportView(getListPlay());
		}
		return scListPlay;
	}

	private JPanel getPnBtPlay() {
		if (pnBtPlay == null) {
			pnBtPlay = new JPanel();
			pnBtPlay.setBackground(Color.BLACK);
			pnBtPlay.setLayout(new GridLayout(0, 5, 0, 0));
			pnBtPlay.add(getBtRewind());
			pnBtPlay.add(getBtPlay());
			pnBtPlay.add(getBtStop());
			pnBtPlay.add(getBtForward());
			pnBtPlay.add(getBtDelete());
		}
		return pnBtPlay;
	}
	private JButton getBtRewind() {
		if (btRewind == null) {
			btRewind = new JButton("\u25C4\u25C4");
			btRewind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancionAnterior();
				}
			});
			btRewind.setToolTipText("Rewind");
			btRewind.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btRewind;
	}
	protected void cancionAnterior() {
		int indiceSeleccionado = getListPlay().getSelectedIndex();
		if(indiceSeleccionado > 0) {
			getListPlay().setSelectedIndex(indiceSeleccionado-1);
		}
		mp.play(getListPlay().getSelectedValue());
	}
	protected void cancionSiguiente() {
		int indiceSeleccionado = getListPlay().getSelectedIndex();

			getListPlay().setSelectedIndex(indiceSeleccionado+1);
		
		mp.play(getListPlay().getSelectedValue());
	}
	
	private JButton getBtPlay() {
		if (btPlay == null) {
			btPlay = new JButton("\u25BA");
			btPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					playMusica();
				}
			});
			btPlay.setToolTipText("Play");
			btPlay.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btPlay;
	}
	protected void playMusica() {
		if(getListPlay().getSelectedIndex() == -1) {
			getListPlay().setSelectedIndex(0);
		}		
		mp.play(getListPlay().getSelectedValue());
		mp.setVolume(getSlVolumen().getValue(), getSlVolumen().getMaximum());
		
	}

	private JButton getBtStop() {
		if (btStop == null) {
			btStop = new JButton("\u25A0");
			btStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mp.stop();
				}
			});
			btStop.setToolTipText("Stop");
			btStop.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btStop;
	}
	private JButton getBtForward() {
		if (btForward == null) {
			btForward = new JButton("\u25BA\u25BA");
			btForward.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancionSiguiente();
					}
				
			});
			btForward.setToolTipText("Forward");
			btForward.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btForward;
	}
	private JButton getBtDelete() {
		if (btDelete == null) {
			btDelete = new JButton("Delete");
			btDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarPlay();
				}
			});
			btDelete.setMnemonic('L');
			btDelete.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btDelete;
	}
	protected void borrarPlay() {

		mp.stop();
		modelListPlay.removeElement(getListPlay().getSelectedValue());

		
	}

	private JPanel getPnVolumen() {
		if (pnVolumen == null) {
			pnVolumen = new JPanel();
			pnVolumen.setBackground(Color.BLACK);
			pnVolumen.setLayout(new GridLayout(0, 2, 0, 0));
			pnVolumen.add(getLbVol());
			pnVolumen.add(getTxVolumen());
		}
		return pnVolumen;
	}
}
