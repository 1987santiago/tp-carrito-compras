package tallerweb.springmvc.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Carrito {

	private static Carrito instance = new Carrito();
	private List<String> compras = new LinkedList<String>();
	private Map<String, Integer> datosCompras = new TreeMap<String, Integer>();
	
	private Carrito(){}
	
	public static Carrito getInstance(){
		return instance;
	}
	
	/**
	 * Limpia el carrito.<br>
	 */
	public void vaciaCarrito(){
		this.compras.clear();
		this.datosCompras.clear();
	}
	
	/**
	 * Agrega un producto al carrito.<br>
	 * @param producto
	 */
	public void agregarProducto(String producto){
		if (!this.existeProducto(producto)) {
			this.compras.add(producto);
		}
	}
	
	/**
	 * Agrega cantidades a un producto del carrito.<br>
	 * @param producto
	 * @param cantidad
	 */
	public void agregarProductoConCantidad(String producto, Integer cantidad){
		if (!this.datosCompras.containsKey(producto)) {
		// Si el producto pasado por parametro no existe aœn lo agrega, junto con su cantidad
			this.datosCompras.put(producto, cantidad);
		} else {
		// Si el producto ya existe, modifico su stock
			// Obtenemos el stock actual y lo guardamos
			Integer productStock = this.datosCompras.get(producto);
			// eliminamos el producto del mapa
			this.datosCompras.remove(producto);
			// Incrementamos el stock segœn la cantidad pasada por parametro
			cantidad = cantidad + productStock;
			// Agergamos el nuevo producto con su stock actualizado
			this.datosCompras.put(producto, cantidad);
		}
	}
	
	/**
	 * Lista todas las compras realizadas.<br>
	 * @return
	 */
	public List<String> verCarrito(){
		return this.compras;
	}
	
	/**
	 * Lista todas las compras realizadas con sus cantidades.<br>
	 * @return Map
	 */
	public Map<String, Integer> verCarritoConCantidades(){
		return this.datosCompras;
	}
	
	/**
	 * Devuelve la cantidad de productos comprados.<br>
	 * @return
	 */
	public Integer cantidadCompras(){
		// Implementar
		return this.compras.size();
	}
	
	/**
	 * Remueve un producto del carrito.<br> 
	 */
	public void quitarProducto(String producto) {
		 this.compras.remove(producto);
		 this.datosCompras.remove(producto);
	}
	
	/**
	 * Busca un producto en la lista de compra
	 * @return boolean
	 */
	 public boolean existeProducto(String producto) {
		 return (this.compras.contains(producto));
	 }
	 	
}
