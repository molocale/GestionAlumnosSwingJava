package brain;

import java.awt.Window;
import java.util.LinkedList;

import javax.swing.*;

import vistas.*;

public class Controlador {
	private Modelo miModelo;

	//Todas las vistas están contenidas en orden en el linkedList
	private LinkedList<JFrame> misVistas = new LinkedList<JFrame>();

	public LinkedList<JFrame> getMisVistas() {
		return misVistas;
	}

	public void setMisVistas(LinkedList<JFrame> misVistas) {
		this.misVistas = misVistas;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void cambiarPantalla(LinkedList<JFrame> misVistas, int origen, int destino) {
		int contador = 0;

		for (JFrame vista : misVistas) {
			if (contador == origen) {
				vista.setVisible(false);
			} else if (contador == destino) {
				vista.setVisible(true);
			}
			contador++;

		}

	}

}