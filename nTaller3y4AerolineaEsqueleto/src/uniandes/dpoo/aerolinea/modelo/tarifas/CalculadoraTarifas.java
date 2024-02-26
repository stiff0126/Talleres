package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas {
	public double IMPUESTO= 0.28;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		return 1;
	} 
	
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		return 1;
	} 
	
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		return 1.0;
	} 
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		return 1;
	} 
	
	protected int calcularVlorImpuestos(int costoBase) {
		return 1;
	} 
}
