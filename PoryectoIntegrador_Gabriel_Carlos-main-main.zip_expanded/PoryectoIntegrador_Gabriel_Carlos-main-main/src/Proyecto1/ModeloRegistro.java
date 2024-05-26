/*@author
 * Gabriel Caja
 */
package Proyecto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import conexion.AbstractConexion;

/**
 * The Class ModeloRegistro.
 */
public class ModeloRegistro extends AbstractConexion {

	/** The lista clientes. */
	public static ArrayList<ModeloRegistro> listaClientes = new ArrayList<>();
   
	
	/** The sc. */
	Scanner sc = new Scanner(System.in);
	
	/** The validado. */
	boolean validado = true;
	
	/** The super empresa. */
	boolean superEmpresa = false;
	
	/** The admin. */
	boolean admin ;
	
	/** The validado pass. */
	boolean validadoPass = false;
	
	/** The id. */
	private int id = 0;
	
	/** The confirmacion. */
	private String nickname, nombre, contrasena, contrasena2, ubicacion, preguntaSeguridad, respuestaSeguridad,
			superPoder, confirmacion;

	public ModeloRegistro() {
	}

	/**
	 * Instantiates a new modelo registro.
	 *
	 * @param id                 the id
	 * @param nickname           the nickname
	 * @param nombre             the nombre
	 * @param superPoder         the super poder
	 * @param contrasena         the contrasena
	 * @param contrasena2        the contrasena 2
	 * @param ubicacion          the ubicacion
	 * @param preguntaSeguridad  the pregunta seguridad
	 * @param respuestaSeguridad the respuesta seguridad
	 * @param listaClientes      the lista clientes
	 * @param admin              the admin
	 */
	// Registrar un superheroe
	public ModeloRegistro(int id, String nickname, String nombre, String superPoder, String contrasena, String contrasena2,
			String ubicacion, String preguntaSeguridad, String respuestaSeguridad, ArrayList<ModeloRegistro> listaClientes,
			boolean admin) {
		this.id = id;
		this.nickname = nickname;
		this.nombre = nombre;
		this.superPoder = superPoder;
		this.contrasena = contrasena;
		this.contrasena2 = contrasena2;
		this.ubicacion = ubicacion;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuestaSeguridad = respuestaSeguridad;
		this.admin = admin;
	}

	/**
	 * Instantiates a new modelo registro.
	 *
	 * @param id                 the id
	 * @param nickname           the nickname
	 * @param nombre             the nombre
	 * @param superPoder         the super poder
	 * @param contrasena         the contrasena
	 * @param contrasena2        the contrasena 2
	 * @param ubicacion          the ubicacion
	 * @param preguntaSeguridad  the pregunta seguridad
	 * @param respuestaSeguridad the respuesta seguridad
	 * @param listaClientes      the lista clientes
	 * @param confirmacion       the confirmacion
	 * @param admin              the admin
	 */
	// Registrar una superEmpresa
	public ModeloRegistro(int id, String nickname, String nombre, String superPoder, String contrasena, String contrasena2,
			String ubicacion, String preguntaSeguridad, String respuestaSeguridad, ArrayList<ModeloRegistro> listaClientes,
			String confirmacion,boolean admin) {
		this.id = id;
		this.nickname = nickname;
		this.nombre = nombre;
		this.superPoder = superPoder;
		this.contrasena = contrasena;
		this.contrasena2 = contrasena2;
		this.ubicacion = ubicacion;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuestaSeguridad = respuestaSeguridad;
		this.confirmacion = confirmacion;
		this.admin =admin;
	}
	
	/**
	 * Instantiates a new modelo registro.
	 *
	 * @param i       the i
	 * @param string  the string
	 * @param string2 the string 2
	 * @param string3 the string 3
	 * @param string4 the string 4
	 * @param string5 the string 5
	 * @param string6 the string 6
	 * @param string7 the string 7
	 * @param string8 the string 8
	 * @param b       the b
	 */
	public ModeloRegistro(int i, String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, boolean b) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the lista clientes.
	 *
	 * @return the lista clientes
	 */
	public static ArrayList<ModeloRegistro> getListaClientes() {
		return listaClientes;
	}

	/**
	 * Sets the lista clientes.
	 *
	 * @param listaClientes the new lista clientes
	 */
	public void setListaClientes(ArrayList<ModeloRegistro> listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the contrasena 2.
	 *
	 * @return the contrasena 2
	 */
	public String getContrasena2() {
		return contrasena2;
	}

	/**
	 * Sets the contrasena 2.
	 *
	 * @param contrasena2 the new contrasena 2
	 */
	public void setContrasena2(String contrasena2) {
		this.contrasena2 = contrasena2;
	}

	/**
	 * Gets the ubicacion.
	 *
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * Sets the ubicacion.
	 *
	 * @param ubicacion the new ubicacion
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * Gets the super poder.
	 *
	 * @return the super poder
	 */
	public String getSuperPoder() {
		return superPoder;
	}

	/**
	 * Sets the super poder.
	 *
	 * @param superPoder the new super poder
	 */
	public void setSuperPoder(String superPoder) {
		this.superPoder = superPoder;
	}

	/**
	 * Sets the nickname.
	 *
	 * @param nickname the new nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the pregunta seguridad.
	 *
	 * @return the pregunta seguridad
	 */
	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}

	/**
	 * Sets the pregunta seguridad.
	 *
	 * @param preguntaSeguridad the new pregunta seguridad
	 */
	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

	/**
	 * Gets the respuesta seguridad.
	 *
	 * @return the respuesta seguridad
	 */
	public String getRespuestaSeguridad() {
		return respuestaSeguridad;
	}

	/**
	 * Sets the respuesta seguridad.
	 *
	 * @param respuestaSeguridad the new respuesta seguridad
	 */
	public void setRespuestaSeguridad(String respuestaSeguridad) {
		this.respuestaSeguridad = respuestaSeguridad;
	}

	/**
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Gets the contrasena.
	 *
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the contrasena.
	 *
	 * @param contrasenaCambiada the new contrasena
	 */
	public void setContrasena(String contrasenaCambiada) {
		this.contrasena = contrasenaCambiada;
	}

	/**
	 * Sets the contrasena 1.
	 *
	 * @param contrasenaCambiada2 the new contrasena 1
	 */
	public void setContrasena1(String contrasenaCambiada2) {
		this.contrasena2 = contrasenaCambiada2;

	}

	/**
	 * Sets the administrador.
	 *
	 * @param administrador the new administrador
	 */
	public void setAdministrador(boolean administrador) {
		this.admin = administrador;
	}

	public boolean getAdministrador(ModeloRegistro re) {
		return re.admin;
	}

	public void mostrarUser() {
        try {
            st = conn.createStatement();
            query = "SELECT * FROM usuarios;";
            rs = st.executeQuery(query);

            // Formato de las columnas
            String format = "%-10s %-20s %-20s %-20s %-20s %-30s %-30s %-20s %-10s %-10s %-5s%n";
            
            // Imprimir cabeceras de columna
            System.out.printf(format, "ID", "Nickname", "Nombre", "Contraseña", "Contraseña2", "Pregunta Seguridad", "Respuesta Seguridad", "Superpoder", "ID Localización", "ID Recurso", "Admin");

            // Imprimir filas
            while (rs.next()) {
                System.out.printf(format, 
                    rs.getString("id_usuario"), 
                    rs.getString("nickname"), 
                    rs.getString("nombre"), 
                    rs.getString("contraseña"), 
                    rs.getString("contrasena2"), 
                    rs.getString("pregunta_seguridad"), 
                    rs.getString("respuesta_seguridad"), 
                    rs.getString("superpoder"), 
                    rs.getString("id_localizacion"), 
                    rs.getString("id_recurso"), 
                    rs.getString("admin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
       
        }
    }
	
	/**
	 * Insertar super empresa.
	 *
	 * @param superEmpresa the super empresa
	 */
	public static void insertarSuperEmpresa(ModeloRegistro superEmpresa) {
        try  {
            // Sentencia SQL de inserción
            String sql = "INSERT INTO usuarios ( nickname, nombre, contraseña, contrasena2, pregunta_seguridad,respuesta_seguridad,superpoder,id_localizacion,id_recurso,admin) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            
            //Preparamos la sentencia SQL
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, superEmpresa.getNickname());
            stmt.setString(2, superEmpresa.getNombre());
            stmt.setString(3, superEmpresa.getContrasena());
            stmt.setString(4, superEmpresa.getContrasena2());
            stmt.setString(5, superEmpresa.getPreguntaSeguridad());
            stmt.setString(6, superEmpresa.getRespuestaSeguridad());
            stmt.setString(7, superEmpresa.getSuperPoder());
            stmt.setInt(8, 1);
            stmt.setInt(9, 1);
            stmt.setBoolean(10, superEmpresa.admin);

            //Ejecutamos la inserción
            stmt.executeUpdate();
            
            System.out.println("SuperEmpresa insertada correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al insertar SuperEmpresa en la base de datos: " + e.getMessage());
        }
    }
	
	/**
	 * Insertar super heroe.
	 *
	 * @param registro the registro
	 */
	public static void insertarSuperHeroe(ModeloRegistro registro) {
        try  {
            //Sentencia SQL de inserción
            String sql = "INSERT INTO usuarios (nickname, nombre, contraseña, contrasena2, pregunta_seguridad,respuesta_seguridad,superpoder,id_localizacion,id_recurso,admin) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            
            // Preparamos la sentencia SQL
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, registro.getNickname());
            stmt.setString(2, registro.getNombre());
            stmt.setString(3, registro.getContrasena());
            stmt.setString(4, registro.getContrasena2());
            stmt.setString(5, registro.getPreguntaSeguridad());
            stmt.setString(6, registro.getRespuestaSeguridad());
            stmt.setString(7, registro.getSuperPoder());
            stmt.setInt(8, 1);
            stmt.setInt(9, 1);
            stmt.setBoolean(10, registro.admin);

            // Ejecutamos la inserción
            stmt.executeUpdate();
            
            System.out.println("SuperHeroe correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario en la base de datos " + e.getMessage());
        }
    }

	/**
	 * Registrar cliente.
	 *
	 * @param nickname           the nickname
	 * @param nombre             the nombre
	 * @param superPoder         the super poder
	 * @param contrasena         the contrasena
	 * @param contrasena2        the contrasena 2
	 * @param ubicacion          the ubicacion
	 * @param preguntaSeguridad  the pregunta seguridad
	 * @param respuestaSeguridad the respuesta seguridad
	 * @param confirmacionCrimen the confirmacion crimen
	 * @param aceptaTerminos     the acepta terminos
	 * @param admin              the admin
	 */
	// Registro principal para los clientes de la plataforma
	public void registrarCliente(String nickname, String nombre, String superPoder, String contrasena,
			String contrasena2, String ubicacion, String preguntaSeguridad, String respuestaSeguridad,
			boolean confirmacionCrimen, boolean aceptaTerminos,boolean admin) {
		// En el caso de ser superempresa
		if (confirmacionCrimen == true) {
			ModeloRegistro superEmpresa = new ModeloRegistro();
			if (confirmacionCrimen == true && aceptaTerminos == true) {
				String confirmacion = "Acepto terminos";
				asignarNickname(nickname);
				comprobarContraseña(contrasena, contrasena2);
				if (validado == true && validadoPass==true) {
					if(admin == true) {
						superEmpresa = new ModeloRegistro(id, nickname, nombre, superPoder, contrasena, contrasena2, ubicacion,
								preguntaSeguridad, respuestaSeguridad, listaClientes, confirmacion,true);
						listaClientes.add(superEmpresa);
						insertarSuperEmpresa(superEmpresa);

					}else {
						superEmpresa = new ModeloRegistro(id, nickname, nombre, superPoder, contrasena, contrasena2, ubicacion,
								preguntaSeguridad, respuestaSeguridad, listaClientes, confirmacion,false);
						listaClientes.add(superEmpresa);
						insertarSuperEmpresa(superEmpresa);
					}
					JOptionPane.showMessageDialog(null, "¡Registro exitoso para la empresa " + nombre + "!", "Registro",
							JOptionPane.INFORMATION_MESSAGE);
					mostrarUser();
					validado = false;
					validadoPass = false;
				}

			}
		}
		// Registro de un superheroe
		if (confirmacionCrimen == false) {
			asignarNickname(nickname);
			comprobarContraseña(contrasena, contrasena2);
			if (validado == true && validadoPass==true) {
				if(admin == true){
					ModeloRegistro registro = new ModeloRegistro(id, nickname, nombre, superPoder, contrasena, contrasena2, ubicacion,
							preguntaSeguridad, respuestaSeguridad, listaClientes, true);
					listaClientes.add(registro);
					insertarSuperHeroe(registro);
				}else {
					ModeloRegistro registro = new ModeloRegistro(id, nickname, nombre, superPoder, contrasena, contrasena2, ubicacion,
							preguntaSeguridad, respuestaSeguridad, listaClientes, false);
					listaClientes.add(registro);
					insertarSuperHeroe(registro);
				}
				
				JOptionPane.showMessageDialog(null, "¡Registro exitoso para " + nombre + "!", "Registro",
						JOptionPane.INFORMATION_MESSAGE);
				mostrarUser();				
				validado = false;
				validadoPass = false;
			}
		}

	}

	/**
	 * Asignar nickname.
	 *
	 * @param nickname the nickname
	 * @return true, if successful
	 */
	private boolean asignarNickname(String nickname) {
		if (!validarNickname(nickname) || listaClientes.contains(nickname)) {
			JOptionPane.showMessageDialog(null,
					"El nickname no es válido o ya está en uso. Inténtalo de nuevo" + nombre, "Registro",
					JOptionPane.INFORMATION_MESSAGE);
			validado = false;
		} else {
			validado = true;
		}
		return validado;
	}

	/**
	 * Validar nickname.
	 *
	 * @param nickname the nickname
	 * @return true, if successful
	 */
	private boolean validarNickname(String nickname) {
		// Verificar si el nickname cumple con los requisitos de estar compuesto por
		// caracteres anglosajones y números
		return nickname.matches("^[a-zA-Z0-9]+$");
	}

	// Se comprobara la contraseña para ver que cumple las medidas de seguridad y
	/**
	 * Comprobar contraseña.
	 *
	 * @param contrasena  the contrasena
	 * @param contrasena2 the contrasena 2
	 * @return true, if successful
	 */
	// requisitos
	public boolean comprobarContraseña(String contrasena, String contrasena2) {
		if(!contrasena.equals(contrasena2) || !validarContraseña(contrasena)) {
			JOptionPane.showMessageDialog(null, "Las contraseñas no cumplen los requisitos de seguridad", "Registro",
					JOptionPane.INFORMATION_MESSAGE);
			validadoPass = false;
		}else {
			validadoPass = true;
		}
		return validadoPass;
	}

	// Se comprobara la contraseña para ver que cumple las medidas de seguridad y
	/**
	 * Validar contraseña.
	 *
	 * @param password the password
	 * @return true, if successful
	 */
	// requisitos
	private boolean validarContraseña(String password) {
		return password.length() >= 6 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")
				&& password.matches(".*\\d.*");
	}

	// Metodo para cambiar la contraseña a partir de comprobar la pregunta y
	/**
	 * Restablecer contraseña.
	 *
	 * @param sc the sc
	 */
	// respuesta de seguridad y con un numero de intentos preestablecido(3)
	public void restablecerContraseña(Scanner sc) {
		int intentos = 3;
		do {
			System.out.println("¿Cuál es tu nickname en la plataforma?");
			String nickname = sc.next();

			ModeloRegistro registro = buscarRegistroPorNickname(nickname);
			if (registro != null) {
				System.out.println("Indica la respuesta a tu pregunta de seguridad:");
				System.out.println(registro.getPreguntaSeguridad());
				String respuesta = sc.next();

				if (registro.getRespuestaSeguridad().equals(respuesta)) {
					System.out.println("Introduce tu nueva contraseña:");
					String nuevaContraseña = sc.next();

					System.out.println("Introduce la nueva contraseña nuevamente:");
					String nuevaContraseñaConfirmacion = sc.next();

					registro.comprobarContraseña(nuevaContraseña, nuevaContraseñaConfirmacion);
					registro.setContrasena(nuevaContraseña);
					registro.setContrasena1(nuevaContraseñaConfirmacion);

					System.out.println("Contraseña cambiada con éxito.");
					// Salir del método una vez que la contraseña se haya cambiado con éxito
					return;
				} else {
					System.out.println("Respuesta incorrecta. Intenta de nuevo ." + intentos + " intentos");
					intentos--;
				}
			} else {
				System.out.println(
						"No se encontró el usuario con el nickname proporcionado, te quedan " + intentos + " intentos");
				intentos--;
			}
		} while (intentos > 0);

		System.out.println("Se ha excedido el número máximo de intentos.");
	}

	/**
	 * Buscar registro por nickname.
	 *
	 * @param nickname the nickname
	 * @return the modelo registro
	 */
	// Comprobar que el usuario esta registrado en la plataforma
	private ModeloRegistro buscarRegistroPorNickname(String nickname) {
		for (ModeloRegistro registro : listaClientes) {
			if (registro.getNickname().equals(nickname)) {
				return registro;
			}
		}
		return null;
	}

	// Metodo para iniciar sesion verificando si el usuario existe registrado en la
	/**
	 * Iniciar sesion.
	 *
	 * @param sc the sc
	 */
	// plataforma
	public void iniciarSesion(Scanner sc) {
		System.out.println("Introduzce tu nickname de usuario:");
		String nickname = sc.next();
		System.out.println("Introduzce tu contraseña:");
		String contrasena = sc.next();

		boolean usuarioEncontrado = false;
		for (ModeloRegistro registro : listaClientes) {
			if (registro.getNickname().equals(nickname) && registro.getContrasena().equals(contrasena)) {
				System.out.println("Bienvenido de nuevo: " + registro.getNombre());
				usuarioEncontrado = true;
				break;
			}

		}
		// En caso de no encontrar al usuario
		if (!usuarioEncontrado) {
			System.out.println("Credenciales incorrectas. Por favor, inténtalo de nuevo.");
		}

	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Registro "+ id + "[ Administrador: "+ admin+ ", nickname=" + nickname + ", nombre=" + nombre + ", contrasena=" + contrasena
				+ ", contrasena2=" + contrasena2 + ", ubicacion=" + ubicacion + ", preguntaSeguridad="
				+ preguntaSeguridad + ", respuestaSeguridad=" + respuestaSeguridad + ", superPoder=" + superPoder +"\n]";
	}
	
	/**
	 * Registrar admin.
	 */
	//Registrar administrador para tener un usuario poro defectos
	public void registrarAdmin() {
		ModeloRegistro administrador = new ModeloRegistro(99, "admin", "admin", "admin", "admin123", "admin123", "admin",
				"admin", "admin", listaClientes, confirmacion,true);
		listaClientes.add(administrador);
	}

}
