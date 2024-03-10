package uniandes.dpoo.aerolinea.modelo.tarifas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	public double IMPUESTO= 0.28;
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		
		int costoBase=calcularCostoBase(vuelo, cliente);
		
		double costoConDescuento=costoBase-(calcularPorcentajeDescuento(cliente)*costoBase);
		
		int Impuesto=calcularValorImpuestos(costoBase);
		
		return (int)costoConDescuento+Impuesto;
	} 
	
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		    int costoBase;
	        
	        String fecha=vuelo.getFecha();
	        
	        //fecha a Date
	        LocalDate fechaEnDate = LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
	        
	        int mesInicioTemporadaAlta = 5; // mayo
	        int mesFinTemporadaAlta = 8;    // agosto

	       
	        int mesFecha = fechaEnDate.getMonthValue();

	        //se verifica si es temporada alta
	        boolean esTemporadaAlta=(mesFecha >= mesInicioTemporadaAlta && mesFecha <= mesFinTemporadaAlta) || mesFecha==12;
	        
	        
	        if (esTemporadaAlta) {
	        	CalcularTarifasTemporadaAlta calculadora=new CalcularTarifasTemporadaAlta();
	        	costoBase=calculadora.calcularCostoBase(vuelo,cliente);
	        }else {
	        	CalculadoraTarifasTemporadaBaja calculadora=new CalculadoraTarifasTemporadaBaja();
	        	costoBase=calculadora.calcularCostoBase(vuelo, cliente);
	        }
	        
	        return costoBase;
	    }
	        
	        
	        		
	        
	
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		double descuento=0;
		if (cliente.getTipoCliente()=="Corporativo") {
			CalcularTarifasTemporadaAlta calculadora=new CalcularTarifasTemporadaAlta();
        	descuento=calculadora.calcularPorcentajeDescuento(cliente);
		}else {
			CalculadoraTarifasTemporadaBaja calculadora=new CalculadoraTarifasTemporadaBaja();
        	descuento=calculadora.calcularPorcentajeDescuento(cliente);

		}
		return descuento;
	} 
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		
        int distanciaKM=Aeropuerto.calcularDistancia(origen,destino );
        
        return distanciaKM;
	} 
	
	protected int calcularValorImpuestos(int costoBase) {
		double valorImpuestos=(costoBase*IMPUESTO);
		return (int)valorImpuestos;
	} 
}
