package tallerweb.springmvc.utils;

public class Producto {
	
	private String nombre;
	private Integer cantidad;
	
	public Producto(String nombre, Integer cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	

}
