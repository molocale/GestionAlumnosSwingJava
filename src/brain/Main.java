package brain;

import vistas.*;

public class Main {
	public static void main(String[] args) {

		// Instancia de clases modelo, controlador y cada una de las vistas
		Modelo miModelo = new Modelo();
		Controlador miControlador = new Controlador();

		Login miLogin = new Login();
		Registro miRegistro = new Registro();
		//tabla1Alumnos tablaAlum = new tabla1Alumnos();
		Ajustes misAjustes = new Ajustes();

		// Añadimos al linkedList de controlador todas las vistas

		miControlador.getMisVistas().add(miLogin);
		miControlador.getMisVistas().add(miRegistro);
		//miControlador.getMisVistas().add(tablaAlum);
		miControlador.getMisVistas().add(misAjustes);
		

		// Añadimos al likedList de modelo todas las vistas

		miModelo.getMisVistas().add(miLogin);
		miModelo.getMisVistas().add(miRegistro);
		//miModelo.getMisVistas().add(tablaAlum);
		miModelo.getMisVistas().add(misAjustes);

		// Este no cambia y vale para todos
		miControlador.setMiModelo(miModelo);

		// La vista login:

		miLogin.setMiModelo(miModelo);
		miLogin.setMiControlador(miControlador);
		miLogin.setMiRegistro(miRegistro);
		miLogin.setMisAjustes(misAjustes);

		// La vista Registro:

		miRegistro.setMiControlador(miControlador);
		miRegistro.setMiModelo(miModelo);
		
		// la vista tablaAlum
		
//		tablaAlum.setMiModelo(miModelo);
//		tablaAlum.setMiControlador(miControlador);
//		
		//la vista de Ajustes
		
		misAjustes.setMiModelo(miModelo);
		misAjustes.setMiControlador(miControlador);
		

		miLogin.setVisible(true);
		//tablaAlum.setVisible(false);
		
		

		//miModelo.estructuraTabla();
	}
}