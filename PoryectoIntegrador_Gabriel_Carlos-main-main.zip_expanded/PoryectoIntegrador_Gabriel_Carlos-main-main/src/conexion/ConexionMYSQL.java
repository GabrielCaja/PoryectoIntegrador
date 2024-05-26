/*@author
 * Gabriel Caja
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class ConexionMYSQL.
 */
public class ConexionMYSQL {

    /** The pass. */
    private String url, user, pass;
    
    /** The conn. */
    private static Connection conn;

    /**
     * Instantiates a new conexion MYSQL.
     */
    private ConexionMYSQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.url = "jdbc:mysql://localhost:3306/proyectointegrador";
            this.user = "root";
            this.pass= "";
            try {
                conn = DriverManager.getConnection(url, user, pass);
    
            } catch (SQLException e) {
                System.out.println("Ha habido algún problema en la conexión");
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {
        if(conn == null) {
            new ConexionMYSQL();
        }
        return conn;
    }
}
