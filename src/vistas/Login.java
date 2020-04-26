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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	// Atributos arquitectura de software:
	private Modelo miModelo;
	private Controlador miControlador;
	private Registro miRegistro;
	private Ajustes misAjustes;

	public Ajustes getMisAjustes() {
		return misAjustes;
	}

	public void setMisAjustes(Ajustes misAjustes) {
		this.misAjustes = misAjustes;
	}

	public Registro getMiRegistro() {
		return miRegistro;
	}

	public void setMiRegistro(Registro miRegistro) {
		this.miRegistro = miRegistro;
	}


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
				try {
					miModelo.pedirNombresDeProfes();
				} catch (SQLException e2) {
					System.out.println("Error en LOGIN1");
					e2.printStackTrace();
				}
				try {
					for (int j = 0; j < miModelo.pedirNombresDeProfes().size(); j++) {
						try {
							miRegistro.getComboBoxProfesores().addItem(miModelo.pedirNombresDeProfes().get(j));
						} catch (SQLException e1) {
							System.out.println("Error en LOGIN");
							e1.printStackTrace();
						}
					}
				} catch (SQLException e1) {
					System.out.println("Error en LOGIN3");
					e1.printStackTrace();
				}
				miControlador.cambiarPantalla(miControlador.getMisVistas(), 0, 1);
			}
		});
		btnRegistrarse.setBounds(333, 0, 101, 23);
		getContentPane().add(btnRegistrarse);
		
		JButton btnAjustes = new JButton("AJUSTES");
		btnAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(miControlador.getMisVistas(), 0, 2);
				miModelo.leerDatosConexion();
				misAjustes.getTextFieldUsuario().setText(miModelo.getUsr());
				misAjustes.getTextFieldPWD().setText(miModelo.getPwd());
				misAjustes.getTextNombreBbdd().setText(miModelo.getNombreBBDD());
				misAjustes.getTextFieldURLbbdd().setText(miModelo.getUrl());				
			}
		});
		btnAjustes.setBounds(333, 92, 89, 23);
		getContentPane().add(btnAjustes);

	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
}