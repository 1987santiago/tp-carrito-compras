package tallerweb.springmvc.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Maneja un stock de productos, el producto es un String que lo identifica y el mismo puede ser asociado a una cantidad.<br>
 * No persiste, es decir, luego de la ejecucion del programa el Stock se inicialza vacio.<br>
 * @author sismael
 *
 */
public class Stock {
	
	private static Stock instance = new Stock();
	private Map<String, Integer> stock = new HashMap<String, Integer>();
	
	private Stock(){}

	public static Stock getInstance(){
		return instance;
	}
	
	/**
	 * Devuelve un listado de los producto del stock, tengan o no stock,<br> 
	 * es decir, los productos con cantidad 0 son incluidos.<br>
	 * @param producto
	 * @param cantidad
	 * @return 
	 */
	public Set<String> listarProductosDisponibles(){
		return stock.keySet();
	}
	
	/**
	 * Devuelve un mapa con los productos y su stock correspondiente,<br> 
	 * tengan o no stock, es decir, los productos con cantidad 0 son incluidos.<br>
	 * @param producto
	 * @param cantidad
	 * @return 
	 */
	public Map<String, Integer> obtenerStock(){
		return stock;
	}
	
	/**
	 * Permite agregar el producto indicado al stock, con cantidad 0.<br>
	 * @param producto
	 * @param cantidad
	 * @return true en caso de exito, false si el producto ya existe en el stock.<br>
	 */
	public Boolean agregarProducto(String producto){
		if(this.stock.containsKey(producto)){
			return false;
		}
		this.stock.put(producto, 0);
		return true;
	}
	
	/**
	 * Permite agregar stock para un producto dado. <br> 
	 * Si el producto tiene un stock de N, ahora tendra N + cantidad.<br>
	 * @param producto
	 * @param cantidad
	 * @return true en caso de exito, false si el producto no existe en el stock.<br>
	 */
	public Boolean agregarStock(String producto, Integer cantidad){
		if(!this.stock.containsKey(producto)){
			return false;
		}
		Integer nuevaCantidad = this.stock.get(producto) + cantidad;
		this.stock.put(producto, nuevaCantidad);
		return true;
	}
	
	/**
	 * Devuelve el stock disponible para el producto pedido. NULL si el producto no existe en el stock<br>
	 * @param producto
	 * @return
	 */
	public Integer obtenerStockDisponible(String producto){
		if(!this.stock.containsKey(producto)){
			return null;
		}
		return this.stock.get(producto);
	}
	
	/**
	 * Indica si el producto indicado fue incluido en el stock.<br>
	 * @param producto
	 * @return
	 */
	public Boolean existeProducto(String producto){
		return this.stock.containsKey(producto);
	}
	
	/**
	 * Permite comprar N unidades del producto indicado.<br>
	 * @param producto
	 * @param unidades
	 * @return true en caso de exito, false si el producto no existe en el stock.<br>
	 */
	public Boolean comprarProducto(String producto, Integer unidades){
		if(!this.stock.containsKey(producto)){
			return false;
		}
		Integer nuevaCantidad = this.stock.get(producto) - unidades;
		this.stock.put(producto, nuevaCantidad);
		return true;
	}
	
	/**
	 * Elimina el producto indicado del stock, no importa cual sea la cantidad disponible del mismo.<br>
	 * @param producto
	 * @return true en caso de exito, false si el producto no existe en el stock.<br>
	 */
	public Boolean eliminarProducto(String producto){
		if(!this.stock.containsKey(producto)){
			return false;
		}
		this.stock.remove(producto);
		return true;
	}
}