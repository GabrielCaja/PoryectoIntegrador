
package Proyecto1;

import java.util.ArrayList;

public class Valoraciones {

	private String nombre; 
	private int valoracion; 
	private String comentario;
	private ArrayList<Valoraciones> listaValoraciones = new ArrayList<>();

	public  Valoraciones(String nombre , int valoracion , String comentario) {
		this.nombre = nombre;
		this.valoracion = valoracion ;
		this.comentario = comentario;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setVal(int val) {
		this.valoracion = val;
	}
	public Integer getVal() {
		return valoracion;
	}
	public void setComment(String com) {
		this.comentario = com;
	}
	public String getComment() {
		return comentario;
	}
	
	public void setLista(ArrayList<Valoraciones> valoraciones) {
		listaValoraciones = valoraciones ;
	}
	public ArrayList<Valoraciones> getLista() {
		return listaValoraciones;
	}
	
}
