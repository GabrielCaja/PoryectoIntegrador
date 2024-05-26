/*@author
 * Gabriel Caja
 */
package Proyecto1;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The Class InterfazRegistro.
 */
public class InterfazRegistro {

	/** The frame. */
	JFrame frame;
	
	/** The text field 6. */
	private JTextField txtRegistro,txtNickname,textField,txtNombre,textField_1,txtSuperPoder,textField_2,txtContrasea,textField_3,txtRepetirContrasea,textField_4,txtUbicacion,textField_5,txtNombreDeTu,textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public InterfazRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(64, 128, 128));
        frame.setBounds(100, 100, 550, 665);
        
        frame.getContentPane().setLayout(null);

        // Ruta de la imagen
        String imagePath = "C:\\Users\\Gabri\\Documents\\Utad\\Programacion\\Java\\integradorCarlos\\src\\ProyectoIntegrador\\imgs\\3534139.png";

        // Cargar la imagen en un ImageIcon
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Escalar la imagen
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(200, 150, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        // Crear un JLabel y establecer el ImageIcon escalado
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(InterfazRegistro.class.getResource("/imgs/registro.png")));
        lblNewLabel.setBounds(391, 9, 124, 119);
        frame.getContentPane().add(lblNewLabel);
        
        txtRegistro = new JTextField();
        txtRegistro.setEditable(false);
        txtRegistro.setForeground(new Color(255, 255, 255));
        txtRegistro.setBackground(new Color(64, 128, 128));
        txtRegistro.setHorizontalAlignment(SwingConstants.CENTER);
        txtRegistro.setText("REGISTRO");
        txtRegistro.setFont(new Font("Tahoma", Font.BOLD, 26));
        txtRegistro.setBounds(155, 37, 211, 66);
        frame.getContentPane().add(txtRegistro);
        txtRegistro.setColumns(10);
        
        txtNickname = new JTextField();
        txtNickname.setEditable(false);
        txtNickname.setForeground(new Color(255, 255, 255));
        txtNickname.setBackground(new Color(0, 128, 128));
        txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
        txtNickname.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtNickname.setText("Nickname:");
        txtNickname.setBounds(115, 164, 124, 19);
        frame.getContentPane().add(txtNickname);
        txtNickname.setColumns(10);
        
        textField = new JTextField();
        textField.setBounds(303, 164, 131, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        txtNombre = new JTextField();
        txtNombre.setText("Nombre:");
        txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
        txtNombre.setForeground(Color.WHITE);
        txtNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtNombre.setEditable(false);
        txtNombre.setColumns(10);
        txtNombre.setBackground(new Color(0, 128, 128));
        txtNombre.setBounds(115, 193, 124, 19);
        frame.getContentPane().add(txtNombre);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(303, 193, 131, 19);
        frame.getContentPane().add(textField_1);
        
        txtSuperPoder = new JTextField();
        txtSuperPoder.setText("Super Poder:");
        txtSuperPoder.setHorizontalAlignment(SwingConstants.CENTER);
        txtSuperPoder.setForeground(Color.WHITE);
        txtSuperPoder.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtSuperPoder.setEditable(false);
        txtSuperPoder.setColumns(10);
        txtSuperPoder.setBackground(new Color(0, 128, 128));
        txtSuperPoder.setBounds(115, 222, 124, 19);
        frame.getContentPane().add(txtSuperPoder);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(303, 222, 131, 19);
        frame.getContentPane().add(textField_2);
        
        txtContrasea = new JTextField();
        txtContrasea.setText("Contraseña:");
        txtContrasea.setHorizontalAlignment(SwingConstants.CENTER);
        txtContrasea.setForeground(Color.WHITE);
        txtContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtContrasea.setEditable(false);
        txtContrasea.setColumns(10);
        txtContrasea.setBackground(new Color(0, 128, 128));
        txtContrasea.setBounds(115, 251, 124, 19);
        frame.getContentPane().add(txtContrasea);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(303, 251, 131, 19);
        frame.getContentPane().add(textField_3);
        
        txtRepetirContrasea = new JTextField();
        txtRepetirContrasea.setText("Repetir contraseña:");
        txtRepetirContrasea.setHorizontalAlignment(SwingConstants.CENTER);
        txtRepetirContrasea.setForeground(Color.WHITE);
        txtRepetirContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtRepetirContrasea.setEditable(false);
        txtRepetirContrasea.setColumns(10);
        txtRepetirContrasea.setBackground(new Color(0, 128, 128));
        txtRepetirContrasea.setBounds(65, 280, 174, 19);
        frame.getContentPane().add(txtRepetirContrasea);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(303, 280, 131, 19);
        frame.getContentPane().add(textField_4);
        
        txtUbicacion = new JTextField();
        txtUbicacion.setText("Ubicacion:");
        txtUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
        txtUbicacion.setForeground(Color.WHITE);
        txtUbicacion.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtUbicacion.setEditable(false);
        txtUbicacion.setColumns(10);
        txtUbicacion.setBackground(new Color(0, 128, 128));
        txtUbicacion.setBounds(115, 309, 124, 19);
        frame.getContentPane().add(txtUbicacion);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(303, 309, 131, 19);
        frame.getContentPane().add(textField_5);
        
        JCheckBox chckbxEmpresa = new JCheckBox("Tu empresa lleva mas de 14 años luchando contra el crimen");
        chckbxEmpresa.setFont(new Font("Tahoma", Font.ITALIC, 11));
        chckbxEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
        chckbxEmpresa.setBounds(115, 478, 319, 21);
        frame.getContentPane().add(chckbxEmpresa);
        
        JCheckBox chckbxEresAdministrador = new JCheckBox("Eres administrador?");
        chckbxEresAdministrador.setHorizontalAlignment(SwingConstants.LEFT);
        chckbxEresAdministrador.setFont(new Font("Tahoma", Font.ITALIC, 11));
        chckbxEresAdministrador.setBounds(115, 511, 319, 21);
        frame.getContentPane().add(chckbxEresAdministrador);
        
        txtNombreDeTu = new JTextField();
        txtNombreDeTu.setText("Nombre de tu primera mascota?");
        txtNombreDeTu.setHorizontalAlignment(SwingConstants.CENTER);
        txtNombreDeTu.setForeground(Color.WHITE);
        txtNombreDeTu.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtNombreDeTu.setEditable(false);
        txtNombreDeTu.setColumns(10);
        txtNombreDeTu.setBackground(new Color(0, 128, 128));
        txtNombreDeTu.setBounds(137, 395, 262, 19);
        frame.getContentPane().add(txtNombreDeTu);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(204, 424, 131, 19);
        frame.getContentPane().add(textField_6);
        
        JButton btnNewButton = new JButton("Registrarse");
		//Funciones para el boton de registrar un usuario
        btnNewButton.addActionListener(new ActionListener() {
        	ModeloRegistro r = new ModeloRegistro();
            public void actionPerformed(ActionEvent e) {
            	String nickname = textField.getText();
            	String nombre = textField_1.getText();
            	String superPoder = textField_2.getText();
            	String contrasena = textField_3.getText();
            	String contrasena2 = textField_4.getText();
            	String ubicacion = textField_5.getText();
            	String preguntaSeguridad = "Nombre de tu primera mascota?";
            	String respuestaSeguridad = textField_6.getText();
            	boolean admin = chckbxEresAdministrador.isSelected();
            	boolean confirmacionCrimen = chckbxEmpresa.isSelected();
            	boolean aceptaTerminos = chckbxEmpresa.isSelected();

            	r.registrarCliente(nickname, nombre, superPoder, contrasena, contrasena2, ubicacion,
            			 preguntaSeguridad, respuestaSeguridad, confirmacionCrimen, aceptaTerminos, admin);
            }
        });
        btnNewButton.setToolTipText("");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setBounds(204, 562, 143, 21);
        frame.getContentPane().add(btnNewButton);
       
        JLabel lblNewLabel_1 = new JLabel("*Contraseñas deben tener al menos 6 ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
        lblNewLabel_1.setBounds(105, 338, 355, 19);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("caracteres, incluyendo mayúsculas, minúsculas y números");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
        lblNewLabel_1_1.setBounds(105, 354, 355, 19);
        frame.getContentPane().add(lblNewLabel_1_1);
        
		JButton btnVolver = new JButton("Volver");
		//Funciones para el boton volver atras
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
				
			}
		});
        btnVolver.setToolTipText("");
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnVolver.setBounds(10, 10, 79, 21);
        frame.getContentPane().add(btnVolver);
    }

	/**
	 * Sets the visible.
	 *
	 * @param b the new visible
	 */
	public void setVisible(boolean b) {
		
	}
}