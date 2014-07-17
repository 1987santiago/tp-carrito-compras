package tallerweb.springmvc.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Carrito;
import tallerweb.springmvc.utils.Producto;
import tallerweb.springmvc.utils.Stock;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	/**
	 * Este metodo se encarga de listar los productos del carrito de compras.
	 * @return ModelAndView 
	 */
	@RequestMapping("/listar")
	public ModelAndView listarProductos() {
		
		Carrito carrito = Carrito.getInstance();
		
		Map<String, Integer> mapCompras = carrito.verCarritoConCantidades();
		Set<String> setCompras = mapCompras.keySet();
		List<Producto> productList = new ArrayList<Producto>(); 
		
		for (Iterator<String> iterator = setCompras.iterator(); iterator.hasNext();) {
			String nombre = iterator.next();
			Integer cantidad = mapCompras.get(nombre);

			Producto otroProducto = new Producto(nombre, cantidad);
			productList.add(otroProducto);
		}
		
		ModelMap model = new ModelMap();
		
		model.put("productos", productList);
		
		return new ModelAndView("carrito", model);
		
	}
	
	/**
	 * Este metodo se encarga de vaciar el carrito de compras.<br>
	 * Al vaciar el carrito de compras se debe sumar esos productos al Stock 
	 * @return ModelAndView
	 */
	@RequestMapping("/vaciar")
	public ModelAndView vaciarCarrito() {
		
		Carrito carrito = Carrito.getInstance();
		Stock stock = Stock.getInstance();
		
		// Obtenemos la los productos y cantidades del carrito de compras (Mapa)
		Map<String, Integer> productosCarrito = carrito.verCarritoConCantidades();
		
		// A partir del mapa generamos un Set con las keys (nombre de productos)
		Set<String> keys = productosCarrito.keySet();
		
		// Iteramos esa coleccion
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
		
			String producto = iterator.next();
			
			// Con la key buscamos el valor correspondiente en el Mapa
			Integer cantidad = productosCarrito.get(producto);
			
			// Volvemos a agregar esos productos y cantidades al Stock
			stock.agregarStock(producto, cantidad);
		
		}
		
		// Vaciamos el carrito
		carrito.vaciaCarrito();
		
		List<String> listaProductos = carrito.verCarrito();
		Map<String, Integer> listaProductosCantidades = carrito.verCarritoConCantidades();
		
		ModelMap model = new ModelMap();
		model.put("productos", listaProductos);
		model.put("productosConCantidades", listaProductosCantidades);
		
		return new ModelAndView("carrito", model);
		
	}

	/**
	 * Remueve del carrito el producto pasado por parametro
	 * @param String producto 
	 * @return ModelAndView
	 */
	@RequestMapping("/remover/{producto}")
	public ModelAndView removeProduct(@PathVariable String producto) {
		
		Carrito carrito = Carrito.getInstance();
		Stock stock = Stock.getInstance();
		
		// Obtenemos la los productos y cantidades del carrito de compras (Mapa)
		Map<String, Integer> mapCompras = carrito.verCarritoConCantidades();
		// Convertimos ese mapa a un conjunto para poder iterarlo y obtener sus datos por separado
		Set<String> setCompras = mapCompras.keySet();
		// Generamos una lista para guardar los productos que vamos a enviar a la vista
		List<Producto> productList = new ArrayList<Producto>(); 
		
		// Generamos una mapa que contendr‡ los productos eliminados
		Map<String, Integer> removedMap = new TreeMap<String, Integer>();
		
		for (Iterator<String> iterator = setCompras.iterator(); iterator.hasNext();) {
			
			String nombre = iterator.next();
			Integer cantidad = mapCompras.get(nombre);
			
			Producto otroProducto = new Producto(nombre, cantidad);
			
			if (nombre.contentEquals(producto)) {
				stock.agregarStock(otroProducto.getNombre(), otroProducto.getCantidad());
				removedMap.put(nombre, cantidad);
			} else {				
				productList.add(otroProducto);
			}
			
		}

		// Quitamos del carrito los productos eliminados
		for (Iterator<String> iterator = removedMap.keySet().iterator(); iterator.hasNext();) {
			String nombre = iterator.next();
			carrito.quitarProducto(nombre);
		}

		ModelMap model = new ModelMap();
		
		model.put("productos", productList);
		
		return new ModelAndView("carrito", model);
		
	}
}
