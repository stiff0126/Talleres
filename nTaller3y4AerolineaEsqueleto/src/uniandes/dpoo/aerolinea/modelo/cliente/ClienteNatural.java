package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente{
	public String NATURAL= "Natural";
	public String nombre;
	
	public ClienteNatural(String nombre) {
		this.nombre=nombre;
	}

	public String getNATURAL() {
		return NATURAL;
	}

	public String getNombre() {
		return nombre;
	}
}
