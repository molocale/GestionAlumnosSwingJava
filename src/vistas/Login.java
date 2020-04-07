package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import brain.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	// Atributos arquitectura de software:
	private Modelo miModelo;
	private Controlador miControlador;

	// Atributos interface grafica
	private JButton btnLogin;
	private JPasswordField txtPwd;
	private JTextField txtUsr;

	public Login() {
	
		setTitle("Login");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblUsr = new JLabel("Usuario");
		lblUsr.setBounds(60, 74, 93, 14);
		getContentPane().add(lblUsr);

		JLabel lblPwd = new JLabel("Contrase\u00F1a");
		lblPwd.setBounds(60, 113, 93, 14);
		getContentPane().add(lblPwd);

		txtUsr = new JTextField();
		txtUsr.setBounds(163, 71, 109, 20);
		getContentPane().add(txtUsr);
		txtUsr.setColumns(10);

		txtPwd = new JPasswordField();
		txtPwd.setBounds(163, 111, 109, 20);
		getContentPane().add(txtPwd);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(183, 176, 89, 23);
		getContentPane().add(btnLogin);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(miControlador.getMisVistas(), 0, 1);
			}
		});
		btnRegistrarse.setBounds(333, 0, 101, 23);
		getContentPane().add(btnRegistrarse);

	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
}