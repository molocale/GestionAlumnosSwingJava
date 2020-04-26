package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import brain.Controlador;
import brain.Modelo;

import javax.swing.JScrollPane;

public class tabla1Alumnos extends JFrame {
	
	private Modelo miModelo;
	private Controlador miControlador;
	
	
	
	
	private JPanel contentPane;
	private JTable miTabla;
	

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





	
	
	
//	private Object[][] datosFila = {
//		{"paco", "garica"},
//		{"antonii", "rivera"}
//	};
//	private String[] nombreColumna = {"nombre", "apellido"};
//	
	
	
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public tabla1Alumnos() {
		setTitle("Tabla de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 23, 700, 400);
		contentPane.add(scrollPane);
		
		miTabla = new JTable();
		miTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(miTabla);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				miTabla.setModel(miModelo.getTabla());
			}
		});
	}
		
		
	}

