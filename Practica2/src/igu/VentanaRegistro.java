package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class VentanaRegistro extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setTitle("Datos del cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	private JPanel getPnCliente() {
		if (pnCliente == null) {
			pnCliente = new JPanel();
			pnCliente.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre y apellidos: ");
			lbNombre.setBounds(23, 27, 118, 14);
		}
		return lbNombre;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(199, 24, 387, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JComboBox<String> getCbAño() {
		if (cbAño == null) {
			String[] años = new String[] {"1996", "1997", "1998", "1999", "2000", "2001", "2002"};
			cbAño = new JComboBox<String>();
			cbAño.setModel(new DefaultComboBoxModel<String>(años));
			cbAño.setBounds(200, 75, 386, 20);
		}
		return cbAño;
	}
	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("A\u00F1o de nacimiento:");
			lbAño.setBounds(23, 78, 118, 14);
		}
		return lbAño;
	}
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Password:");
			lbPassword.setBounds(23, 136, 95, 14);
		}
		return lbPassword;
	}
	private JLabel getLblPassword2() {
		if (lblPassword2 == null) {
			lblPassword2 = new JLabel("Reintroduzca Password:");
			lblPassword2.setBounds(25, 192, 123, 14);
		}
		return lblPassword2;
	}
	private JPasswordField getPwPass1() {
		if (pwPass1 == null) {
			pwPass1 = new JPasswordField();
			pwPass1.setEchoChar('*');
			pwPass1.setBounds(199, 133, 387, 20);
		}
		return pwPass1;
	}
	private JPasswordField getPwPass2() {
		if (pwPass2 == null) {
			pwPass2 = new JPasswordField();
			pwPass2.setToolTipText("");
			pwPass2.setEchoChar('*');
			pwPass2.setBounds(199, 189, 387, 20);
		}
		return pwPass2;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkName();
					checkPassword();
				}
			});
			btSiguiente.setForeground(Color.WHITE);
			btSiguiente.setBackground(new Color(34, 139, 34));
			btSiguiente.setBounds(381, 321, 107, 42);
		}
		return btSiguiente;
	}
	
	private void checkName() {	
		if(getTxNombre().getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "El campo de nombre esta vacio");
		}
	}
	private void checkPassword() {
		String pass1 = String.valueOf(getPwPass1().getPassword());
		String pass2 = String.valueOf(getPwPass2().getPassword());
		
		if(!(pass1.equals(pass2))) {
			JOptionPane.showMessageDialog(null, "Las contraseñas son diferentes");
		}
		
		/*if(pass1.equals(pass2)) {
			return;
		}
		else {
			JOptionPane.showMessageDialog(null, "Las contraseñas son diferentes");
		}
		*/
	}
	

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btCancelar.setForeground(Color.WHITE);
			btCancelar.setBackground(new Color(255, 0, 0));
			btCancelar.setBounds(504, 321, 107, 42);
		}
		return btCancelar;
	}
	private JPanel getPnPedido() {
		if (pnPedido == null) {
			pnPedido = new JPanel();
			pnPedido.setBorder(new TitledBorder(null, "Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPedido.setBounds(25, 282, 324, 81);
			pnPedido.setLayout(null);
			pnPedido.add(getRbLocal());
			pnPedido.add(getRbLlevar());
		}
		return pnPedido;
	}
	private JRadioButton getRbLocal() {
		if (rbLocal == null) {
			rbLocal = new JRadioButton("Local");
			rbLocal.setSelected(true);
			buttonGroup.add(rbLocal);
			rbLocal.setBounds(31, 32, 109, 23);
		}
		return rbLocal;
	}
	private JRadioButton getRbLlevar() {
		if (rbLlevar == null) {
			rbLlevar = new JRadioButton("Llevar");
			buttonGroup.add(rbLlevar);
			rbLlevar.setBounds(155, 32, 109, 23);
		}
		return rbLlevar;
	}
}
