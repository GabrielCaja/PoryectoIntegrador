package Proyecto1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Panel;
import java.awt.Button;
import java.awt.ScrollPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Choice;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.TextField;
import java.awt.Scrollbar;
import java.awt.Font;

public class GestorAlquiler {

	private JFrame frame;
	private Button button_1;
	private JTable table;
	static GestorAlquiler window = new GestorAlquiler();
	static Alquilar windowAlquilar = new Alquilar();
	static Devolver windowDevolver = new Devolver();
	static GestorPrueba windowPrueba = new GestorPrueba();



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
	public GestorAlquiler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 277);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Alquileres");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(128, 10, 179, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Disponibles");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				windowAlquilar.abrirVista();
				window.cerrarVista();
			}
		});
		btnNewButton.setBounds(128, 77, 172, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDevolver = new JButton("No Disponibles");
		btnDevolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				windowDevolver.abrirVista();
				window.cerrarVista();
			}
		});
		btnDevolver.setBounds(128, 131, 172, 44);
		frame.getContentPane().add(btnDevolver);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.cerrarVista();
				windowPrueba.abrirVista();
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

