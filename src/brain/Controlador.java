package brain;

import java.awt.Window;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.*;

import vistas.*;

public class Controlador {
	private Modelo miModelo;

	// Todas las vistas están contenidas en orden en el linkedList
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

	public boolean ComprobarRegistro(Controlador miControlador, String[] datosRegistro) {

		String nombre = datosRegistro[0];
		String apellidos = datosRegistro[1];
		String dni = datosRegistro[2];
		String email = datosRegistro[3];
		String edad = datosRegistro[4];
		String contra = datosRegistro[5];
		String tlfn = datosRegistro[6];
		String prof = datosRegistro[7];

		if (miControlador.nombreIsCorrect(nombre, miControlador)
				&& miControlador.apellidosIsCorrect(apellidos, miControlador)
				&& miControlador.emailIsCorrect(email, miControlador) && miControlador.dniIsCorrect(dni, miControlador)
				&& miControlador.edadIsCorrect(edad, miControlador)
				&& miControlador.tlfnIsCorrect(tlfn, miControlador)) {

			miModelo.añadirUsuario(datosRegistro, miControlador.isAlumnos(email, prof, miControlador), miControlador);
			return true;

		} else {
			miControlador.crearError("Revise su formulario ", "hay algún error");
			return false;
		}

	}

	private boolean tlfnIsCorrect(String tlfn, Controlador miControlador) {
		int lengg = tlfn.length();
		char mi = tlfn.charAt(0);
		
		
		if (tlfn.length() == 9 && tlfn.charAt(0) == '6' || tlfn.charAt(0) == '7') {
			return true;
		} else
			return false;
	}

	private boolean isAlumnos(String email, String prof, Controlador miControlador) {
		int posicionDelArroba = email.indexOf("@");
		String alumno = "@live.u-tad.com";
		String extensionEmail = email.substring(posicionDelArroba);
		
		if (extensionEmail.equals(alumno) && !prof.equals("Soy profesor")) {
			return true;

		} else {
			//miControlador.crearError("no se corresponde la extension", " con la eleccion del profesor");
			return false;
		}
			
	}

	private boolean edadIsCorrect(String edad, Controlador miControlador) {
		int edadInt = Integer.parseInt(edad);
		if (edad.length() < 4 || edadInt < 1955 || edadInt > 2002) {
			miControlador.crearError("La edad introducida", "es erronea");
			return false;
		} else
			return true;

	}

	private boolean dniIsCorrect(String dni, Controlador miControlador) {
		boolean areNumbers = false;
		char[] letraDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };
		for (int i = 0; i < dni.length(); i++) {
			char miChar = dni.charAt(i);
			if (!Character.isDigit(miChar)) {
				areNumbers = true;
			}
		}
		char letra = dni.substring(8).toUpperCase().charAt(0);
		int numeros = Integer.parseInt(dni.substring(0, 8));
		int indiceDeLaLetra = numeros % 23;

		if (dni.length() != 9 || !areNumbers || letra != letraDni[indiceDeLaLetra]) {
			miControlador.crearError("El DNI es", " erroneo");
			return false;

		}

		return true;
	}

	private boolean emailIsCorrect(String email, Controlador miControlador) {

		if (email.equals("")) {
			miControlador.crearError("El Email ", "debe ser rellenado");
			return false;
		} else if (!email.equals("")) {
			int posicionDelArroba = email.indexOf("@");
			String deseado = "@u-tad.com";
			String deseado2 = "@live.u-tad.com";
			if (posicionDelArroba == -1) {
				miControlador.crearError("el Email", " debe contener @ antes de la extension");
				return false;
			} else if ((!email.substring(posicionDelArroba).equals(deseado))
					&& (!email.substring(posicionDelArroba).equals(deseado2))) {
				miControlador.crearError("La extension del Email", " no es correcta");
				return false;
			} else {
				return true;
			}

		} else {
			return true;
		}

	}

	private boolean apellidosIsCorrect(String apellidos, Controlador miControlador) {
		boolean isGoodApe = true;
		for (int i = 0; i < apellidos.length(); i++) {
			char miChar = apellidos.charAt(i);
			if (Character.isDigit(miChar)) {
				isGoodApe = false;
			}
		}
		if (!isGoodApe || apellidos.length() > 50) {
			miControlador.crearError("los apellidos ", "son erroneos");
			return false;
		} else if (apellidos.equals("")) {
			miControlador.crearError("los apellidos ", "deben ser rellenado");
			return false;
		} else
			return true;
	}

	private boolean nombreIsCorrect(String nombre, Controlador miControlador) {
		boolean isGoodName = true;
		for (int i = 0; i < nombre.length(); i++) {
			char miChar = nombre.charAt(i);
			if (Character.isDigit(miChar)) {
				isGoodName = false;
			}
		}
		if (!isGoodName || nombre.length() > 25) {
			miControlador.crearError("el nombre", "es erroneo o contiene numeros");
			return false;
		} else if (nombre.equals("")) {
			miControlador.crearError("el nombre ", "debe ser rellenado");
			return false;
		} else
			return true;
	}

	private void crearError(String nombreDelCampoErroneo, String errorOcurrido) {
		// este metodo va a rcibir el dato que está mal rellenado para pasarselo al
		// JDialog
		Fail miFail = new Fail(nombreDelCampoErroneo, errorOcurrido);
		miFail.setVisible(true);

	}






	

}