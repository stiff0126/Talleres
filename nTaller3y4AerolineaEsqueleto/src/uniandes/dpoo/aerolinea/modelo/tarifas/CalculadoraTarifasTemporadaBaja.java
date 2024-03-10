package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	protected int COSTO_POR_KM_NATURAL=600;
	protected int COSTO_POR_KM_CORPORATIVO=900;
	protected double DESCUENTO_PEQ=0.02;
	protected double DESCUENTO_MEDIANAS=0.1;
	protected double DESCUENTO_GRANDES=0.2;
	
	
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		int costoBase=0;
		Ruta ruta = vuelo.getRuta();
		int distanciaKM=calcularDistanciaVuelo(ruta);
		
		if (cliente.getTipoCliente()=="Corporativo") {
			costoBase=COSTO_POR_KM_CORPORATIVO*distanciaKM;
		}else {
			costoBase=COSTO_POR_KM_NATURAL*distanciaKM;
		}
		return costoBase;
	}
	 
	public double calcularPorcentajeDescuento(Cliente cliente) {
		double descuento=0;
		
		if (cliente instanceof ClienteCorporativo) {
			ClienteCorporativo clienteEmpresa=(ClienteCorporativo) cliente;
			
			
			if(clienteEmpresa.getTamanoEmpresa()== clienteEmpresa.GRANDE) {
				descuento=DESCUENTO_GRANDES;
			}else if(clienteEmpresa.getTamanoEmpresa()== clienteEmpresa.MEDIANA){
				descuento=DESCUENTO_MEDIANAS;
			}else {
				descuento=DESCUENTO_PEQ;
			}
		}
		return descuento;
	}
}

