package Proyecto1;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class UbicacionesPrivadas {
	
	
	//Lista de ubicaciones privadas 
	
	private ArrayList <String> listaUbicaciones = new ArrayList<>();	
	private String ubicacion;
	
	public UbicacionesPrivadas() {
		
	}


	public void setUbiucacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public String getUbiucacion() {
		return ubicacion;
	}
	
	public void anadirUbicacion(String ubi) {
		listaUbicaciones.add(ubi);
	}
	
	public void verUbicaciones() {
		System.out.println("***UBICACIONES PRIVADAS ****");
		for (int i = 0; i < listaUbicaciones.size(); i++) {
			System.out.println(listaUbicaciones.get(i));
		}
		
	}


	public ArrayList<String> getLista() {
		return listaUbicaciones;
	}
	
}
