package brain;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import vistas.*;

public class Modelo {
	// Los atributos necesarios para la conexion:
//	private String nombreBBDD = "swingjavapracticasbbdd";
//	private String url = "jdbc:mysql://localhost/" + nombreBBDD
//			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//	private String pwd = "";
//	private String usr = "root";
//	private Connection miConexion;

	private String nombreBBDD;
	private String url;
	private String pwd;
	private String usr;
	private Connection miConexion;
	

	// Atributos de las vistas: Las vistas están contenidas en orden en el
	// linkedList
	private LinkedList<JFrame> misVistas = new LinkedList<JFrame>();

	private DefaultTableModel miTabla;

	private String alumnos;

	public String getNombreBBDD() {
		return nombreBBDD;
	}

	public void setNombreBBDD(String nombreBBDD) {
		this.nombreBBDD = nombreBBDD;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}


	public Modelo() {
		try {
			// En sistemas antiguos, para que
			// DriverManager tuviera "registrados" los drivers, era necesario cargar la
			// clase en la máquina virtual. Para eso es el Class.forName(), simplemente
			// carga la clase con el nombre indicado.
			// A partir de JDK 6, los drivers JDBC 4 ya se registran automáticamente y no es
			// necesario el Class.forName(), sólo que estén en el classpath de la JVM.

			// Class.forName("com.mysql.cj.jdbc.Driver");
			
			leerDatosConexion();

			miConexion = DriverManager.getConnection(url, usr, pwd);
			System.out.println("conexión lista");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al conectarse a la BBDD");
			// este error puede pasar porque el XAMMP esta apagado, o la maquina oracle no
			// está activa
			// también puede ser que la contraseña, usuario o url esten incorrectas
		} catch (Exception e) {
			System.out.println("se ha producido un error");
			alumnos = "Select * from alumnos";
			// cargarAlumnos();

			// este catch coge cualquier cosa
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

	public int añadirUsuario(String[] datosRegistro, int isAlumno, Controlador miControlador) {
		String[] apellidos = datosRegistro[1].split(" ");
		try {

			if (isAlumno == 1) {
				PreparedStatement addAlum = miConexion.prepareStatement(
						"INSERT INTO alumnos (nombre, nombre_profesor, apellido1, apellido2, dni, email, año_nac, contraseña, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				addAlum.setString(1, datosRegistro[0]);
				addAlum.setString(2, datosRegistro[7]);
				addAlum.setString(3, apellidos[0]);
				addAlum.setString(4, apellidos[1]);
				addAlum.setString(5, datosRegistro[2]);
				addAlum.setString(6, datosRegistro[3]);
				addAlum.setString(7, datosRegistro[4]);
				addAlum.setString(8, datosRegistro[5]);
				addAlum.setString(9, datosRegistro[6]);

				addAlum.executeUpdate();
				addAlum.close();
				miControlador.cambiarPantalla(misVistas, 1, 0);
				System.out.println("se ha insertado con exito el alumno");
				return 0;
			} else if (isAlumno == 3) {
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
				System.out.println("se ha insertado con exito el profesor");
				return 0;
			} else {
				miControlador.crearError("Email de alumno, ", "elige un profesor");
				return 1;
			}

		} catch (SQLException e) {
			System.out.println("problema al añadir al usuario en la BBDD");
			e.printStackTrace();
			return 1;
		}

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

//	private void cargarAlumnos() {
//		miTabla = new DefaultTableModel();
//		int numColumnas = getNumColumnas(alumnos);
//		Object[] contenido = new Object[numColumnas];
//		PreparedStatement pstmt;
//		try {
//			pstmt = miConexion.prepareStatement(alumnos);
//			ResultSet rset = pstmt.executeQuery();
//			ResultSetMetaData rsmd = rset.getMetaData();
//			for (int i = 0; i < numColumnas; i++) {
//				miTabla.addColumn(rsmd.getColumnName(i + 1));
//			}
//			while (rset.next()) {
//				for (int col = 1; col <= numColumnas; col++) {
//					contenido[col - 1] = rset.getString(col);
//				}
//				miTabla.addRow(contenido);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("fallo en la inserccion de datos en la tabla ");
//		}
//
//	}

//	private int getNumColumnas(String sql) {
//		int num = 0;
//		try {
//			PreparedStatement pstmt = miConexion.prepareStatement(sql);
//			ResultSet rset = pstmt.executeQuery();
//			ResultSetMetaData rsmd = rset.getMetaData();
//			num = rsmd.getColumnCount();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return num;
//	}

	public DefaultTableModel getTabla() {
		return miTabla;
	}
	
	public void leerDatosConexion() {
		//String [] misDatos = new String[4];
		
		File miRuta = new File ("src/datosConexion.ini");
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
			nombreBBDD= clave[0].substring((clave[0].indexOf('=')+1), clave[0].length());
			url = clave[1].substring((clave[1].indexOf('=')+2), clave[1].length());
			pwd = clave[2].substring((clave[2].indexOf('=')+2), clave[2].length());
			usr = clave[3].substring((clave[3].indexOf('=')+2), clave[3].length());
			
				
			
			//System.out.println(texto);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error en el FileReader");
		}
		
		
	}

}