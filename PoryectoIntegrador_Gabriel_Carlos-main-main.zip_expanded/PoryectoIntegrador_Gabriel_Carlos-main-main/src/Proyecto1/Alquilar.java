package Proyecto1;


import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.print.DocFlavor.READER;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.namespace.QName;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Alquilar extends Recursos{

	private JFrame frame;
	private Button button_1;
	private JTable table;
	static Alquilar window = new Alquilar();
	static Devolver devolver = new Devolver();


	private DefaultTableModel modelo;
	static Devolver windowDevolver = new Devolver();
	static	ProyectoIntegrador proyect = new ProyectoIntegrador();
	static 	GestorAlquiler gestor = new GestorAlquiler();
	static MenuAdministrador windowAdmin =new MenuAdministrador();
	// Gestor de los Recursos
	private Recursos recursos = new Recursos();
	private ArrayList<Recursos> listaDisponibles = new ArrayList<>();
	private JTextField textField;

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
	 * @wbp.parser.entryPoint
	 */
	public Alquilar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setBounds(100, 100, 470, 277);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alquiler");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblNewLabel.setBounds(166, 10, 104, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Alquilar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String fecha = textField.getText();
				
				
				/*for (int i = 0; i < listaDisponibles.size(); i++) {
					if (textField.getText().equalsIgnoreCase(listaDisponibles.get(i).getNombre())) {
						listaDisponibles.get(i).setFecha(textField.getText());
						alquilar(listaDisponibles.get(i));
						
					}
				}*/
				
				cerrarVista();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(127, 119, 166, 39);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setEnabled(false);

		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.cerrarVista();
				windowAdmin.abrirVista();
			}
		});
		btnNewButton_1.setBounds(10, 197, 85, 21);
		frame.getContentPane().add(btnNewButton_1);

		
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Ubicacion", "Fecha", "codigoPostal", "disponibilidad" });
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String aux = textField.getText();
				if (aux.equals("1")|| aux.equals("2")||aux.equals("3")||aux.equals("0")) {
					btnNewButton.setEnabled(true);
				}
			}
		});
		textField.setBounds(154, 84, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setBounds(155, 67, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
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
		inicializarDatos();

	}
	
	public void inicializarDatos() {		
		// Innicializar datos metodo
		Object[] obj = new Object[5];
		listaDisponibles = recursos.getListaDisponibles();

		for (int i = 0; i < listaDisponibles.size(); i++) {

			obj[0] = listaDisponibles.get(i).getNombre();
			obj[1] = listaDisponibles.get(i).getUbicacion();
			obj[2] = listaDisponibles.get(i).getFecha();
			obj[3] = listaDisponibles.get(i).getCodigoPostal();
			obj[4] = listaDisponibles.get(i).getDisponibilidad();

			modelo.addRow(obj);

		}
	}
	

	public void alquilar(Recursos recursos) {
		devolver.anadirlista(recursos);
		eliminarlista(recursos);
	}
	public void eliminarlista(Recursos recurso) {
		listaDisponibles.remove(recurso);
	}
	

	public void anadirlista(Recursos recurso) {
		listaDisponibles.add(recurso);
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
