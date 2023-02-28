package igu;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import logica.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

import javax.swing.border.LineBorder;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;

import com.sun.javafx.font.directwrite.DWGlyphLayout;
import com.sun.webkit.dom.KeyboardEventImpl;
import java.awt.event.KeyAdapter;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblLblnombre;
	private Carta carta;
	private Pedido pedido;
	private JPanel pnInfo1;
	private JPanel pnlLogo;
	private JPanel pnArticulos;
	private AccionBoton aB;
	private JPanel pnBts1;
	private JPanel pnBts2;
	private JPanel pnBts3;
	private JPanel pnContenidos;
	private JPanel pn2;
	private JPanel pn3;
	private JPanel pnDatosCliente;
	private JLabel lbNombre;
	private JTextField txtNombre;
	private JLabel lbAño;
	private JComboBox<String> cbAños;
	private JLabel lbPasw1;
	private JPasswordField psw1;
	private JLabel lbPasw2;
	private JPasswordField psw2;
	private JPanel pn1;
	private JPanel pnFormulario;
	private JPanel pnDatosPedido;
	private JRadioButton rbLocal;
	private JRadioButton rbLlevar;
	private JPanel pnInfo2;
	private JPanel pnConfirmacion;
	private JPanel pnInfo3;
	private JLabel lbAviso;
	private JLabel lbOk;
	private JLabel lbCodigo;
	private JTextField txCodigo;
	private final ButtonGroup grPedido = new ButtonGroup();
	private JTabbedPane tbPnPedido;
	private JScrollPane scrComida;
	private JScrollPane scrBebida;
	private JList<Articulo> listComida;
	private JList<Articulo> listBebida;
	private DefaultListModel<Articulo> modelListComida;
	private DefaultListModel<Articulo> modelListBebida;
	private JTextField txPrecio;
	private JButton btAnular;
	private JButton btSig1;
	private JButton btSig2;
	private JButton btAnt1;
	private JButton btAnt2;
	private JButton btFinalizar;
	private JPanel pnFiltros;
	private JButton btHamburguesa;
	private JButton btBebida;
	private JButton btComplementos;
	private JButton btPostres;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				asociaImagenBotones();
				muestraDimension();
			}
		});
		carta = new Carta();
		pedido = new Pedido();
		aB = new AccionBoton();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		setTitle("McDonald's España");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 820);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnlLogo(), BorderLayout.NORTH);
		contentPane.add(getPnContenidos(), BorderLayout.CENTER);
	}
	
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		}
		return lblLogo;
	}
	private JLabel getLblLblnombre() {
		if (lblLblnombre == null) {
			lblLblnombre = new JLabel("McDonald's");
			lblLblnombre.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lblLblnombre.setForeground(Color.BLACK);
		}
		return lblLblnombre;
	}

	
	protected void inicializar() {
		//1.Logica
		pedido.inicializar();
		//COMPLETAR
		
		//2.Interfaz
		
		//2.1 Limpiar las listas
		modelListComida.clear();
		modelListBebida.clear();	
		//2.2 Poner a 0 el precio
		getTxPrecio().setText("Precio: 0.0");
		//2.3 desactivar siguiente
		getBtSig1().setEnabled(false);
		//2.4 Falta limpiar campos del formulario y de la ventana confirmación
		
			//2.4.1Cambiar el codigo de la ventana confirmación
			getTxCodigo().setText(FileUtil.setFileName());
		
		
	}
	
	private JPanel getPnInfo1() {
		if (pnInfo1 == null) {
			pnInfo1 = new JPanel();
			pnInfo1.setBackground(Color.WHITE);
			pnInfo1.setLayout(new BorderLayout(0, 0));
			pnInfo1.add(getPnBts1(),BorderLayout.SOUTH);
			pnInfo1.add(getTbPnPedido(), BorderLayout.NORTH);
		
		}
		return pnInfo1;
	}
	private JPanel getPnlLogo() {
		if (pnlLogo == null) {
			pnlLogo = new JPanel();
			pnlLogo.setBackground(Color.WHITE);
			pnlLogo.setLayout(new GridLayout(1, 0, 0, 0));
			pnlLogo.add(getLblLogo());
			pnlLogo.add(getLblLblnombre());
		}
		return pnlLogo;
	}
	private JPanel getPnArticulos() {
		if (pnArticulos == null) {
			pnArticulos = new JPanel();
			pnArticulos.setBorder(new LineBorder(Color.ORANGE, 4));
			pnArticulos.setBackground(Color.WHITE);
			// COMPLETAR 1
			pnArticulos.setLayout(new GridLayout(5,4,3,3));
			crearBotones();
			

		}
		return pnArticulos;
	}
	
	private void setImagenAdaptada(JButton boton, String rutaImagen){
		 Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage(); 
		 Image imgEscalada = imgOriginal.getScaledInstance(boton.getWidth(),boton.getHeight(), Image.SCALE_FAST);
		 ImageIcon icon = new ImageIcon(imgEscalada);
		 boton.setIcon(icon);
	}
	

	private void asociaImagenBotones() {
		for (int i = 0; i < pnArticulos.getComponents().length; i++)
		{
			JButton boton = (JButton) (pnArticulos.getComponents()[i]);
			setImagenAdaptada(boton,carta.getListaArticulos().get(i).getRutaFoto());
		}
		
	}

	private JButton nuevoBoton(Integer posicion) {
		
		Articulo a = carta.getListaArticulos().get(posicion);
		JButton boton = new JButton("");
		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setToolTipText(a.toString());
		boton.setActionCommand(posicion.toString());
		boton.addActionListener(aB);
		//boton.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(a.getRutaFoto())));
		//setImagenAdaptada(boton, a.getRutaFoto());

		return boton;
	}

	class AccionBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource();
			añadirAPedido(Integer.parseInt(bt.getActionCommand()));
		}
	}
	
	//COMPLETAR 2
	private void añadirAPedido(int posArticuloEnCarta) {
		//1.lógica
		
			//1.1 añadir el articulo a pedido
			Articulo articuloDelCatalogo = carta.getListaArticulos().get(posArticuloEnCarta);
			pedido.add(articuloDelCatalogo, 1);
		
		//2.Interfaz
			
			//2.1 Mostrar en la lista correspondiente
			mostrarEnLista(articuloDelCatalogo);
			//2.2 Calcular el precio
			String precio = String.format("%.2f", pedido.calcularTotalSinIva());
			txPrecio.setText("Precio = " + precio);
			
			//2.3 Activar el boton siguiente
			if(!getBtSig1().isEnabled()) {
				getBtSig1().setEnabled(true);
			}
			
	
	}
	
	//COMPLETAR 3
	private void mostrarEnLista(Articulo a) {
		if(a.getTipo().equals("Bebida")) {
			modelListBebida.addElement(a);
		}
		else {
			modelListComida.addElement(a);
		}
	}
	
	private JPanel getPnBts1() {
		if (pnBts1 == null) {
			pnBts1 = new JPanel();
			pnBts1.setBackground(Color.WHITE);
			pnBts1.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts1.add(getTxPrecio());
			pnBts1.add(getBtAnular());
			pnBts1.add(getBtSig1());
		}
		return pnBts1;
	}
	
	private JPanel getPnBts2() {
		if (pnBts2 == null) {
			pnBts2 = new JPanel();
			pnBts2.setBackground(Color.WHITE);
			pnBts2.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts2.add(getBtAnt1());
			pnBts2.add(getBtSig2());
			
			
		}
		return pnBts2;
	}
	
	private JPanel getPnBts3() {
		if (pnBts3 == null) {
			pnBts3 = new JPanel();
			pnBts3.setBackground(Color.WHITE);
			pnBts3.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts3.add(getBtAnt2());
			pnBts3.add(getBtFinalizar());
		}
		return pnBts3;
	}

	private JPanel getPnContenidos() {
		if (pnContenidos == null) {
			pnContenidos = new JPanel();
			pnContenidos.setLayout(new CardLayout(0, 0));
			pnContenidos.add(getPn1(), "pn1");
			pnContenidos.add(getPn2(), "pn2");
			pnContenidos.add(getPn3(), "pn3");
		}
		return pnContenidos;
	}
	
	private JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(Color.WHITE);
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getPnFormulario(), BorderLayout.CENTER);
			pn2.add(getPnInfo2(), BorderLayout.SOUTH);
		}
		return pn2;
	}
	
	private JPanel getPn3() {
		if (pn3 == null) {
			pn3 = new JPanel();
			pn3.setBackground(Color.WHITE);
			pn3.setLayout(new BorderLayout(0, 0));
			pn3.add(getPnConfirmacion());
			pn3.add(getPnInfo3(), BorderLayout.SOUTH);
		}
		return pn3;
	}
	
	private JComboBox<String> getCbAños() {
		if (cbAños == null) {
			String[]años = new String[90];
			for (int i=0;i<90;i++){
				String año = ""+((90-i)+1920);
				años[i]= año;
			}
			cbAños = new JComboBox<String>();
			cbAños.setFont(new Font("Arial", Font.PLAIN, 14));
			cbAños.setModel(new DefaultComboBoxModel<String>(años));
			cbAños.setBounds(new Rectangle(193, 77, 157, 25));
		}
		return cbAños;
	}
	
	private boolean isVacio() {
		return (txtNombre.getText().equals("")||(String.valueOf(psw1.getPassword()).equals(""))||(String.valueOf(psw2.getPassword()).equals(""))); 
	
	}
	
	private boolean isIncorrecta() {
		return (!String.valueOf(psw1.getPassword()).equals(String.valueOf(psw2.getPassword())));
	}
	
	private JPanel getPnDatosCliente() {
		if (pnDatosCliente == null) {
			pnDatosCliente = new JPanel();
			pnDatosCliente.setBounds(104, 58, 558, 224);
			pnDatosCliente.setBorder(new TitledBorder(null, "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatosCliente.setBackground(Color.WHITE);
			pnDatosCliente.setLayout(null);
			pnDatosCliente.add(getLbNombre());
			pnDatosCliente.add(getTxtNombre());
			pnDatosCliente.add(getLbAño());
			pnDatosCliente.add(getCbAños());
			pnDatosCliente.add(getLbPasw1());
			pnDatosCliente.add(getPsw1());
			pnDatosCliente.add(getLbPasw2());
			pnDatosCliente.add(getPsw2());
		}
		return pnDatosCliente;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel();
			lbNombre.setText("Nombre y Apellidos:");
			lbNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setBounds(30, 31, 132, 20);
		}
		return lbNombre;
	}
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));
			txtNombre.setBounds(193, 24, 330, 25);
		}
		return txtNombre;
	}
	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("A\u00F1o de nacimiento:");
			lbAño.setFont(new Font("Arial", Font.PLAIN, 14));
			lbAño.setDisplayedMnemonic('A');
			lbAño.setBounds(30, 81, 121, 16);
		}
		return lbAño;
	}

	private JLabel getLbPasw1() {
		if (lbPasw1 == null) {
			lbPasw1 = new JLabel();
			lbPasw1.setText("Password:");
			lbPasw1.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPasw1.setDisplayedMnemonic('P');
			lbPasw1.setBounds(new Rectangle(13, 123, 105, 16));
			lbPasw1.setBounds(30, 129, 105, 16);
		}
		return lbPasw1;
	}
	private JPasswordField getPsw1() {
		if (psw1 == null) {
			psw1 = new JPasswordField();
			psw1.setFont(new Font("Arial", Font.PLAIN, 14));
			psw1.setBounds(new Rectangle(176, 121, 218, 25));
			psw1.setBounds(193, 122, 218, 25);
		}
		return psw1;
	}
	private JLabel getLbPasw2() {
		if (lbPasw2 == null) {
			lbPasw2 = new JLabel();
			lbPasw2.setText("Reintroduzca password:");
			lbPasw2.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPasw2.setDisplayedMnemonic('R');
			lbPasw2.setBounds(new Rectangle(13, 167, 151, 16));
			lbPasw2.setBounds(30, 181, 151, 16);
		}
		return lbPasw2;
	}
	private JPasswordField getPsw2() {
		if (psw2 == null) {
			psw2 = new JPasswordField();
			psw2.setFont(new Font("Arial", Font.PLAIN, 14));
			psw2.setBounds(new Rectangle(176, 163, 218, 25));
			psw2.setBounds(193, 172, 218, 25);
		}
		return psw2;
	}
	
	public boolean comprobarCampos() {
		if (isVacio()) {
			JOptionPane.showMessageDialog(null, "Error: Hay algún campo en blanco");
			return false;
		}
		else
			if (isIncorrecta()) {
				JOptionPane.showMessageDialog(null, "Error: Las passwords no coinciden");
				return false;
			}
		return true;
	 }

	private void mostrarPn3() {
		if (comprobarCampos())
		{   
			 CardLayout c = (CardLayout)getPnContenidos().getLayout();
			 c.show(getPnContenidos(), "pn3");
			 getPnInfo3().add(getTbPnPedido());
			 getPnBts3().add(getTxPrecio(),0);
			 
		}
	}
	
	private JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setLayout(new BorderLayout(0, 0));
			pn1.add(getPnArticulos(), BorderLayout.CENTER);
			pn1.add(getPnInfo1(), BorderLayout.SOUTH);
			pn1.add(getPnFiltros(), BorderLayout.WEST);
		}
		return pn1;
	}
	
	private JPanel getPnFormulario() {
		if (pnFormulario == null) {
			pnFormulario = new JPanel();
			pnFormulario.setBorder(new LineBorder(Color.ORANGE, 4));
			pnFormulario.setBackground(Color.WHITE);
			pnFormulario.setLayout(null);
			pnFormulario.add(getPnDatosCliente());
			pnFormulario.add(getPnDatosPedido());
		}
		return pnFormulario;
	}
	private JPanel getPnDatosPedido() {
		if (pnDatosPedido == null) {
			pnDatosPedido = new JPanel();
			pnDatosPedido.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDatosPedido.setBackground(Color.WHITE);
			pnDatosPedido.setBounds(112, 304, 204, 60);
			pnDatosPedido.add(getRbLocal());
			pnDatosPedido.add(getRbLlevar());
		}
		return pnDatosPedido;
	}
	private JRadioButton getRbLocal() {
		if (rbLocal == null) {
			rbLocal = new JRadioButton();
			grPedido.add(rbLocal);
			rbLocal.setText("Local");
			rbLocal.setSelected(true);
			rbLocal.setMnemonic('L');
			rbLocal.setFont(new Font("Arial", Font.PLAIN, 14));
			rbLocal.setBounds(new Rectangle(17, 27, 94, 24));
			rbLocal.setBackground(Color.WHITE);
		}
		return rbLocal;
	}
	private JRadioButton getRbLlevar() {
		if (rbLlevar == null) {
			rbLlevar = new JRadioButton();
			grPedido.add(rbLlevar);
			rbLlevar.setText("Llevar");
			rbLlevar.setMnemonic('r');
			rbLlevar.setFont(new Font("Arial", Font.PLAIN, 14));
			rbLlevar.setBounds(new Rectangle(115, 27, 86, 24));
			rbLlevar.setBackground(Color.WHITE);
		}
		return rbLlevar;
	}
	private JPanel getPnInfo2() {
		if (pnInfo2 == null) {
			pnInfo2 = new JPanel();
			pnInfo2.setBackground(Color.WHITE);
			pnInfo2.setLayout(new BorderLayout(0, 0));
			pnInfo2.add(getPnBts2(),BorderLayout.SOUTH);
		}
		return pnInfo2;
	}
	private JPanel getPnConfirmacion() {
		if (pnConfirmacion == null) {
			pnConfirmacion = new JPanel();
			pnConfirmacion.setBorder(new LineBorder(Color.ORANGE, 4));
			pnConfirmacion.setBackground(Color.WHITE);
			pnConfirmacion.setLayout(null);
			pnConfirmacion.add(getLbAviso());
			pnConfirmacion.add(getLbOk());
			pnConfirmacion.add(getLbCodigo());
			pnConfirmacion.add(getTxCodigo());
		}
		return pnConfirmacion;
	}
	private JPanel getPnInfo3() {
		if (pnInfo3 == null) {
			pnInfo3 = new JPanel();
			pnInfo3.setBackground(Color.WHITE);
			pnInfo3.setLayout(new BorderLayout(0, 0));
			pnInfo3.add(getPnBts3(),BorderLayout.SOUTH);
		}
		return pnInfo3;
	}
	
	private void finalizar() {
		pedido.grabarPedido(getTxCodigo().getText());
		inicializar();
		//COMPLETAR
		mostrarPn1();
	}
	
	private JLabel getLbAviso() {
		if (lbAviso == null) {
			lbAviso = new JLabel("Estamos procesando su pedido");
			lbAviso.setFont(new Font("Tahoma", Font.BOLD, 28));
			lbAviso.setBounds(135, 104, 478, 35);
		}
		return lbAviso;
	}
	private JLabel getLbOk() {
		if (lbOk == null) {
			lbOk = new JLabel("");
			lbOk.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ok.png")));
			lbOk.setBounds(50, 91, 73, 52);
		}
		return lbOk;
	}
	private JLabel getLbCodigo() {
		if (lbCodigo == null) {
			lbCodigo = new JLabel("El c\u00F3digo de recogida es:");
			lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbCodigo.setBounds(138, 172, 191, 26);
		}
		return lbCodigo;
	}
	private JTextField getTxCodigo() {
		if (txCodigo == null) {
			txCodigo = new JTextField();
			txCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txCodigo.setEditable(false);
			txCodigo.setText(FileUtil.setFileName());
			txCodigo.setBounds(341, 161, 191, 45);
			txCodigo.setColumns(10);
		}
		return txCodigo;
	}
	private JTabbedPane getTbPnPedido() {
		if (tbPnPedido == null) {
			tbPnPedido = new JTabbedPane(JTabbedPane.TOP);
			tbPnPedido.addTab("Comida", null, getScrComida(), null);
			tbPnPedido.setMnemonicAt(0, KeyEvent.VK_C);
			tbPnPedido.setDisplayedMnemonicIndexAt(0, 0);
			tbPnPedido.addTab("Bebida", null, getScrBebida(), null);
			tbPnPedido.setMnemonicAt(1, KeyEvent.VK_B);
			tbPnPedido.setDisplayedMnemonicIndexAt(1, 0);
		}
		return tbPnPedido;
	}
	private JScrollPane getScrComida() {
		if (scrComida == null) {
			scrComida = new JScrollPane();
			scrComida.setViewportView(getListComida());
		}
		return scrComida;
	}
	private JScrollPane getScrBebida() {
		if (scrBebida == null) {
			scrBebida = new JScrollPane();
			scrBebida.setViewportView(getListBebida());
		}
		return scrBebida;
	}
	private JList<Articulo> getListComida() {
		if (listComida == null) {
			modelListComida = new DefaultListModel<Articulo>();
			listComida = new JList<Articulo>();
			listComida.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_DELETE) {
						
						if(listComida.getSelectedIndex()!=-1) {
						Articulo a = listComida.getSelectedValue();
						//1. Logica
						pedido.remove(a, 1);
						//2. Interfaz
							//2.1 borrar el elemento de la lista
							modelListComida.removeElement(a);
							//2.2 calcular precio
							getTxPrecio().setText("Precio: "+ pedido.calcularTotalSinIva());
							//2.3 si en las listas no queda elementos desactivar siguiente
								
					}
					}
				}
			});
			listComida.setModel(modelListComida);
		}
		return listComida;
	}
	private JList<Articulo> getListBebida() {
		if (listBebida == null) {
			modelListBebida = new DefaultListModel<Articulo>();
			listBebida = new JList<Articulo>();
			listBebida.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_DELETE) {
						
						if(listBebida.getSelectedIndex()!=-1) {
						Articulo a = listBebida.getSelectedValue();
						//1. Logica
						pedido.remove(a, 1);
						//2. Interfaz
							//2.1 borrar el elemento de la lista
							modelListBebida.removeElement(a);
							//2.2 calcular precio
							getTxPrecio().setText("Precio: "+ pedido.calcularTotalSinIva());
							//2.3 si en las listas no queda elementos desactivar siguiente
								
					}
					}
				}
			});
			listBebida.setModel(modelListBebida);
		}
		return listBebida;
	}
	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setEditable(false);
			txPrecio.setForeground(Color.WHITE);
			txPrecio.setBackground(Color.ORANGE);
			txPrecio.setFont(new Font("Arial Black", Font.BOLD, 16));
			txPrecio.setColumns(10);
		}
		return txPrecio;
	}
	private JButton getBtAnular() {
		if (btAnular == null) {
			btAnular = new JButton("Anular");
			btAnular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			btAnular.setMnemonic('A');
			btAnular.setFont(new Font("Arial Black", Font.BOLD, 16));
			btAnular.setForeground(Color.WHITE);
			btAnular.setBackground(Color.RED);
		}
		return btAnular;
	}
	private JButton getBtSig1() {
		if (btSig1 == null) {
			btSig1 = new JButton("Siguiente");
			btSig1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPn2();

				}
			});
			btSig1.setEnabled(false);
			btSig1.setMnemonic('S');
			btSig1.setForeground(Color.WHITE);
			btSig1.setFont(new Font("Arial Black", Font.BOLD, 16));
			btSig1.setBackground(new Color(0, 128, 0));
		}
		return btSig1;
	}
	
	private void mostrarPn2() {
		CardLayout c = (CardLayout) getPnContenidos().getLayout();
		c.show(getPnContenidos(), "pn2");
		getPnInfo2().add(getTbPnPedido());
		getPnBts2().add(getTxPrecio(),0);
	}
	
	private void crearBotones() {
		getPnArticulos().removeAll();
		for(int i = 0; i<carta.getListaArticulos().size();i++) {
			getPnArticulos().add(nuevoBoton(i));
			
		}
	}
	
	private void muestraDimension() {
		System.out.println("Dimension ="+  this.getBounds());
		Dimension d = new Dimension(490,686);
		this.setMinimumSize(d);
	
	}
	private JButton getBtSig2() {
		if (btSig2 == null) {
			btSig2 = new JButton("Siguiente");
			btSig2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPn3();
				}
			});
			btSig2.setMnemonic('S');
			btSig2.setForeground(Color.WHITE);
			btSig2.setFont(new Font("Arial Black", Font.BOLD, 16));
			btSig2.setBackground(new Color(0, 128, 0));
		}
		return btSig2;
	}
	private JButton getBtAnt1() {
		if (btAnt1 == null) {
			btAnt1 = new JButton("Anterior");
			btAnt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPn1();
				}
			});
			btAnt1.setMnemonic('A');
			btAnt1.setForeground(Color.WHITE);
			btAnt1.setFont(new Font("Arial Black", Font.BOLD, 16));
			btAnt1.setBackground(Color.RED);
		}
		return btAnt1;
	}
	
	private void mostrarPn1() {
		CardLayout c = (CardLayout)getPnContenidos().getLayout();
		c.show(getPnContenidos(), "pn1");
		getPnInfo1().add(getTbPnPedido());
		getPnBts1().add(getTxPrecio(),0);
	}
	private JButton getBtAnt2() {
		if (btAnt2 == null) {
			btAnt2 = new JButton("Anterior");
			btAnt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPn2();
				}
			});
			btAnt2.setMnemonic('A');
			btAnt2.setForeground(Color.WHITE);
			btAnt2.setFont(new Font("Arial Black", Font.BOLD, 16));
			btAnt2.setBackground(Color.RED);
		}
		return btAnt2;
	}
	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizar();
				}
			});
			btFinalizar.setMnemonic('S');
			btFinalizar.setForeground(Color.WHITE);
			btFinalizar.setFont(new Font("Arial Black", Font.BOLD, 16));
			btFinalizar.setBackground(new Color(0, 128, 0));
		}
		return btFinalizar;
	}
	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setLayout(new GridLayout(4, 0, 0, 0));
			pnFiltros.add(getBtHamburguesa());
			pnFiltros.add(getBtBebida());
			pnFiltros.add(getBtComplementos());
			pnFiltros.add(getBtPostres());
		}
		return pnFiltros;
	}
	private JButton getBtHamburguesa() {
		if (btHamburguesa == null) {
			btHamburguesa = new JButton("");
			btHamburguesa.setToolTipText("Selecciona solo hamburguesas");
			btHamburguesa.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/HA03.png")));

		}
		return btHamburguesa;
	}
	private JButton getBtBebida() {
		if (btBebida == null) {
			btBebida = new JButton("");
			btBebida.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/BE03.png")));
			btBebida.setToolTipText("Selecciona solo bebidas");
		}
		return btBebida;
	}
	private JButton getBtComplementos() {
		if (btComplementos == null) {
			btComplementos = new JButton("");
			btComplementos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/CO04.png")));
			btComplementos.setToolTipText("Selecciona solo bebidas");
		}
		return btComplementos;
	}
	private JButton getBtPostres() {
		if (btPostres == null) {
			btPostres = new JButton("");
			btPostres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/PO04.png")));
		}
		return btPostres;
	}
}
