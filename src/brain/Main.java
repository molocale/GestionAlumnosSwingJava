package brain;

import vistas.*;

public class Main {
	public static void main(String[] args) {

		// Instancia de clases modelo, controlador y cada una de las vistas
		Modelo miModelo = new Modelo();
		Controlador miControlador = new Controlador();

		Login miLogin = new Login();
		Registro miRegistro = new Registro();

		// Añadimos al linkedList de controlador todas las vistas

		miControlador.getMisVistas().add(miLogin);
		miControlador.getMisVistas().add(miRegistro);
		

		// Añadimos al likedList de modelo todas las vistas

		miModelo.getMisVistas().add(miLogin);
		miModelo.getMisVistas().add(miRegistro);

		// Este no cambia y vale para todos
		miControlador.setMiModelo(miModelo);

		// La vista login:

		miLogin.setMiModelo(miModelo);
		miLogin.setMiControlador(miControlador);

		// La vista Registro:

		miRegistro.setMiControlador(miControlador);
		miRegistro.setMiModelo(miModelo);

		miLogin.setVisible(true);

	}
}