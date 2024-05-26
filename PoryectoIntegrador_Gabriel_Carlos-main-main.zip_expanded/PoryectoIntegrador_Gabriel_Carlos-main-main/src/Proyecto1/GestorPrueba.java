package Proyecto1;

import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestorPrueba {

	JFrame frame;
	private Button button_1;
	private JTable table;
	static GestorPrueba window = new GestorPrueba();
	private MenuAdministrador administrador = new MenuAdministrador();
	private MenuUsuario windowUsuario = new MenuUsuario();
	private GestorAlquiler alquiler = new GestorAlquiler();

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public GestorPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 277);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Principal");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(146, 10, 154, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Administrador");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				administrador.abrirVista();
				window.cerrarVista();
			}
		});
		btnNewButton.setBounds(128, 77, 172, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDevolver = new JButton("Usuario");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDevolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				windowUsuario.abrirVista();
				window.cerrarVista();
			}
		});
		btnDevolver.setBounds(128, 131, 172, 44);
		frame.getContentPane().add(btnDevolver);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.cerrarVista();
			}
		});
		btnNewButton_1.setBounds(10, 209, 85, 21);
		frame.getContentPane().add(btnNewButton_1);

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] { { " ", " " }, { " ", " " }, { " ", " " },
				{ " ", " " }, { " ", " " }, { " ", " " }, { " ", " " }, { " ", " " }, { " ", " " } },
				new String[] { null, null });

	}
	
	public void cerrarVista() {

		window.frame.setVisible(false);

	}

	public void abrirVista() {

		window.frame.setVisible(true);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public JTable getTable() {
		return getTable();
	}
}
