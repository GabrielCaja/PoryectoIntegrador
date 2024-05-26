package Proyecto1;


import java.util.ArrayList;
import java.util.Arrays;

public class Recursos {

	private String nombre ;
	private String ubicacion;
	private String fecha; 
	private int codigoPostal;
	private boolean disponibilidad ;
	


	
	//Voy a hacer una lista de Recursos para poder probar cosas
	//Va a ser una lista de objetos 
	//lista de productos disponibles
	private ArrayList <Recursos> listaDisponibles = new ArrayList<>();
	
	//lista de produtos no disponibles
	private ArrayList <Recursos> listaNoDisponibles = new ArrayList<>();
	
	public Recursos() {}
	
	public Recursos(String nombre, String ubicacion, String fecha, int codigoPostal, boolean disponibilidad ) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.fecha=fecha;
		this.codigoPostal=codigoPostal;
		this.disponibilidad = disponibilidad;
	}
	/*Getter y Setters de los atributos de Recursos*/
	//Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	//Ubicacion
	public void setubicacion(String ubicacion) {
		this.ubicacion=ubicacion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	
	//Fecha
	public void setFecha(String fecha) {
		this.fecha=fecha;
	}
	public String getFecha() {
		return fecha;
	}
	
	//Codigo postal
	public void setCodigoPostal(int codigopostal) {
		this.codigoPostal = codigopostal;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	//Disponiblilidad
	public void setDisponibilidad(boolean disponiblilidad) {
		this.disponibilidad = disponiblilidad;
	}
	public boolean getDisponibilidad() {
		return disponibilidad;
	}
	
	//cambiarDiisponiblidad
	public void cambiarDisponibilidad(Recursos recursos) {
		if (recursos.disponibilidad == false) {
			recursos.setDisponibilidad(true); 
		}else if (recursos.disponibilidad == true) {
			recursos.setDisponibilidad(false);
		}
	}
	/**
	 * 
	 * @return toString devuelve una cadena de valores los cuales corresponden a un recurso 
	 */
	//toString 
	public String toString() {
		return ("Nombre : "+ nombre+ "\n Ubicaion: "+ubicacion+ "\n Fecha : "+fecha + "\n Codigo Postal : "+ codigoPostal+ "\n Disponibilidad: "+disponibilidad);
	}
	
	/**
	 * 
	 * @return listaDisponible es un listado de los recuresos que están disponibles para su uso
	 */
	
	//Hacer visible el arraylist
	public ArrayList<Recursos> getListaDisponibles() {
		return listaDisponibles;
	}

	/**
	 * 
	 * @return listaNoDisponible es un listado de los recuresos que ya no están disponibles para su uso
	 */
	public ArrayList<Recursos> getListaNoDisponibles() {
		return listaNoDisponibles;
	}
	
	//Al prestar enviamos un productode la lista de disponible a la de no disponible
	public void Alquilar(Recursos recurso) {
		añadirNo(recurso);
		eliminarDis(recurso);
	}
	//Al devolver es lo mismo que prestar pero a la inversa
	public void Devolver(Recursos recurso) {
		anadirDis(recurso);
		eliminarNo(recurso);
	}
	
	//Paraañadir un recurso para el Administrador 
	public void anadirDis(Recursos recursos) {
		listaDisponibles.add(recursos);

	}
	public void eliminarDis(Recursos recursos) {
		listaDisponibles.remove(recursos);

	}
	//Paraañadir un recurso para el Administrador 
	public void añadirNo(Recursos recursos) {
		listaNoDisponibles.add(recursos);

	}
	public void eliminarNo(Recursos recursos) {
		listaNoDisponibles.remove(recursos);

	}
	
	//Para obtener un objeto de lista de disponibles 
	public Recursos getRecursoDisponible(int id) {
		return listaDisponibles.get(id);
	}
	//Para obtener un objeto de lista de NO disponibles 
	public Recursos getRecursoNoDisponible(int id) {
		return listaNoDisponibles.get(id);
	}
	
	//Ver todos los recursos 
	public void verProductosDisponibles() {
		System.err.println("***Recursos Disponibles ***");
		for (int i = 0; i < listaDisponibles.size(); i++) {
			System.out.println("Opcion : " +(i+1)+"\n"+listaDisponibles.get(i).toString());
			System.out.println("");
		}
	}

	//Ver productos no disponibles
	public void verProductosNoDisponibles() {
		System.err.println("***Recursos Prestados ***");
		for (int i = 0; i < listaNoDisponibles.size(); i++) {
			System.out.println("Opcion : " +(i+1)+"\n"+listaNoDisponibles.get(i).toString());
			System.out.println("");
		}
	}
	
	/**
	 * 
	 * @param ubi seria la ubicacion que le entra al metodo 
	 */
	public void burcarUbi(String ubi) {
		for (int i = 0; i < listaDisponibles.size(); i++) {
			String a = listaDisponibles.get(i).getUbicacion();
			String u = ubi.toLowerCase();
			String b = a.toLowerCase();
			if (u.equals(b)) {
				System.out.println(listaDisponibles.get(i).toString());
			}
		}
	}

	
}

