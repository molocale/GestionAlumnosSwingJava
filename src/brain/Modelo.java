package brain;

import java.sql.*;
import java.util.LinkedList;

import javax.swing.JFrame;

import vistas.*;

public class Modelo {
	// Los atributos necesarios para la conexion:
	private String nombreBBDD = "swingjavapracticasbbdd";
	private String url = "jdbc:mysql://localhost/" + nombreBBDD
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String pwd = "";
	private String usr = "root";
	private Connection miConexion;

	// Atributos de las vistas: Las vistas están contenidas en orden en el
	// linkedList
	private LinkedList<JFrame> misVistas = new LinkedList<JFrame>();

	public Modelo() {
		try {
			// En sistemas antiguos, para que
			// DriverManager tuviera "registrados" los drivers, era necesario cargar la
			// clase en la máquina virtual. Para eso es el Class.forName(), simplemente
			// carga la clase con el nombre indicado.
			// A partir de JDK 6, los drivers JDBC 4 ya se registran automáticamente y no es
			// necesario el Class.forName(), sólo que estén en el classpath de la JVM.

			// Class.forName("com.mysql.cj.jdbc.Driver");
			miConexion = DriverManager.getConnection(url, usr, pwd);
			System.out.println("connexión lista");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al conectarse a la BBDD");
			// este error puede pasar porque el XAMMP esta apagado, o la maquina oracle no
			// está activa
			// también puede ser que la contraseña, usuario o url esten incorrectas
		} catch (Exception e) {
			System.out.println("se ha producido un error"); // este catch coge cualquier cosa
		} /*
			 * catch (ClassNotFoundException e) { System.out.println(); }
			 */
		// este se pondria si se pusiera el Class.forName() de arriba
	}

	public LinkedList<JFrame> getMisVistas() {
		return misVistas;
	}

	public void setMisVistas(LinkedList<JFrame> misVistas) {
		this.misVistas = misVistas;
	}

	public void añadirUsuario(String[] datosRegistro, boolean alumnos, Controlador miControlador) {
		String[] apellidos = datosRegistro[1].split(" ");
		try {

			if (alumnos) {
//				PreparedStatement addAlum = miConexion.prepareStatement("INSERT INTO alumnos (dni, nombre, apellido1, apellido2, email, año_nac, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?)");
//				addAlum.setString(1, datosRegistro[0]);
//				addAlum.setString(2, apellidos[0] );
//				addAlum.setString(3, apellidos[1]);
//				addAlum.setString(4, datosRegistro[2]);
//				addAlum.setString(5, datosRegistro[3]);
//				addAlum.setString(6, datosRegistro[4]);
//				addAlum.setString(7, datosRegistro[5]);
//				//addAlum.setString(8, datosRegistro[6]);
//				//addAlum.setString(9, datosRegistro[7]);
//				addAlum.executeUpdate();
//				addAlum.close();
				System.out.println("se ha insertado con exito el alumno");
			} else {
				PreparedStatement addProf = miConexion.prepareStatement(
						"INSERT INTO profesor (nombre, apellido1, apellido2, dni, email, año_nac, contraseña, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
				addProf.setString(1, datosRegistro[0]);
				addProf.setString(2, apellidos[0]);
				addProf.setString(3, apellidos[1]);
				addProf.setString(4, datosRegistro[2]);
				addProf.setString(5, datosRegistro[3]);
				addProf.setString(6, datosRegistro[4]);
				addProf.setString(7, datosRegistro[5]);
				addProf.setString(8, datosRegistro[6]);
				addProf.executeUpdate();
				addProf.close();
				
				miControlador.cambiarPantalla(misVistas, 1, 0);
				//miControlador.añadirItemAlComboBox();

				System.out.println("se ha insertado con exito el prpofesor");
			}

		} catch (SQLException e) {
		  System.out.println("problema al añadir al usuario en la BBDD");
		  e.printStackTrace(); }
		 
	}

	public LinkedList<String> pedirNombresDeProfes() throws SQLException {
		LinkedList<String> listaProfes = new LinkedList<String>();
		String miQuery = "SELECT nombre FROM profesor";
		Statement miStatement = miConexion.createStatement();
		ResultSet miResultSet = miStatement.executeQuery(miQuery);
		
		while (miResultSet.next()) {
			listaProfes.add(miResultSet.getString("nombre"));
		}

		
		return listaProfes;
		
		
	}
	



}