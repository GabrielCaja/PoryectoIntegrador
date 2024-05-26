/*@author
 * Gabriel Caja
 */
package Proyecto1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The Class MenuPrincipalRecursos.
 */
public class MenuPrincipalRecursos extends JFrame {
    
    /** The btn registrarse. */
    private JButton btnRegistrarse;
    
    /** The btn login. */
    private JButton btnLogin;
    
    /** The btn invitado. */
    private JButton btnInvitado;
    
    /** The btn recuperar contrasena. */
    private JButton btnRecuperarContrasena;
    
    /** The btn salir. */
    private JButton btnSalir;
    
    /** The vista. */
    VistaInicial vista = new VistaInicial();
    
    /**
	 * Instantiates a new menu principal recursos.
	 */
    public MenuPrincipalRecursos() {
        setTitle("Super Recursos");
        setSize(543, 686);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(64, 128, 128));
        panel_1.setBounds(0, 46, 527, 601);
        panel.add(panel_1);
        panel_1.setLayout(null);
        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBounds(175, 310, 176, 30);
        panel_1.add(btnRegistrarse);
        btnLogin = new JButton("Login");
        btnLogin.setBounds(175, 351, 176, 30);
        panel_1.add(btnLogin);
        btnInvitado = new JButton("Acceder como Invitado");
        btnInvitado.setBounds(175, 392, 176, 30);
        panel_1.add(btnInvitado);
        btnRecuperarContrasena = new JButton("Recuperar Contraseña");
        btnRecuperarContrasena.setBounds(175, 433, 176, 30);
        panel_1.add(btnRecuperarContrasena);
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(201, 509, 128, 40);
        panel_1.add(btnSalir);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(MenuPrincipalRecursos.class.getResource("/imgs/menu.png")));
        lblNewLabel.setBounds(30, 0, 466, 283);
        panel_1.add(lblNewLabel);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(64, 128, 128));
        panel_2.setBounds(0, 0, 527, 46);
        panel.add(panel_2);
        
                //ActionListener para el boton "Salir"
                btnSalir.addActionListener(new ActionListener() {
                    
                    /**
					 * Action performed.
					 *
					 * @param e the e
					 */
                    public void actionPerformed(ActionEvent e) {
                        int option = JOptionPane.showConfirmDialog(MenuPrincipalRecursos.this, "¿Estás seguro que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                    }
                });
        
                //ActionListener para el boton "Recuperar Contraseña"
                btnRecuperarContrasena.addActionListener(new ActionListener() {
                    
                    /**
					 * Action performed.
					 *
					 * @param e the e
					 */
                    public void actionPerformed(ActionEvent e) {
                    	InterfazCambiarPass cambiarP = new InterfazCambiarPass();
                    	cambiarP.setVisible(true);	
                    }
                });
        
                //ActionListener para el boton "Acceder como Invitado"
                btnInvitado.addActionListener(new ActionListener() {
                    
                    /**
					 * Action performed.
					 *
					 * @param e the e
					 */
                    public void actionPerformed(ActionEvent e) {
                        vista = new VistaInicial();
                        MenuUsuario windowUsuario = new MenuUsuario();
                        windowUsuario.abrirVista();
                        //vista.frame.setVisible(true);
                       

                    }
                });
                //ActionListener para el boton "Login"
                btnLogin.addActionListener(new ActionListener() {
                    
                    /**
					 * Action performed.
					 *
					 * @param e the e
					 */
                    public void actionPerformed(ActionEvent e) {
                    	ModeloRegistro r = new ModeloRegistro();
                        InterfazLogin vistaLogin = new InterfazLogin();
                        ModeloLogin modeloLogin = new ModeloLogin();
                        
                        vistaLogin.setVisible(true);
                        
                    }
                });
        
                //ActionListener para el boton "Registrarse"
                btnRegistrarse.addActionListener(new ActionListener() {
                    
                    /**
					 * Action performed.
					 *
					 * @param e the e
					 */
                    public void actionPerformed(ActionEvent e) {
                    	InterfazRegistro window = new InterfazRegistro();
    					window.frame.setVisible(true);
                    }
                });
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalRecursos();
            }
        });
    }
}
