package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	List<Tiquete> tiquetesSinUsar;
	List<Tiquete> tiquetesUsados;
	
	public Cliente() {
		this.tiquetesSinUsar= new ArrayList<Tiquete>();
		this.tiquetesUsados=new ArrayList<Tiquete>();
	}
	
	public abstract String getTipoCliente();
	
	public abstract String getIdentificador();
	
	
	public void agregarTiquete(Tiquete tiquete) {
		this.tiquetesSinUsar.add(tiquete); 
	}
	
	public int calcularValorTotalTiquetes() {
		int total=0;
		for (Tiquete tiquete : tiquetesSinUsar) {
			total+=tiquete.getTarifa();
		}
		return total;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		for (Tiquete tiquete : this.tiquetesSinUsar) {
			for (Tiquete tiquete2 : vuelo.getTiquetes()) {
				if (tiquete==tiquete2) {
					tiquete.marcarComoUsado();
					this.tiquetesSinUsar.remove(tiquete);
					this.tiquetesUsados.add(tiquete);
				}
			}
		}
	}
}
