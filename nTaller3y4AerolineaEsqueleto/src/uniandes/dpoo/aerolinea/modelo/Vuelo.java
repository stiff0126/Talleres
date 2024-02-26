package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public class Vuelo {
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	
	private Collection<Tiquetes> tiquetes;
	
	public Vuelo(String fecha,Ruta ruta, Avion avion) {
		this.avion=avion;
		this.fecha=fecha;
		this.ruta=ruta;
		
	}

	public String getFecha() {
		return fecha;
	}

	public Avion getAvion() {
		return avion;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public Collection<Tiquetes> getTiquetes() {
		return tiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora,int cantidad ) {
		
	}
	
	public boolean equals(Object obj) {
		
	}
	
	
	
}
