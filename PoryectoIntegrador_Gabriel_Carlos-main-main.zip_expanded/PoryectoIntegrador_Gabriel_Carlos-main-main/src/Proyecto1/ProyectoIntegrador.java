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
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;
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
import java.awt.Window;
import java.awt.Scrollbar;
import java.awt.Font;
import javax.swing.JScrollPane;

public class ProyectoIntegrador {

	private JFrame frame;
	private Button button_1;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel modelo;
	// Gestor de los Recursos
	private Recursos recursos = new Recursos();
	private Devolver devolver = new Devolver();
	private ArrayList<Recursos> listaDisponibles = new ArrayList<>();
	// Creamos la lista de no disponibles
	private ArrayList<Recursos> listaNoDisponibles = new ArrayList<>();

	static ProyectoIntegrador window = new ProyectoIntegrador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProyectoIntegrador() {
		initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Menu Recursos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(139, 10, 146, 35);
		frame.getContentPane().add(lblNewLabel);

		// añadismos la lista de recursos a la lista local
		listaDisponibles = recursos.getListaDisponibles();
		listaNoDisponibles = recursos.getListaNoDisponibles();

		// Creamos la lista de diasponibles

		System.out.println(listaDisponibles);

		// listaDisponibles.get(0).getNombre()
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Ubicacion", "Fecha", "codigoPostal", "disponibilidad" });

		// Recursos
		Recursos batmovil = new Recursos("Batmovil", "Gotam", "27/02/1924", 67425, false);
		Recursos batCinturon = new Recursos("Bat Cinturon", "Gotam", "27/02/1924", 67425, false);
		Recursos bastonAbuela = new Recursos("Baston de la abuela", "NYC", "19/04/1965", 38402, false);
		Recursos chancla = new Recursos("Chancla", "Bogota", "18/12/1999", 33202, false);
		Recursos capaSuperman = new Recursos("Capa de Superman", "LongVille", "12/02/1979", 49310, false);
		Recursos raton = new Recursos("Lab Rat (Eduardo)", "EEUU", "10/01/1889", 37921, false);

		recursos.anadirDis(batmovil);
		recursos.anadirDis(batCinturon);
		recursos.anadirDis(bastonAbuela);
		recursos.anadirDis(chancla);
		recursos.anadirDis(capaSuperman);
		recursos.anadirDis(raton);
		// Innicializar datos metodo
		Object[] obj = new Object[5];

		// inicializamos datos en la tabla
		inicializarDatos();

		JButton btnNewButton = new JButton("Recursos No Disponibles");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarNoDisponibles();
			}
		});
		btnNewButton.setBounds(141, 351, 144, 21);
		frame.getContentPane().add(btnNewButton);

		// Volver
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrarVista();
				devolver.abrirVista();
			}
		});
		btnNewButton_1.setBounds(176, 382, 80, 21);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Recursos Disponibles");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				mostrarDisponibles();

			}
		});
		btnNewButton_1_1.setBounds(139, 318, 146, 21);
		frame.getContentPane().add(btnNewButton_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 80, 344, 208);
		frame.getContentPane().add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		table_1.setModel(modelo);

	}

	// mostrar los recursos
	public void mostrarDisponibles() {
		// Innicializar datos metodo
		Object[] obj = new Object[5];

		// Vaciamos la tabla
		vaciarTabla(table_1);

		for (int i = 0; i < listaDisponibles.size(); i++) {

			obj[0] = listaDisponibles.get(i).getNombre();
			obj[1] = listaDisponibles.get(i).getUbicacion();
			obj[2] = listaDisponibles.get(i).getFecha();
			obj[3] = listaDisponibles.get(i).getCodigoPostal();
			obj[4] = listaDisponibles.get(i).getDisponibilidad();

			modelo.addRow(obj);

		}
	}

	public void mostrarNoDisponibles() {
		// Innicializar datos metodo
		Object[] obj = new Object[5];

		// Vaciamos la tabla
		vaciarTabla(table_1);

		for (int i = 0; i < listaNoDisponibles.size(); i++) {

			obj[0] = listaNoDisponibles.get(i).getNombre();
			obj[1] = listaNoDisponibles.get(i).getUbicacion();
			obj[2] = listaNoDisponibles.get(i).getFecha();
			obj[3] = listaNoDisponibles.get(i).getCodigoPostal();
			obj[4] = listaNoDisponibles.get(i).getDisponibilidad();

			modelo.addRow(obj);

		}
	}

	public void inicializarDatos() {

		Object[] obj = new Object[5];

		for (int i = 0; i < listaDisponibles.size(); i++) {

			obj[0] = "";
			obj[1] = "";
			obj[2] = "";
			obj[3] = "";
			obj[4] = "";

			modelo.addRow(obj);

		}
	}

	public void vaciarTabla(JTable table) {
		DefaultTableModel tabla = (DefaultTableModel) table.getModel();
		int filas = table.getRowCount();

		for (int i = 0; filas > i; i++) {
			tabla.removeRow(0);
		}
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
