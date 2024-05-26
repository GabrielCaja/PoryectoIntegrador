/*@author
 * Gabriel Caja
 */
package Proyecto1;
import javax.swing.*;

import conexion.ConexionMYSQL;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class InterfazCambiarPass.
 */
public class InterfazCambiarPass extends JFrame {
    
    /** The nickname field. */
    private JTextField nicknameField;
    
    /** The security answer field. */
    private JPasswordField securityAnswerField;
    
    /** The change password button. */
    private JButton changePasswordButton;
    
    /** The password field. */
    private JPasswordField passwordField;
    
    /** The intentos. */
    private int intentos = 3;
    
    /** The campos editados. */
    private boolean camposEditados = false; 

    /**
	 * Instantiates a new interfaz cambiar pass.
	 */
    public InterfazCambiarPass() {
        setTitle("Cambiar Contraseña");
        setSize(367, 457);
        
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(64, 128, 128));

        JLabel nicknameLabel = new JLabel("Nickname:");
        nicknameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        nicknameLabel.setForeground(new Color(255, 255, 255));
        nicknameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nicknameLabel.setBounds(0, 38, 162, 35);
        nicknameLabel.setBackground(new Color(64, 128, 128));
        nicknameField = new JTextField();
        nicknameField.setBounds(172, 40, 148, 35);
        JLabel securityAnswerLabel = new JLabel("Respuesta:");
        securityAnswerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        securityAnswerLabel.setForeground(new Color(255, 255, 255));
        securityAnswerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        securityAnswerLabel.setBounds(0, 158, 162, 35);
        securityAnswerField = new JPasswordField();
        securityAnswerField.setHorizontalAlignment(SwingConstants.CENTER);
        securityAnswerField.setBounds(172, 160, 148, 35);
        changePasswordButton = new JButton("Cambiar Contrasena");
        changePasswordButton.setBounds(45, 334, 252, 47);
        panel.setLayout(null);

        panel.add(nicknameLabel);
        panel.add(nicknameField);
        panel.add(securityAnswerLabel);
        panel.add(securityAnswerField);
        panel.add(changePasswordButton);

        changePasswordButton.addActionListener(new ActionListener() {
            
           
            /**
			 * Action performed.
			 *
			 * @param e the e
			 */
            public void actionPerformed(ActionEvent e) {
                camposEditados = true; 
                String nickname = nicknameField.getText();
                String securityAnswer = new String(securityAnswerField.getPassword());
                String newPassword = new String(passwordField.getPassword());

                restablecerContraseña(nickname, securityAnswer, newPassword);
            }
        });

        getContentPane().add(panel);

        JLabel lblPreuntaDeSeguridad = new JLabel("Nombre de tu primera mascota?");
        lblPreuntaDeSeguridad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        lblPreuntaDeSeguridad.setHorizontalAlignment(SwingConstants.CENTER);
        lblPreuntaDeSeguridad.setBounds(10, 102, 329, 35);
        panel.add(lblPreuntaDeSeguridad);

        JLabel lblNuevaContrsasea = new JLabel("Nueva Contraseña:");
        lblNuevaContrsasea.setHorizontalAlignment(SwingConstants.CENTER);
        lblNuevaContrsasea.setForeground(Color.WHITE);
        lblNuevaContrsasea.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNuevaContrsasea.setBounds(0, 247, 162, 35);
        panel.add(lblNuevaContrsasea);

        passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(172, 249, 148, 35);
        panel.add(passwordField);
        setVisible(true);
    }
   
    
   
    /**
	 * Actualizar contrasena en BD.
	 *
	 * @param nickname        the nickname
	 * @param nuevaContrasena the nueva contrasena
	 */
    public static void actualizarContrasenaEnBD(String nickname, String nuevaContrasena) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn =  ConexionMYSQL.getConnection();
            String sql = "UPDATE usuarios SET contraseña = ? WHERE nickname = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nuevaContrasena);
            stmt.setString(2, nickname);

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Contraseña actualizada correctamente.");
            } else {
                System.out.println("No se encontró el usuario con el nickname proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar la contraseña en la base de datos: " + e.getMessage());
         }
        }
    
    /**
	 * Restablecer contraseña.
	 *
	 * @param nickname        the nickname
	 * @param respuesta       the respuesta
	 * @param nuevaContraseña the nueva contraseña
	 */
    public void restablecerContraseña(String nickname, String respuesta, String nuevaContraseña) {
        ModeloRegistro registro = buscarUsuarioEnBD(nickname);
        if (registro != null) {
            if (registro.getRespuestaSeguridad().equals(respuesta)) {
                if (comprobarContraseña(nuevaContraseña, nuevaContraseña)) {
                    actualizarContrasenaEnBD(nickname, nuevaContraseña);
                    registro.setContrasena(nuevaContraseña);
                    registro.setContrasena1(nuevaContraseña);
                    JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito.");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "La nueva contraseña no cumple con los requisitos de seguridad.");
                }
            } else {
                intentos--;
                if (intentos > 0 && camposEditados) {
                    JOptionPane.showMessageDialog(null, "Respuesta incorrecta. Intenta de nuevo. Te quedan " + intentos + " intentos");
                } else if (intentos == 0 && camposEditados) {
                    JOptionPane.showMessageDialog(null, "Se ha excedido el número máximo de intentos.");
                    limpiarCampos();
                }
            }
        } else {
            intentos--;
            if (intentos > 0 && camposEditados) {
                JOptionPane.showMessageDialog(null, "No se encontró el usuario con el nickname proporcionado. Te quedan " + intentos + " intentos");
            } else if (intentos == 0 && camposEditados) {
                JOptionPane.showMessageDialog(null, "Se ha excedido el número máximo de intentos.");
                limpiarCampos();
            }
        }
    }
    
    /**
	 * Comprobar contraseña.
	 *
	 * @param contrasena  the contrasena
	 * @param contrasena2 the contrasena 2
	 * @return true, if successful
	 */
    public boolean comprobarContraseña(String contrasena, String contrasena2) {
        if (!contrasena.equals(contrasena2) || !validarContraseña(contrasena)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no cumplen los requisitos de seguridad");
            return false;
        } else {
            return true;
        }
    }

    /**
	 * Validar contraseña.
	 *
	 * @param password the password
	 * @return true, if successful
	 */
    // Método para validar la contraseña (ajusta según tus requisitos)
    private boolean validarContraseña(String password) {
        return password.length() >= 6 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }
    
    /**
	 * Buscar usuario en BD.
	 *
	 * @param nickname the nickname
	 * @return the modelo registro
	 */
    public static ModeloRegistro buscarUsuarioEnBD(String nickname) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ModeloRegistro registro = null;

        try {
            conn = ConexionMYSQL.getConnection();
            String sql = "SELECT * FROM usuarios WHERE nickname = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Crear un objeto ModeloRegistro con los datos obtenidos de la base de datos
                registro = new ModeloRegistro();
                registro.setId(rs.getInt("id_usuario"));
                registro.setNickname(rs.getString("nickname"));
                registro.setNombre(rs.getString("nombre"));
                registro.setContrasena(rs.getString("contraseña"));
                registro.setContrasena2(rs.getString("contrasena2"));
                registro.setPreguntaSeguridad(rs.getString("pregunta_seguridad"));
                registro.setRespuestaSeguridad(rs.getString("respuesta_seguridad"));
                registro.setSuperPoder(rs.getString("superpoder"));
                // Añadir cualquier otro campo necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar el usuario en la base de datos: " + e.getMessage());
        } 
        return registro;
    }
    
 

    /**
	 * Buscar registro por nickname.
	 *
	 * @param nickname the nickname
	 * @return the modelo registro
	 */
    private ModeloRegistro buscarRegistroPorNickname(String nickname) {
    	for (ModeloRegistro registro : ModeloRegistro.getListaClientes()) {
			if (registro.getNickname().equals(nickname)) {
				return registro;
			}
		}
		return null;
	}
     

    /**
	 * Limpiar campos.
	 */
    private void limpiarCampos() {
        nicknameField.setText("");
        securityAnswerField.setText("");
        passwordField.setText("");
        camposEditados = false; 
        intentos = 3; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            /**
			 * Run.
			 */
            public void run() {
                new InterfazCambiarPass();
            }
        });
    }
}
