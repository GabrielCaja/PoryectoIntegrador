package Proyecto1;


import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.net.ssl.CertPathTrustManagerParameters;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import java.awt.Color;

public class Devolver extends Recursos{

	private JFrame frame;
	private Button button_1;
	private JTable table;
	static Devolver window = new Devolver();
	static Alquilar alquilar = new Alquilar();
	static Valoraciones valoraciones = new Valoraciones(null, 0, null);
	private DefaultTableModel modelo;
	// Gestor de los Recursos
	private Recursos recursos = new Recursos();
	private ArrayList<Valoraciones> listaValor = new ArrayList<>();

	private ArrayList<Recursos> listaNoDisponibles = new ArrayList<>();
	
	static GestorAlquiler gestorAlquiler = new GestorAlquiler();
	static MenuAdministrador windowAdmin = new MenuAdministrador();
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
	public Devolver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 128, 128));
		frame.setBounds(100, 100, 470, 277);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Devolver");
		lblNewLabel.setBackground(new Color(71, 115, 120));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblNewLabel.setBounds(167, 0, 104, 44);
		frame.getContentPane().add(lblNewLabel);
		
		
		
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
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Comentario");
		lblNewLabel_1.setBounds(91, 91, 180, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valoracion (1-5)");
		lblNewLabel_1_1.setBounds(75, 39, 180, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		

		JSlider slider = new JSlider();
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		slider.setBounds(102, 57, 200, 26);
		frame.getContentPane().add(slider);
		
		JButton btnNewButton = new JButton("Devolver");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int val = 0 ;
				String coment = textField.getText();
				val= slider.getValue()/20;
				if (val > 5 ) {
					val = 5;
				}
				Valoraciones valor = new Valoraciones(windowAdmin.getRecurso().getNombre(), val, coment);
				listaValor.add(valor);
				cerrarVista();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if (slider.getValue()> -1) {
					btnNewButton.setEnabled(true);
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(127, 188, 166, 39);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				
			}
		});
		textField.setColumns(10);
		textField.setBounds(90, 110, 244, 65);
		frame.getContentPane().add(textField);
		

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Ubicacion", "Fecha", "codigoPostal", "disponibilidad" });


	}
	
	public void inicializarDatos() {
		// Innicializar datos metodo
		Object[] obj = new Object[5];
		listaNoDisponibles = recursos.getListaNoDisponibles();
		// Vaciamos la tabla

		for (int i = 0; i < listaNoDisponibles.size(); i++) {

			obj[0] = listaNoDisponibles.get(i).getNombre();
			obj[1] = listaNoDisponibles.get(i).getUbicacion();
			obj[2] = listaNoDisponibles.get(i).getFecha();
			obj[3] = listaNoDisponibles.get(i).getCodigoPostal();
			obj[4] = listaNoDisponibles.get(i).getDisponibilidad();

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
	
	public void devolver(Recursos recurso) {
		alquilar.anadirlista(recursos);
		eliminarlista(recursos);
	}
	public void eliminarlista(Recursos recurso) {
		listaNoDisponibles.remove(recurso);
	}

	public void anadirlista(Recursos recurso) {
		listaNoDisponibles.add(recurso);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public JTable getTable() {
		return getTable();
	}
}
