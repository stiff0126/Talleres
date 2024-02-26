package uniandes.dpoo.aerolinea.modelo.tarifas;

public class CalcularTarifasTemporadaAlta extends CalculadoraTarifas {
	 protected int COSTO_POR_KM=1000;
	 
	 public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		return 1;
	}
	 
	public double calcularPorcentajeDescuento(Cliente cliente) {
		return 1;
	}
}
