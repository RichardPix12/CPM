package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Articulo;
import logica.Carta;
import logica.Pedido;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.GridLayout;
import java.awt.Component;

public class VentanaPrincipal extends JFrame {

	private JPanel pnPrincipal;
	private JLabel lbLogo;
	private JLabel lbNombre;
	private JLabel lbArticulos;
	private JComboBox<Articulo> cbArticulos;
	private JLabel lbUnidades;
	private JSpinner spUnidades;
	private JButton btAñadir;
	private JLabel lbPrecio;
	private JTextField txPrecioPedido;
	private JButton btSiguiente;
	private JButton btCancelar;
	private Carta carta;
	private Pedido pedido;
	private JLabel lblCantidad;
	private JTextField txCantidad;
	private JLabel lbPedido;
	private JScrollPane spnPedido;
	private JButton btEliminar;
	private JTextArea txAPedido;
	private JLabel lbImgProducto;
	private JMenuBar menuBar;
	private JMenu mnPedido;
	private JMenu mnAyuda;
	private JMenuItem mnItNuevo;
	private JMenuItem mnItSalir;
	private JMenuItem mnItAcercaDe;
	private JMenuItem mnItContenidos;
	private JSeparator separatorPedido;
	private JSeparator separatorAyuda;
	private JPanel pnTipos;
	private JButton btPostres;
	private JButton btComplemento;
	private JButton btBebida;
	private JButton btHamburguesa;
	private boolean ventanaMostrada;

	/**
	 * Crea la ventana principal
	 * @param carta de tipo Carta, recibe la carta que queremos enseñar en la aplicación
	 * @param pedido de tipo Pedido, pedido que queremos completar en la aplicación
	 */
	public VentanaPrincipal(Carta carta, Pedido pedido) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(pedido.isVacio()) {
					System.exit(0);
				}
				else {
					if(confirmarCancelacion()) {
						System.exit(0);
					}
				}
			}
		});
		this.ventanaMostrada = false;
		setResizable(false);
		setCarta(carta);
		setPedido(pedido);		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.PNG")));
		setTitle("MacDonald's Espa\u00F1a");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1022, 593);
		setJMenuBar(getMenuBar_1());
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.WHITE);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getLbLogo());
		pnPrincipal.add(getLbNombre());
		pnPrincipal.add(getLbArticulos());
		pnPrincipal.add(getCbArticulos());
		pnPrincipal.add(getLbUnidades());
		pnPrincipal.add(getSpUnidades());
		pnPrincipal.add(getBtAñadir());
		pnPrincipal.add(getLbPrecio());
		pnPrincipal.add(getTxPrecioPedido());
		pnPrincipal.add(getBtSiguiente());
		pnPrincipal.add(getBtCancelar());
		pnPrincipal.add(getLblCantidad());
		pnPrincipal.add(getTxCantidad());
		pnPrincipal.add(getLbPedido());
		pnPrincipal.add(getBtEliminar());
		pnPrincipal.add(getSpnPedido());
		pnPrincipal.add(getLbImgProducto());
		pnPrincipal.add(getPnTipos());
		setLocationRelativeTo(null);
	}
	/**
	 * Metodo para saber el pedido
	 * @return pedido de tipo pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}
	
	/**
	 * Metodo para seleccionar la carta que queremos utilizamos
	 * @param carta de tipo Carta
	 */
	private void setCarta(Carta carta) {
		this.carta=carta;
	}
	
	/**
	 * Metodo para seleccionar el pedido que queremos utilizar
	 * @param pedido de tipo Pedido
	 */
	private void setPedido(Pedido pedido) {
		this.pedido=pedido;
	}
	
	/**
	 * Etiqueta en la que ponemos el logo
	 * @return lbLogo de tipo JLabel
	 */
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.PNG")));
			lbLogo.setBounds(257, 32, 133, 106);
		}
		return lbLogo;
	}
	
	/**
	 * Etiqueta para saber el titulo
	 * @return lbNombre de tipo JLabel	
	 */
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("McDonald's");
			lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lbNombre.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lbNombre.setBounds(433, 75, 289, 40);
		}
		return lbNombre;
	}
	
	/**
	 * Etiqueta para poner el nombre de articulos
	 * @return lbArticulos de tipo JLabel
	 */
	private JLabel getLbArticulos() {
		if (lbArticulos == null) {
			lbArticulos = new JLabel("Art\u00EDculos:");
			lbArticulos.setDisplayedMnemonic('r');
			lbArticulos.setLabelFor(getCbArticulos());
			lbArticulos.setFont(new Font("Arial", Font.PLAIN, 14));
			lbArticulos.setBounds(257, 183, 133, 22);
		}
		return lbArticulos;
	}
	
	/**
	 * Caja para meter dentro la carta y que elijamos 
	 * @return cbArticulos de tipo JComboBox<Articulo>
	 */
	private JComboBox<Articulo> getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>();
			cbArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarFotosYUnidades();
				}
			});
			cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(carta.getArticulos()));
			cbArticulos.setFont(new Font("Arial", Font.PLAIN, 14));
			cbArticulos.setBounds(257, 253, 348, 32);
		}
		return cbArticulos;
	}
	
	public void mostrarFotosYUnidades() {
		getSpUnidades().setValue(((SpinnerNumberModel)getSpUnidades().getModel()).getMinimum()); // Valor minimo del spinner lo que esta entre parentesis
		
		txCantidad.setText(String.valueOf(pedido.unidades((Articulo)getCbArticulos().getSelectedItem())));
		
		String foto = ((Articulo)getCbArticulos().getSelectedItem()).getFoto();
		lbImgProducto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(foto)));
	}
	
	
	/**
	 * Etiqueta para enseñar las unidades
	 * @return lbUnidades de tipo JLabel
	 */
	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setDisplayedMnemonic('u');
			lbUnidades.setLabelFor(getSpUnidades());
			lbUnidades.setFont(new Font("Arial", Font.PLAIN, 14));
			lbUnidades.setBounds(648, 221, 133, 22);
		}
		return lbUnidades;
	}
	
	/**
	 * Spinner para elegir las unidades 
	 * @return spUnidades de tipo JSpinner
	 */
	private JSpinner getSpUnidades() {
		if (spUnidades == null) {
			spUnidades = new JSpinner();
			spUnidades.setFont(new Font("Arial", Font.PLAIN, 14));
			spUnidades.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spUnidades.setBounds(648, 254, 89, 32);
		}
		return spUnidades;
	}
	
	/**
	 * Boton para añadir unidades al pedido
	 * @return btAñadir de tipo JButton
	 */
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("A\u00F1adir");
			btAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirAPedido();				
				}
			});
			btAñadir.setMnemonic('A');
			btAñadir.setFont(new Font("Arial", Font.PLAIN, 14));
			btAñadir.setForeground(Color.WHITE);
			btAñadir.setBackground(new Color(34, 139, 34));
			btAñadir.setBounds(759, 253, 103, 32);
		}
		return btAñadir;
	}
	
	/**
	 * Metodo que utilizamos al calcar el boton añadir 
	 */
	private void añadirAPedido() {
		//1. Añadir el producto al pedido		

			Articulo articuloDelCatalogo = (Articulo)getCbArticulos().getSelectedItem();
			int unidades = (int)getSpUnidades().getValue();			
			pedido.add(articuloDelCatalogo, unidades);
			
		//2. Calcular el precio total 
			
			float total = pedido.calcularTotal();

			
		// Mostrar el descuento y aplicarlo
				if(pedido.isDescuentoAplicado() && !ventanaMostrada) {
					JOptionPane.showMessageDialog(this, "Se ha aplicado un descuento del 10% por el McHappyDay por superar los 50€");
					ventanaMostrada = true;
				}
			
		//3. Mostrar el precio del pedido
			
			String precio= String.format("%.2f", total);
			getTxPrecioPedido().setText(precio+"€");
			
			
		// Habilitar el boton siguiente
			
			if(total != 0) {
			getBtSiguiente().setEnabled(true);
			}
		
		// Poner el valor a la etiqueta de cantidad de productos
			txCantidad.setText(String.valueOf(pedido.unidades((Articulo)getCbArticulos().getSelectedItem())));
		// Reiniciar el spinner			
			getSpUnidades().setValue(((SpinnerNumberModel)getSpUnidades().getModel()).getMinimum());
	}

	/**
	 * Boton para eliminar articulos del pedido
	 * @return btElminar de tipo JButton
	 */
	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarAPedido();
				}
			});
			btEliminar.setMnemonic('A');
			btEliminar.setForeground(Color.WHITE);
			btEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
			btEliminar.setBackground(new Color(34, 139, 34));
			btEliminar.setBounds(872, 253, 103, 32);
		}
		return btEliminar;
	}
	
	/**
	 * Metodo que utilizamos al calcar el boton eliminar
	 */
	private void eliminarAPedido() {
		//1. Eliminar el producto al pedido		
		
		Articulo articuloDelPedido = (Articulo)getCbArticulos().getSelectedItem();
		//articuloDelPedido.setUnidades(pedido.unidades((Articulo)getCbArticulos().getSelectedItem()));
		int unidades = (int)getSpUnidades().getValue();			
		pedido.remove(articuloDelPedido, unidades);
		
		//2. Calcular el precio total
		float total = pedido.calcularTotal();
				
		//Mostrar el precio del pedido
		String precio = String.format("%.2f", total);
		getTxPrecioPedido().setText(precio+"€");
		
		// Poner el valor a la etiqueta de cantidad de productos
		txCantidad.setText(String.valueOf(pedido.unidades((Articulo)getCbArticulos().getSelectedItem())));
		
		// Reiniciar el spinner			
		getSpUnidades().setValue(((SpinnerNumberModel)getSpUnidades().getModel()).getMinimum());
	}
	
	/**
	 * Etiqueta para precio
	 * @return lbPrecio de tipo JLabel
	 */
	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio Pedido:");
			lbPrecio.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPrecio.setBounds(648, 297, 133, 22);
		}
		return lbPrecio;
	}
	
	/**
	 * Cuadro de texto para enseñar el precio total del pedido
	 * @return txPrecioPedido de tipo JTextField
	 */
	private JTextField getTxPrecioPedido() {
		if (txPrecioPedido == null) {
			txPrecioPedido = new JTextField();
			txPrecioPedido.setEditable(false);
			txPrecioPedido.setFont(new Font("Arial", Font.PLAIN, 14));
			txPrecioPedido.setBounds(648, 330, 117, 32);
			txPrecioPedido.setColumns(10);
		}
		return txPrecioPedido;
	}
	
	/**
	 * Boton siguiente que utilizamos para cambiar de ventana
	 * @return btSiguiente de tipo Jbutton
	 */
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaRegistro();
				}
			});
			btSiguiente.setMnemonic('S');
			btSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBackground(new Color(34, 139, 34));
			btSiguiente.setBounds(773, 456, 103, 32);
		}
		return btSiguiente;
	}
	
	/**
	 * Metodo que crea una ventana registro y la abre
	 */
	private void mostrarVentanaRegistro() {
		VentanaRegistro v = new VentanaRegistro(this);
		v.setLocationRelativeTo(this);
		v.setModal(true); // Metodo que dice si puedes seguir usando la aplicacion mientras estas en una subventana, True no, false si
		v.setVisible(true);
	}
	
	/**
	 * Boton cancelar que utilizamos para reiniciar el pedido y la aplicacion
	 * @return btCancelar de tipo JButton
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setMnemonic('C');
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(pedido.isVacio()) {
						inicializar();
					}
					else {										
							if(confirmarCancelacion()) {
								inicializar();
							}
					}
				}
			});
			btCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(Color.RED);
			btCancelar.setBounds(903, 456, 103, 32);
		}
		return btCancelar;
	}
	
	/**
	 * Metodo que te pide confrimacion para cancelar el pedido o para cerrar la aplicación
	 * @return yes de tipo boolean
	 */
	private boolean confirmarCancelacion() {
		boolean yes = false;
		int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar su pedido?","Confirmando cancelación", JOptionPane.YES_NO_OPTION);
		if(resp==JOptionPane.YES_OPTION) {
			yes = true;
		}
		return yes;
	}
	
	/**
	 * Etiqueta para indicar donde va la cantidad
	 * @return lblCantidad de tipo JLabel
	 */
	private JLabel getLblCantidad() {
		if (lblCantidad == null) {
			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
			lblCantidad.setDisplayedMnemonic('r');
			lblCantidad.setBounds(257, 334, 94, 22);
		}
		return lblCantidad;
	}
	
	/**
	 * Cuadro de texto donde se indica la cantidad
	 * @return txCantidad de tipo JTextField
	 */
	private JTextField getTxCantidad() {
		if (txCantidad == null) {
			txCantidad = new JTextField();
			txCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
			txCantidad.setEditable(false);
			txCantidad.setColumns(10);
			txCantidad.setBounds(366, 330, 117, 32);			
		}
		return txCantidad;
	}
	
	/**
	 * Metodo para inicializar el pedido
	 */
	protected void inicializar(){
		//1. Lógica
		pedido.inicializar();
		ventanaMostrada = false;
		
		//2. Interfaz
		getCbArticulos().setSelectedIndex(0); // Pone a 0 el combo
		getSpUnidades().setValue(1);
		getTxPrecioPedido().setText("");
		getBtSiguiente().setEnabled(false);
		getCbArticulos().requestFocus();
		getCbArticulos().setModel(new DefaultComboBoxModel<Articulo>(carta.getArticulos()));
	}
	
	/**
	 * Etiqueta con el logo de ver el pedido
	 * @return lbPedido de JLabel
	 */
	private JLabel getLbPedido() {
		if (lbPedido == null) {
			lbPedido = new JLabel("");
			lbPedido.setToolTipText("Carrito con el pedido");
			lbPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					getTxAPedido().setVisible(true);
					getTxAPedido().setText(pedido.toString());
				}
				public void mouseReleased(MouseEvent e) {
					getTxAPedido().setVisible(false);
				}
			});
			lbPedido.setHorizontalAlignment(SwingConstants.CENTER);
			lbPedido.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/pedido.png")));
			lbPedido.setBounds(773, 32, 184, 47);
			
		}
		return lbPedido;
	}

	
	/**
	 * Panel que se crea para mostrar el pedido
	 * @return spnPedido de tipo JScrollPane
	 */
	private JScrollPane getSpnPedido() {
		if (spnPedido == null) {
			spnPedido = new JScrollPane();
			spnPedido.setToolTipText("");
			spnPedido.setBounds(759, 84, 245, 121);
			spnPedido.setViewportView(getTxAPedido());
		}
		return spnPedido;
	}
	
	
	/**
	 * TextoArea donde se muestra todo el pedido que se lleva
	 * @return txAPedido de tipo JTextArea
	 */
	private JTextArea getTxAPedido() {
		if (txAPedido == null) {
			txAPedido = new JTextArea();
			txAPedido.setEditable(false);
			txAPedido.setVisible(false);
		}
		return txAPedido;
	}
	
	/**
	 * Etiqueta para enseñar la imagen del producto
	 * @return lbImgProducto de tipo JLabel
	 */
	private JLabel getLbImgProducto() {
		if (lbImgProducto == null) {
			lbImgProducto = new JLabel("");
			lbImgProducto.setHorizontalAlignment(SwingConstants.CENTER);
			lbImgProducto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/HA01.png")));
			lbImgProducto.setBounds(344, 386, 167, 126);
		}
		return lbImgProducto;
	}
	
	/**
	 * Barra de menu
	 * @return menuBar de tipo JMenuBar
	 */
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnPedido());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	
	/**
	 * Menu de pedido
	 * @return mnPedido de tipo JMenu
	 */
	private JMenu getMnPedido() {
		if (mnPedido == null) {
			mnPedido = new JMenu("Pedido");
			mnPedido.setMnemonic('p');
			mnPedido.add(getMnItNuevo());
			mnPedido.add(getSeparatorPedido());
			mnPedido.add(getMnItSalir());
		}
		return mnPedido;
	}
	
	/**
	 * Menu de ayuda
	 * @return mnAyuda de tipo JMenu
	 */
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('Y');
			mnAyuda.add(getMnItContenidos());
			mnAyuda.add(getSeparatorAyuda());
			mnAyuda.add(getMnItAcercaDe());
		}
		return mnAyuda;
	}
	
	/**
	 * Parte de menu pedido donde se crea un pedido nuevo
	 * @return mnItNuevo de tipo JMenuItem
	 */
	private JMenuItem getMnItNuevo() {
		if (mnItNuevo == null) {
			mnItNuevo = new JMenuItem("Nuevo");
			mnItNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			mnItNuevo.setMnemonic('N');
			mnItNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		}
		return mnItNuevo;
	}
	
	/**
	 * Parte de menu pedido donde se sale de la aplicación
	 * @return mnItSalir de JMenuItem
	 */
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
	
	/**
	 * Parte de menu Ayuda sobre el acerca de
	 * @return mnItAcercaDe de tuoi JMenuItem
	 */
	private JMenuItem getMnItAcercaDe() {
		if (mnItAcercaDe == null) {
			mnItAcercaDe = new JMenuItem("Acerca de");
			mnItAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Aplicacion para MacDonald's España v1.0 \n "
							+ "Prácticas CMP 20-21 \n EII Oviedo", "Acerca de MacDonald's España",JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mnItAcercaDe.setMnemonic('d');
		}
		return mnItAcercaDe;
	}
	
	/**
	 * Parte de menu ayuda sobre contenidos
	 * @return mnItContenidos de tipo JMenuItem
	 */
	private JMenuItem getMnItContenidos() {
		if (mnItContenidos == null) {
			mnItContenidos = new JMenuItem("Contenidos");
			mnItContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Ayuda no disponible", "Contenidos de la ayuda",JOptionPane.INFORMATION_MESSAGE);
				}
				
			});
			mnItContenidos.setMnemonic('t');
			mnItContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mnItContenidos;
	}
	
	/**
	 * Separador del menu Pedido
	 * @return separatorPedido de tipo JSeparator
	 */
	private JSeparator getSeparatorPedido() {
		if (separatorPedido == null) {
			separatorPedido = new JSeparator();
		}
		return separatorPedido;
	}
	
	/**
	 * Separador del menu ayuda
	 * @return separatorAyuda de tipo JSeparator
	 */
	private JSeparator getSeparatorAyuda() {
		if (separatorAyuda == null) {
			separatorAyuda = new JSeparator();
		}
		return separatorAyuda;
	}
	
	/**
	 * Panel para colocar dentro los botones con los diferentes tipos
	 * @return pnTipos de tipo JPanel
	 */
	private JPanel getPnTipos() {
		if (pnTipos == null) {
			pnTipos = new JPanel();
			pnTipos.setBounds(0, 0, 226, 543);
			pnTipos.setLayout(new GridLayout(0, 1, 0, 0));
			pnTipos.add(getBtHamburguesa());
			pnTipos.add(getBtBebida());
			pnTipos.add(getBtComplemento());
			pnTipos.add(getBtPostres());
		}
		return pnTipos;
	}
	
	/**
	 * Boton para elegir en el combo solo postres
	 * @return btPostres de tipo JButton
	 */
	private JButton getBtPostres() {
		if (btPostres == null) {
			btPostres = new JButton("Postres");
			btPostres.setToolTipText("Hamburguesas");
			btPostres.setVerticalTextPosition(SwingConstants.BOTTOM);
			btPostres.setHorizontalTextPosition(SwingConstants.CENTER);
			btPostres.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTipo("Postre");
				}
			});
			btPostres.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Postre.png")));
		}
		return btPostres;
	}
	
	/**
	 * Boton para elegir en el combo solo complementos
	 * @return btComplemento de tipo JButton
	 */
	private JButton getBtComplemento() {
		if (btComplemento == null) {
			btComplemento = new JButton("Complementos");
			btComplemento.setVerticalTextPosition(SwingConstants.BOTTOM);
			btComplemento.setHorizontalTextPosition(SwingConstants.CENTER);
			btComplemento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTipo("Complemento");
				}
			});
			btComplemento.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Complemento.png")));
		}
		return btComplemento;
	}
	
	/**
	 * Boton para elegir en el combo solo bebida
	 * @return btBebida de tipo JButton
	 */
	private JButton getBtBebida() {
		if (btBebida == null) {
			btBebida = new JButton("Bebida");
			btBebida.setVerticalTextPosition(SwingConstants.BOTTOM);
			btBebida.setHorizontalTextPosition(SwingConstants.CENTER);
			btBebida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTipo("Bebida");
				}
			});
			btBebida.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Bebida.png")));
		}
		return btBebida;
	}
	
	/**
	 * Boton para elegir en el combo solo hamburguesa
	 * @return btHamburguesa de tipo JButton
	 */
	private JButton getBtHamburguesa() {
		if (btHamburguesa == null) {
			btHamburguesa = new JButton("Hamburguesa");
			btHamburguesa.setToolTipText("");
			btHamburguesa.setHorizontalTextPosition(SwingConstants.CENTER);
			btHamburguesa.setVerticalTextPosition(SwingConstants.BOTTOM);
			btHamburguesa.setSelectedIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Hamburguesa.png")));
			btHamburguesa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					getTipo("Hamburguesa");
				}
			});
			btHamburguesa.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Hamburguesa.png")));
		}
		return btHamburguesa;
	}
	
	/**
	 * Metodo que coloca solo hamburguesas en el combo
	 */
	private void getTipo(String tipo) {
		Articulo [] articulosASeleccionar = carta.getArticulosSeleccionados(tipo);	
		getCbArticulos().setModel(new DefaultComboBoxModel<Articulo>(articulosASeleccionar));	
		String foto = ((Articulo)getCbArticulos().getSelectedItem()).getFoto();
		lbImgProducto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(foto)));
	}
	

}
