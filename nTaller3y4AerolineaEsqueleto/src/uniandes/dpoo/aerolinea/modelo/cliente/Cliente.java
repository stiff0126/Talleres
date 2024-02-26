package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.modelo.Vuelo;

public abstract class Cliente {
	
	public Cliente() {
		
	}
	
	public String getTipoCliente() {
		return "";
	}
	
	public String getIdentificador() {
		return "";
	}
	
	
	public void agregarTiquete() {
		
	}
	
	public int calcularValorTotalTiquetes() {
		return 1 ;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		
	}
}
