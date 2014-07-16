package tallerweb.springmvc.utils;

import java.util.LinkedList;
import java.util.List;

public class Carrito {

	private static Carrito instance = new Carrito();
	private List<String> compras = new LinkedList<String>();
	
	private Carrito(){}
	
	public static Carrito getInstance(){
		return instance;
	}
	
	/**
	 * Limpia el carrito.<br>
	 */
	public void vaciaCarrito(){
		// Implementar
	}
	
	/**
	 * Agrega un producto al carrito.<br>
	 * @param producto
	 */
	public void agregarProducto(String producto){
		// Implementar
	}
	
	/**
	 * Lista todas las compras realizadas.<br>
	 * @return
	 */
	public List<String> verCarrito(){
		// Implementar
		return null;
	}
	
	/**
	 * Devuelve la cantidad de productos comprados.<br>
	 * @return
	 */
	public Integer cantidadCompras(){
		// Implementar
		return null;
	}
}
