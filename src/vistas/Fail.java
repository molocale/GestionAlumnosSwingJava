package vistas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

import brain.*;
import java.awt.event.ActionEvent;

public class Fail extends JDialog {
	private Controlador miControlador;
	
	public Fail (String nombreDelCampoIncorrecto, String errorOcurrido) {
		   	setBounds(100, 100, 450, 300);
	        setVisible(true);
	        setTitle("Error Registro");
	        getContentPane().setLayout(null);
	        JLabel lblestasSeguroDe = new JLabel(nombreDelCampoIncorrecto + errorOcurrido);
	        lblestasSeguroDe.setBounds(10, 11, 414, 165);
	        lblestasSeguroDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        getContentPane().add(lblestasSeguroDe);

	        JButton btnAceptar = new JButton("Aceptar");
	        btnAceptar.setBounds(165, 207, 106, 43);
	        btnAceptar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		setVisible(false);
	        	}
	        });
	        btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        getContentPane().add(btnAceptar);
	       
		
	}
	

}
