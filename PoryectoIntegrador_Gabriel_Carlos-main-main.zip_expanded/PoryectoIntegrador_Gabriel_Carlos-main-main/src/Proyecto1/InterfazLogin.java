/*@author
 * Gabriel Caja
 */
package Proyecto1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The Class InterfazLogin.
 */
public class InterfazLogin extends JFrame {
    
    /** The tf nickname. */
    private JTextField tfNickname;
    
    /** The pf password. */
    private JPasswordField pfPassword;
    
    /** The btn login. */
    private JButton btnLogin;

    /** The login listener. */
    private ActionListener loginListener;

    public InterfazLogin() {
        setTitle("Inicio de Sesion");
        setSize(350, 200);
       
        setLocationRelativeTo(null); 

        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(64, 128, 128));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel loginPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        loginPanel.setBackground(new Color(64, 128, 128));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblNickname = new JLabel("Nickname:");
        lblNickname.setForeground(new Color(255, 255, 255));
        lblNickname.setFont(new Font("Tahoma", Font.BOLD, 15));
        tfNickname = new JTextField();
        tfNickname.setPreferredSize(new Dimension(150, 30));
        loginPanel.add(lblNickname);
        loginPanel.add(tfNickname);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        pfPassword = new JPasswordField();
        pfPassword.setPreferredSize(new Dimension(150, 30));
        loginPanel.add(lblPassword);
        loginPanel.add(pfPassword);

        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setPreferredSize(new Dimension(150, 40));
        btnLogin.setBackground(new Color(0, 0, 0));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nickname = tfNickname.getText();
                String contrasena = new String(pfPassword.getPassword());
            	ModeloLogin.iniciarSesion(nickname,contrasena);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(64, 128, 128));
        buttonPanel.add(btnLogin);

        mainPanel.add(loginPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    /**
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
    //Metodos para obtener el nickname y la contraseña ingresados por el usuario
    public String getNickname() {
        return tfNickname.getText();
    }

    /**
	 * Gets the password.
	 *
	 * @return the password
	 */
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    // Metodo para mostrar un mensaje en la interfaz gráfica
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
	 * Sets the login listener.
	 *
	 * @param listener the new login listener
	 */
    // Metodo para configurar el ActionListener para el botón de inicio de sesion
    public void setLoginListener(ActionListener listener) {
        this.loginListener = listener;
    }
}