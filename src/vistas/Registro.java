package vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import brain.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Registro extends JFrame {

	// Atributos de Arquitectura de Software
	private Modelo miModelo;
	private Controlador miControlador;

	// Atributos de interfaz grafica
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDni;
	private JTextField textEmail;
	private JTextField textEdad;
	private JPasswordField pswContra;
	private JTextField textTlfn;
	private JComboBox comboBoxProfesores;
	


	public JComboBox getComboBoxProfesores() {
		return comboBoxProfesores;
	}

	public Modelo getMiModelo() {
		return miModelo;
	}

	public Controlador getMiControlador() {
		return miControlador;
	}

	public void setComboBoxProfesores(JComboBox comboBoxProfesores) {
		this.comboBoxProfesores = comboBoxProfesores;
	}

	public Registro() {

		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblRegistro = new JLabel("REGISTRO:");
		lblRegistro.setBounds(170, 11, 91, 14);
		getContentPane().add(lblRegistro);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(27, 57, 62, 14);
		getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(92, 54, 86, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(27, 96, 62, 14);
		getContentPane().add(lblApellidos);

		textApellidos = new JTextField();
		textApellidos.setBounds(92, 93, 86, 20);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(27, 167, 89, 14);
		getContentPane().add(lblDni);

		textDni = new JTextField();
		textDni.setBounds(92, 164, 86, 20);
		getContentPane().add(textDni);
		textDni.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(27, 129, 62, 14);
		getContentPane().add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(92, 126, 86, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);

		JLabel lblEdad = new JLabel("A\u00F1o de nacimiento:");
		lblEdad.setBounds(209, 96, 112, 14);
		getContentPane().add(lblEdad);

		textEdad = new JTextField();
		textEdad.setBounds(321, 93, 103, 20);
		getContentPane().add(textEdad);
		textEdad.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(209, 57, 89, 14);
		getContentPane().add(lblContrasea);

		pswContra = new JPasswordField();
		pswContra.setBounds(321, 54, 103, 20);
		getContentPane().add(pswContra);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] datosRegistro = { textNombre.getText(), textApellidos.getText(), textDni.getText(),
						textEmail.getText(), textEdad.getText(), pswContra.getText(), textTlfn.getText(),
						(String) comboBoxProfesores.getSelectedItem() };

				miControlador.ComprobarRegistro(miControlador, datosRegistro);
				
				if(miControlador.adelante()!=1) {
					textNombre.setText("");
					textApellidos.setText("");
					textDni.setText("");
					textEmail.setText("");
					textEdad.setText("");
					pswContra.setText("");
					textTlfn.setText("");
				}
					

					//miControlador.cambiarPantalla(miControlador.getMisVistas(), 1, 0);
				

			}
		});
		btnRegistrarse.setBounds(157, 208, 102, 23);
		getContentPane().add(btnRegistrarse);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(miControlador.getMisVistas(), 1, 0);
			}
		});
		btnAtras.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAtras);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(208, 129, 72, 14);
		getContentPane().add(lblTelefono);

		textTlfn = new JTextField();
		textTlfn.setBounds(321, 126, 103, 20);
		getContentPane().add(textTlfn);
		textTlfn.setColumns(10);

		JLabel lblMiProfesorEs = new JLabel("Mi profesor es:");
		lblMiProfesorEs.setBounds(209, 167, 86, 14);
		getContentPane().add(lblMiProfesorEs);

		comboBoxProfesores = new JComboBox();
		comboBoxProfesores.setModel(new DefaultComboBoxModel(new String[] { "Soy profesor" }));
		comboBoxProfesores.setBounds(321, 163, 103, 22);
		getContentPane().add(comboBoxProfesores);

	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

}
