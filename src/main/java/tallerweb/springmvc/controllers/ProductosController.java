package tallerweb.springmvc.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Producto;
import tallerweb.springmvc.utils.Stock;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	/**
	 * Agrega el producto pasado por parametro al Stock (si no existe)
	 * @param String producto
	 * @return ModelAndView
	 */
	@RequestMapping("/agregar/{producto}")
	public ModelAndView agregarProducto( @PathVariable String producto) {
		
		Stock stock = Stock.getInstance();
		
		if (!stock.existeProducto(producto)) {
			stock.agregarProducto(producto);
		}

		Map<String, Integer> mapStock = stock.obtenerStock();
		Set<String> setStock = mapStock.keySet();
		List<Producto> productList = new ArrayList<Producto>(); 
		
		for (Iterator<String> iterator = setStock.iterator(); iterator.hasNext();) {
			String nombre = iterator.next();
			Integer cantidad = mapStock.get(nombre);

			Producto otroProducto = new Producto(nombre, cantidad);
			productList.add(otroProducto);
		}
		
		ModelMap model = new ModelMap();
		model.put("productos", productList);
		
		return new ModelAndView("agregarProductos", model);
		
	}

	/**
	 * Lista todos los productos del Stock 
	 * @return ModelAndView
	 */
	@RequestMapping("/listar")
	public ModelAndView listarProductos() {
		
		Stock stock = Stock.getInstance();
		
		Map<String, Integer> mapStock = stock.obtenerStock();
		Set<String> setStock = mapStock.keySet();
		List<Producto> productList = new ArrayList<Producto>(); 
		
		for (Iterator<String> iterator = setStock.iterator(); iterator.hasNext();) {
			String nombre = iterator.next();
			Integer cantidad = mapStock.get(nombre);

			Producto otroProducto = new Producto(nombre, cantidad);
			productList.add(otroProducto);
		}
		
		Boolean hayProductos = (productList.size() >= 1);
		
		ModelMap model = new ModelMap();
		model.put("productos", productList);
		model.put("hayProductos", hayProductos);
		
		return new ModelAndView("agregarProductos", model);
		
	}
	
	/**
	 * En base al producto pasado por parametro,<br> 
	 * obtiene su stock y lo muestra. 
	 * @param String producto
	 * @return ModelAndView
	 */
	@RequestMapping("/comprar/{producto}")
	public ModelAndView comprar(@PathVariable String producto) {
		
		Stock stock = Stock.getInstance();
		Integer availableStock = stock.obtenerStockDisponible(producto);
		
		ModelMap model = new ModelMap();
		
		model.put("producto", producto);
		model.put("stock", availableStock);
		
		return new ModelAndView("comprarProducto", model);
		
	}

}