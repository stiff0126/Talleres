package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private Collection<Tiquete> tiquetes;
	
	public Vuelo(String fecha,Ruta ruta, Avion avion) {
		this.avion=avion;
		this.fecha=fecha;
		this.ruta=ruta;
		this.tiquetes=new ArrayList<Tiquete>();
		
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

	public Collection<Tiquete> getTiquetes() {
		return tiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora,int cantidad ) {
		int i=0;
		int cantidadTotal=0;
		
		tiquetes=this.getTiquetes();
		while (i<=cantidad) {
			int tarifa=calculadora.calcularTarifa(this, cliente);
			Tiquete tiquete=GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
			//se añade tiquete al cliente
			cliente.agregarTiquete(tiquete);
			//se añade tiquete al vuelo
			this.getTiquetes().add(tiquete);
			cantidadTotal+=tarifa;
			i++;
		}
		
		return cantidadTotal;
	}
	
	public boolean equals(Object obj) {
		return true;
	}
	
	
	
}
