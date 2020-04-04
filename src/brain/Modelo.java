package brain;

import java.util.LinkedList;

import javax.swing.JFrame;

import vistas.*;

public class Modelo {
	//Todas las vistas están contenidas en orden en el linkedList
	private LinkedList<JFrame> misVistas = new LinkedList<JFrame>();

	public LinkedList<JFrame> getMisVistas() {
		return misVistas;
	}

	public void setMisVistas(LinkedList<JFrame> misVistas) {
		this.misVistas = misVistas;
	}



}