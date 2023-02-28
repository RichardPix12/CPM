package igu;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.FileUtil;
import logica.Pedido;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	private JPanel pnPrincipal;
	private JLabel jlOk;
	private JLabel lbAviso;
	private JLabel lbCodigo;
	private JTextField txCodigo;
	private JButton btFinalizar;
	private JLabel lblElPrecioFinal;
	private JTextField txPrecioFinal;
	private VentanaRegistro vreg;
	

	/**
	 * Constructor con un parámetro que crea la venta
	 * @param vreg de tipo VentanaRegistro
	 */
	public VentanaConfirmacion(VentanaRegistro vreg) {
		setVReg(vreg);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.PNG")));
		setTitle("MacDonald's Espa\u00F1a: Confirmaci\u00F3n del pedido");
		setBounds(100, 100, 687, 499);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.WHITE);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getJlOk());
		pnPrincipal.add(getLbAviso());
		pnPrincipal.add(getLbCodigo());
		pnPrincipal.add(getTxCodigo());
		pnPrincipal.add(getBtFinalizar());
		pnPrincipal.add(getLblElPrecioFinal());
		pnPrincipal.add(getTxPrecioFinal());
	}
	
	/**
	 * Metodo para elegir la ventana de registro
	 * @param vreg de tipo VentanaRegistro
	 */
	private void setVReg(VentanaRegistro vreg) {
		this.vreg = vreg;
	}
	

	/**
	 * Etiqueta para poner el simbolo de OK
	 * @return jlOk de tipo JLabel
	 */
	private JLabel getJlOk() {
		if (jlOk == null) {
			jlOk = new JLabel("");
			jlOk.setHorizontalAlignment(SwingConstants.CENTER);
			jlOk.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			jlOk.setBounds(47, 107, 70, 59);
		}
		return jlOk;
	}
	
	/**
	 * Etiqueta para dar un aviso
	 * @return lbAviso de tipo JLabel
	 */
	private JLabel getLbAviso() {
		if (lbAviso == null) {
			lbAviso = new JLabel("Estamos procesado su pedido");
			lbAviso.setFont(new Font("Arial Black", Font.BOLD, 20));
			lbAviso.setBounds(142, 107, 380, 59);
		}
		return lbAviso;
	}
	
	/**
	 * Etiqueta para decir donde va el codigo
	 * @return lbCodigo de tipo JLabel
	 */
	private JLabel getLbCodigo() {
		if (lbCodigo == null) {
			lbCodigo = new JLabel("Su codigo de espera es:");
			lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbCodigo.setBounds(189, 210, 175, 29);
		}
		return lbCodigo;
	}
	
	/**
	 * Cuadro de texto para enseñar el codigo
	 * @return txCodigo de tipo JTextField
	 */
	private JTextField getTxCodigo() {
		if (txCodigo == null) {
			txCodigo = new JTextField();
			txCodigo.setEditable(false);
			txCodigo.setText(FileUtil.setFileName());
			txCodigo.setBounds(393, 207, 129, 32);
			txCodigo.setColumns(10);
		}
		return txCodigo;
	}
	
	/**
	 * Boton finalizar
	 * @return btFinalizar de tipo JButton
	 */
	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizar();
				}
			});
			btFinalizar.setMnemonic('F');
			btFinalizar.setForeground(Color.WHITE);
			btFinalizar.setBackground(new Color(0, 128, 0));
			btFinalizar.setBounds(256, 337, 89, 23);
		}
		return btFinalizar;
	}
	
	/**
	 * Etiqueta para decir donde va el precio final
	 * @return lbElPrecioFinal de tipo JLabel
	 */
	private JLabel getLblElPrecioFinal() {
		if (lblElPrecioFinal == null) {
			lblElPrecioFinal = new JLabel("El precio final es:");
			lblElPrecioFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblElPrecioFinal.setBounds(189, 271, 145, 29);
		}
		return lblElPrecioFinal;
	}
	
	/**
	 * Cuadro de texto para enseñar el texto final
	 * @return txPrecioFinal de tipo JTextField
	 */
	private JTextField getTxPrecioFinal() {
		if (txPrecioFinal == null) {
			txPrecioFinal = new JTextField();
			txPrecioFinal.setEditable(false);
			txPrecioFinal.setColumns(10);
			txPrecioFinal.setBounds(393, 268, 129, 32);
				
			txPrecioFinal.setText(vreg.getVP().getPedido().totalDosDecimales()+ "€");
		}
		return txPrecioFinal;
	}

	/**
	 * Metodo cuando calcas el boton finalizar, que finaliza los medidos, e inicia otros
	 */
	private void finalizar() {
		vreg.getVP().getPedido().grabarPedido(getTxCodigo().getText());
		//eliminar ventana confirmacion
		dispose();
		//eliminar ventana registro
		vreg.dispose();
		//inicializar el pedido
		vreg.getVP().inicializar();
	
	}
}
