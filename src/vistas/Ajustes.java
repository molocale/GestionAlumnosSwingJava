package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import brain.Controlador;
import brain.Modelo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Ajustes extends JFrame {
	private Modelo miModelo;
	private Controlador miControlador;

	private JPanel contentPane;
	private JTextField textNombreBbdd;
	private JTextField textFieldURLbbdd;
	private JTextField textFieldUsuario;
	private JTextField textFieldPWD;

	public Ajustes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la BBDD:");
		lblNombreDeLa.setBounds(27, 54, 109, 14);
		contentPane.add(lblNombreDeLa);
		
		JLabel lblAjustosDeConexin = new JLabel("Ajustos de conexi\u00F3n a la BBDD");
		lblAjustosDeConexin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAjustosDeConexin.setBounds(93, 11, 257, 14);
		contentPane.add(lblAjustosDeConexin);
		
		textNombreBbdd = new JTextField();
		textNombreBbdd.setBounds(195, 51, 142, 20);
		contentPane.add(textNombreBbdd);
		textNombreBbdd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("URL de la BBDD:");
		lblNewLabel.setBounds(27, 166, 92, 14);
		contentPane.add(lblNewLabel);
		
		textFieldURLbbdd = new JTextField();
		textFieldURLbbdd.setBounds(117, 163, 307, 20);
		contentPane.add(textFieldURLbbdd);
		textFieldURLbbdd.setColumns(10);
		
		JLabel lblUsuarioDeLa = new JLabel("Usuario de la BBDD:");
		lblUsuarioDeLa.setBounds(27, 92, 109, 14);
		contentPane.add(lblUsuarioDeLa);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(195, 89, 86, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContraseaDeLa = new JLabel("Contrase\u00F1a de la BBDD :");
		lblContraseaDeLa.setBounds(27, 125, 118, 14);
		contentPane.add(lblContraseaDeLa);
		
		textFieldPWD = new JTextField();
		textFieldPWD.setBounds(195, 120, 86, 20);
		contentPane.add(textFieldPWD);
		textFieldPWD.setColumns(10);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(195, 197, 89, 23);
		contentPane.add(btnCambiar);
		
		JButton btnAtrs = new JButton("atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(miControlador.getMisVistas(), 2, 0);
				//System.out.println("Despues "+miModelo.getNombreBBDD());
			}
		});
		btnAtrs.setBounds(0, 238, 89, 23);
		contentPane.add(btnAtrs);
	}
	
	public Modelo getMiModelo() {
		return miModelo;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public Controlador getMiControlador() {
		return miControlador;
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
	
	
	
	
	public JTextField getTextNombreBbdd() {
		return textNombreBbdd;
	}

	public void setTextNombreBbdd(JTextField textNombreBbdd) {
		this.textNombreBbdd = textNombreBbdd;
	}

	public JTextField getTextFieldURLbbdd() {
		return textFieldURLbbdd;
	}

	public void setTextFieldURLbbdd(JTextField textFieldURLbbdd) {
		this.textFieldURLbbdd = textFieldURLbbdd;
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public void setTextFieldUsuario(JTextField textFieldUsuario) {
		this.textFieldUsuario = textFieldUsuario;
	}

	public JTextField getTextFieldPWD() {
		return textFieldPWD;
	}

	public void setTextFieldPWD(JTextField textFieldPWD) {
		this.textFieldPWD = textFieldPWD;
	}

	/*public void leerDatosConexion() {
		//String [] misDatos = new String[4];
		
		File miRuta = new File ("src/datosConexion.txt");
//		System.out.println(miRuta.getAbsolutePath());
//		System.out.println(miRuta.exists());
		try {
			String texto = "";
			FileReader fr = new FileReader(miRuta);
			int ultimoChar = fr.read();
			
			while (ultimoChar !=-1) {
				ultimoChar = fr.read();
				
				char letra = (char) ultimoChar;
				texto = texto +letra;
				
				
			}
			
			
			String[] clave = texto.split(";");
			String nombre = clave[0].substring((clave[0].indexOf('=')+1), clave[0].length());
			String url = clave[1].substring((clave[1].indexOf('=')+1), clave[1].length());
			String pwd = clave[2].substring((clave[2].indexOf('=')+1), clave[2].length());
			String usr = clave[3].substring((clave[3].indexOf('=')+1), clave[3].length());
			
			miModelo.setNombreBBDD(nombre);
			miModelo.setUrl(url);
			miModelo.setPwd(pwd);
			miModelo.setUsr(usr);
			
			
			
			
//			System.out.println(Arrays.toString(clave));
//			System.out.println(nombre);
//			System.out.println(url);
//			System.out.println(pwd);
//			System.out.println(usr);

			
			
			
			
			
			
			//System.out.println(texto);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error en el FileReader");
		}
		
		
		
		
		//return misDatos;
	}
	
	*/
	
	
	
}
