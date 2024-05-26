package modelos;


import java.util.ArrayList;
import java.util.Arrays;

public class Recursos {

	private int id, idEmpresa, idLocalizacion;
	private String nombre ;
	private String fecha; 
	private int codigoPostal;
	private String estadisticas;
	private boolean disponibilidad ;
	

	
	//Voy a hacer una lista de Recursos para poder probar cosas
	//Va a ser una lista de objetos 
	//lista de productos disponibles
	private ArrayList <Recursos> listaDisponibles = new ArrayList<>();
	
	//lista de produtos no disponibles
	private ArrayList <Recursos> listaNoDisponibles = new ArrayList<>();
	
	
	public Recursos() {}
	
	public Recursos(int id,String nombre, String estadisticas, String fecha, int codigoPostal,int idEmpresa, int idLocalizacion, boolean disponibilidad ) {
		this.id=id;
		this.nombre = nombre;
		this.fecha=fecha;
		this.estadisticas=estadisticas;
		this.codigoPostal=codigoPostal;
		this.idEmpresa=idEmpresa;
		this.idLocalizacion=idLocalizacion;
		this.disponibilidad = disponibilidad;
	}
	

	
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdLocalizacion() {
		return idLocalizacion;
	}

	public void setIdLocalizacion(int idLocalizacion) {
		this.idLocalizacion = idLocalizacion;
	}

	public String getEstadisticas() {
		return estadisticas;
	}

	

	public void setEstadisticas(String estadisticas) {
		this.estadisticas = estadisticas;
	}

	/*Getter y Setters de los atributos de Recursos*/
	//Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public void setListaDisponibles(ArrayList<Recursos> listaDisponibles) {
		this.listaDisponibles = listaDisponibles;
	}

	public void setListaNoDisponibles(ArrayList<Recursos> listaNoDisponibles) {
		this.listaNoDisponibles = listaNoDisponibles;
	}

	/**
	 * 
	 * @return toString devuelve una cadena de valores los cuales corresponden a un recurso 
	 */
	//toString 
	@Override
	public String toString() {
		return "Recursos [id=" + id + ", idEmpresa=" + idEmpresa + ", idLocalizacion=" + idLocalizacion + ", nombre="
				+ nombre + ", fecha=" + fecha + ", codigoPostal=" + codigoPostal + ", estadisticas=" + estadisticas
				+ ", disponibilidad=" + disponibilidad + ", listaDisponibles=" + listaDisponibles
				+ ", listaNoDisponibles=" + listaNoDisponibles + "]";
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
	/*public void burcarUbi(String ubi) {
		for (int i = 0; i < listaDisponibles.size(); i++) {
			String a = listaDisponibles.get(i).getUbicacion();
			String u = ubi.toLowerCase();
			String b = a.toLowerCase();
			if (u.equals(b)) {
				System.out.println(listaDisponibles.get(i).toString());
			}
		}
	}*/

	
}

