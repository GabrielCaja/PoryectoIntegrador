/*@author
 * Gabriel Caja
 */
package Proyecto1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.ConexionMYSQL;

/**
 * The Class ModeloLogin.
 */
public class ModeloLogin {
    
    /**
	 * Instantiates a new modelo login.
	 */
    public ModeloLogin() {
    	
    }
    /**
	 * Iniciar sesion.
	 *
	 * @param nickname   the nickname
	 * @param contrasena the contrasena
	 * @return true, if successful
	 */
    public static boolean iniciarSesion(String nickname, String contrasena) {
        boolean exitoso = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
        	//Obtener conexión a la base de datos
            conn = ConexionMYSQL.getConnection(); 
            String sql = "SELECT * FROM usuarios WHERE nickname = ? AND contraseña = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            stmt.setString(2, contrasena);
            rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bienvenido de nuevo: " + rs.getString("nombre"));
                
                boolean esAdmin = rs.getBoolean("admin");
                if (esAdmin) {
                    MenuAdministrador windowAdmin = new MenuAdministrador();
                    windowAdmin.abrirVista();
                } else {
                    MenuUsuario windowUsuario = new MenuUsuario();
                    windowUsuario.abrirVista();
                }
                exitoso = true;
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Por favor, inténtalo de nuevo.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
        }    
        return exitoso;
    }
}