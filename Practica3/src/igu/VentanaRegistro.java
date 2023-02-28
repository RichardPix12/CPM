package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;

import logica.Pedido;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaRegistro extends JDialog {

	private JPanel pnPrincipal;
	private JPanel pnCliente;
	private JLabel lbNombre;
	private JTextField txNombre;
	private JComboBox<String> cbAño;
	private JLabel lbAño;
	private JLabel lbPassword;
	private JLabel lblPassword2;
	private JPasswordField pwPass1;
	private JPasswordField pwPass2;
	private JButton btSiguiente;
	private JButton btCancelar;
	private JPanel pnPedido;
	private JRadioButton rbLocal;
	private JRadioButton rbLlevar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private VentanaPrincipal vP;
	



	/**
	 * Constructor de la ventana Registro
	 * @param vprin de tipo VentanaPrincipal
	 */
	public VentanaRegistro(VentanaPrincipal vprin) {
		this.vP = vprin;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/img/logo.PNG")));
		setTitle("MacDonald's Espa\u00F1a: Datos del cliente");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 425);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.WHITE);
		pnPrincipal.setToolTipText("");
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getPnCliente());
		pnPrincipal.add(getBtSiguiente());
		pnPrincipal.add(getBtCancelar());
		pnPrincipal.add(getPnPedido());


	}
	
	/**
	 * Metodo que te dice la Ventana principal 
	 * @return vP de tipo VentanaPrincipal
	 */
	public VentanaPrincipal getVP() {
		return vP;
	}
	
	/**
	 * Panel para los datos
	 * @return pnCliente de tipo JPanel
	 */
	private JPanel getPnCliente() {
		if (pnCliente == null) {
			pnCliente = new JPanel();
			pnCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial",Font.BOLD, 16), new Color(0, 0, 0)));
			pnCliente.setBounds(25, 29, 598, 242);
			pnCliente.setLayout(null);
			pnCliente.add(getLbNombre());
			pnCliente.add(getTxNombre());
			pnCliente.add(getCbAño());
			pnCliente.add(getLbAño());
			pnCliente.add(getLbPassword());
			pnCliente.add(getLblPassword2());
			pnCliente.add(getPwPass1());
			pnCliente.add(getPwPass2());
		}
		return pnCliente;
	}
	
	/**
	 * Etiqueta para decir donde tienes que poner el nombre
	 * @return lbNombre de tipo JLabel
	 */
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre y apellidos: ");
			lbNombre.setDisplayedMnemonic('n');
			lbNombre.setLabelFor(getTxNombre());
			lbNombre.setBounds(23, 27, 118, 14);
		}
		return lbNombre;
	}
	
	/**
	 * Cuadro de texto donde pones el nombre
	 * @return txNombre de tipo JTextField
	 */
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(199, 24, 387, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	
	/**
	 * Combo donde estan los años a poner
	 * @return cbAño de tipo JComboBox<String>
	 */
	private JComboBox<String> getCbAño() {
		if (cbAño == null) {
			String[] años = new String[90];
			for(int i=0; i<años.length;i++) {
				String año = String.valueOf((90-i)+1920);
				años[i]=año;
			}
				
			cbAño = new JComboBox<String>();
			cbAño.setModel(new DefaultComboBoxModel<String>(años));
			cbAño.setBounds(200, 75, 386, 20);
		}
		return cbAño;
	}
	
	/**
	 * Etiqueta para decir donde va el año
	 * @return lbAño de tipo JLabel
	 */
	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("A\u00F1o de nacimiento:");
			lbAño.setLabelFor(getCbAño());
			lbAño.setDisplayedMnemonic('a');
			lbAño.setBounds(23, 78, 118, 14);
		}
		return lbAño;
	}
	
	/**
	 * Etique para decir donde va la contraseña
	 * @return lbPassword de tipo JLabel
	 */
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Password:");
			lbPassword.setLabelFor(getPwPass1());
			lbPassword.setDisplayedMnemonic('p');
			lbPassword.setBounds(23, 136, 95, 14);
		}
		return lbPassword;
	}
	
	/**
	 * Etiqueta para decir donde va la confirmación de contraseña
	 * @return lblPassword2 de tipo JLabel
	 */
	private JLabel getLblPassword2() {
		if (lblPassword2 == null) {
			lblPassword2 = new JLabel("Reintroduzca Password:");
			lblPassword2.setLabelFor(getPwPass2());
			lblPassword2.setDisplayedMnemonic('r');
			lblPassword2.setBounds(25, 192, 123, 14);
		}
		return lblPassword2;
	}
	
	/**
	 * Cuadro para colocar la contraseña
	 * @return pwPass2 de tipo JPasswordField
	 */
	private JPasswordField getPwPass1() {
		if (pwPass1 == null) {
			pwPass1 = new JPasswordField();
			pwPass1.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					compruebaPassWord();
				}
			});
			pwPass1.setEchoChar('*');
			pwPass1.setBounds(199, 133, 387, 20);
		}
		return pwPass1;
	}
	
	/**
	 * Cuadro para colocar la confirmacion de contraseña
	 * @return pwPass2 de tipo JPassWordField
	 */
	private JPasswordField getPwPass2() {
		if (pwPass2 == null) {
			pwPass2 = new JPasswordField();
			pwPass2.setToolTipText("");
			pwPass2.setEchoChar('*');
			pwPass2.setBounds(199, 189, 387, 20);
		}
		return pwPass2;
	}
	
	/**
	 * Boton siguiente para cambiar de pantalla
	 * @return btSiguiente de tipo JButton
	 */
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setMnemonic('s');
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					tipoPedido();
					
					if(checkName()){
						JOptionPane.showMessageDialog(null, "El campo de nombre esta vacio");
					}
					else if(checkPassword()) {
						JOptionPane.showMessageDialog(null, "Las contraseñas están mal");
					}
					else {
						llamarVentana();
					}
				}
			});
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBackground(new Color(34, 139, 34));
			btSiguiente.setBounds(381, 321, 107, 42);
		}
		return btSiguiente;
	}
	
	protected void tipoPedido() {
		if(getRbLlevar().isSelected()) {
			vP.getPedido().setEstado("Llevar");
		}
		else if(getRbLocal().isSelected()) {
			vP.getPedido().setEstado("Local");
		}
		
	}

	/**
	 * Metodo para iniciar la ventana de confirmacion
	 */
	private void llamarVentana() {
		VentanaConfirmacion v = new VentanaConfirmacion(this);
		v.setLocationRelativeTo(this);
		v.setModal(true); // Metodo que dice si puedes seguir usando la aplicacion mientras estas en una subventana, True no, false si
		v.setVisible(true);
	}
	
	/**
	 * Metodo para comprobar si el nombre es válido
	 * @return true si es valido
	 * @return false si no es valido
	 */
	private boolean checkName() {	
		return getTxNombre().getText().isEmpty();	
	}
	
	/**
	 * Metodo para comprobar si la contraseña es igual
	 * @return true si es igual
	 * @return false si no es igual
	 */
	private boolean checkPassword() {
		String pass1 = String.valueOf(getPwPass1().getPassword());
		String pass2 = String.valueOf(getPwPass2().getPassword());
		
		return ((!(pass1.equals(pass2))) || pass1 == "" || pass2=="");
		
		/*if(pass1.equals(pass2)) {
			return;
		}
		else {
			JOptionPane.showMessageDialog(null, "Las contraseñas son diferentes");
		}
		*/
	}
	
	/**
	 * Boton cancelar
	 * @return btCancelar de tipo JButton
	 */
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setMnemonic('c');
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(504, 321, 107, 42);
		}
		return btCancelar;
	}
	
	/**
	 * Panel para el tipo del pedido
	 * @return pnPedido de tipo JPanel
	 */
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pedido", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16), new Color(0, 0, 0)));
			pnPedido.setBounds(25, 282, 324, 81);
			pnPedido.setLayout(null);
			pnPedido.add(getRbLocal());
			pnPedido.add(getRbLlevar());
		}
		return pnPedido;
	}
	
	/**
	 * RadioBoton para elegir si el pedido es local
	 * @return rbLocal de tipo JRadioButton
	 */
	private JRadioButton getRbLocal() {
		if (rbLocal == null) {
			rbLocal = new JRadioButton("Local");
			rbLocal.setSelected(true);
			buttonGroup.add(rbLocal);
			rbLocal.setBounds(31, 32, 109, 23);
		}
		return rbLocal;
	}
	
	/**
	 * RadioBoton para elegir si el pedido es para llevar
	 * @return rbLlevar de tipo JRadioButton
	 */
	private JRadioButton getRbLlevar() {
		if (rbLlevar == null) {
			rbLlevar = new JRadioButton("Llevar");
			buttonGroup.add(rbLlevar);
			rbLlevar.setBounds(155, 32, 109, 23);
		}
		return rbLlevar;
	}
	
	/**
	 * Metodo para comprobar si la contraseña tiene mas de 8 caracteres
	 */
	private void compruebaPassWord() {
		if(getPwPass1().getPassword().length < 8 ) {
			JOptionPane.showMessageDialog(this, "Error: La contraseña debe tener un mínimo de 8 caracteres");
			pwPass1.requestFocus();
		}
	}
	
}
