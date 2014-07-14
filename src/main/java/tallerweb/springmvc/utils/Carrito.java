package tallerweb.springmvc.utils;

import java.util.HashMap;
import java.util.Map;

public class Carrito {

	private static Carrito instance = new Carrito();
	private Map<String, Integer> unidades = new HashMap<String, Integer>();
	
	private Carrito(){}
	
	public static Carrito getInstance(){
		return instance;
	}
	
	/**
	 * Limpia el carrito.<br>
	 */
	public void vaciarCarrito(){
		throw new RuntimeException("Implementar");
	}
	
	/**
	 * Agrega un producto al carrito.<br>
	 * @param producto
	 * @param cantidad
	 */
	public void agregarProducto(String producto, Integer cantidad){
		throw new RuntimeException("Implementar");
	}
	
	/**
	 * Lista todas las compras realizadas.<br>
	 * @return Map
	 */
	public Map<String, Integer> verCarrito(){
		throw new RuntimeException("Implementar");
	}
	
	/**
	 * Devuelve la cantidad de productos comprados.<br>
	 * @return Integer
	 */
	public Integer cantidadCompras(){
		throw new RuntimeException("Implementar");
	}
}