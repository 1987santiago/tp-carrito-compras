package tallerweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Carrito;
import tallerweb.springmvc.utils.Stock;

@Controller
@RequestMapping("/buying")
public class ComprarProductoController {

	/**
	 * En base al producto pasado por parametro,<br> 
	 * obtiene su stock y lo muestra. 
	 * @param String producto
	 * @return ModelAndView
	 */
	@RequestMapping("/product/{producto}")
	public ModelAndView comprar(@PathVariable String producto) {
		
		Stock stock = Stock.getInstance();
		Integer availableStock = stock.obtenerStockDisponible(producto);
		
		ModelMap model = new ModelMap();
		
		model.put("producto", producto);
		model.put("stock", availableStock);
		
		return new ModelAndView("comprarProducto", model);
		
	}

	/**
	 * Agrega al carrito de compras el producto y cantidad pasado por parametro.
	 * @param String producto
	 * @param Integer cantidad
	 * @return ModelAndView
	 */
	@RequestMapping("/product/{producto}/{cantidad}")
	public ModelAndView comprarProducto(@PathVariable String producto, @PathVariable Integer cantidad) {
		
		Stock stock = Stock.getInstance();
		Carrito carrito = Carrito.getInstance();
		
		Integer availableStock = stock.obtenerStockDisponible(producto);

		ModelMap model = new ModelMap();
		
		if (availableStock >= cantidad ) {			
			stock.comprarProducto(producto, cantidad);
			carrito.agregarProducto(producto);
			carrito.agregarProductoConCantidad(producto, cantidad);
		} else {
			model.put("message", "Stock agotado");
		}

		Integer updateStock = stock.obtenerStockDisponible(producto);
		
		model.put("producto", producto);
		model.put("stock", updateStock);
		
		return new ModelAndView("comprarProducto", model);
		
	}
	
}
