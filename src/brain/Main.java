package brain;

import vistas.*;

public class Main {
	public static void main(String[] args) {

		// Instancia de clases
		Modelo miModelo = new Modelo();
		Controlador miControlador = new Controlador();
		Login miLogin = new Login();

		miModelo.setMiLogin(miLogin);
		miControlador.setMiLogin(miLogin);
		miControlador.setMiModelo(miModelo);
		miLogin.setMiModelo(miModelo);
		miLogin.setMiControlador(miControlador);
	}
}