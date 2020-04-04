package vistas;

import java.awt.BorderLayout;
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
import java.awt.event.ActionEvent;

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

	public Registro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblRegistro = new JLabel("REGISTRO:");
		lblRegistro.setBounds(170, 23, 91, 14);
		getContentPane().add(lblRegistro);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(43, 62, 46, 14);
		getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(99, 59, 86, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(43, 105, 46, 14);
		getContentPane().add(lblApellidos);

		textApellidos = new JTextField();
		textApellidos.setBounds(99, 102, 86, 20);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(238, 105, 46, 14);
		getContentPane().add(lblDni);

		textDni = new JTextField();
		textDni.setBounds(307, 102, 86, 20);
		getContentPane().add(textDni);
		textDni.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(43, 149, 46, 14);
		getContentPane().add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(99, 146, 86, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(238, 149, 46, 14);
		getContentPane().add(lblEdad);

		textEdad = new JTextField();
		textEdad.setBounds(307, 146, 86, 20);
		getContentPane().add(textEdad);
		textEdad.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(222, 62, 62, 14);
		getContentPane().add(lblContrasea);

		pswContra = new JPasswordField();
		pswContra.setBounds(307, 59, 86, 20);
		getContentPane().add(pswContra);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(miControlador.getMisVistas(), 1, 0);
			}
		});
		btnRegistrarse.setBounds(170, 208, 89, 23);
		getContentPane().add(btnRegistrarse);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(miControlador.getMisVistas(), 1, 0);
			}
		});
		btnAtras.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAtras);

	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

}
