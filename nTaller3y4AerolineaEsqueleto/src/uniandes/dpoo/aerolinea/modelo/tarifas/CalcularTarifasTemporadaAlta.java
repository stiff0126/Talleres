package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalcularTarifasTemporadaAlta extends CalculadoraTarifas {
	 protected int COSTO_POR_KM=1000;
	 
	 public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		Ruta ruta = vuelo.getRuta();
			
		int distanciaKM=calcularDistanciaVuelo(ruta);
	
		int costoBase=COSTO_POR_KM*distanciaKM;
		
		return costoBase;
	}
	 
	public double calcularPorcentajeDescuento(Cliente cliente) {
		return 0;
	}
}
