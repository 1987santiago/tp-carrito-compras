package tallerweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Stock;

@Controller
@RequestMapping("/agregarStock")
public class AgregarStockController {

	/**
	 * Muestra la cantidad de stock del producto pasado por parametro.
	 * @param String producto 
	 * @return ModelAndView
	 */
	@RequestMapping("/{producto}")
	public ModelAndView agregarStock( @PathVariable String producto) {
		
		Stock stock = Stock.getInstance();
		
		// Obtenemos la cantidad de stock del producto pasado por parametro
		Integer productStock = stock.obtenerStock().get(producto);
		
		ModelMap model = new ModelMap();
		model.put("producto", producto);
		model.put("stock", productStock);
		
		return new ModelAndView("agregarStock", model);
		
	}

	/**
	 * Lista los productos disponibles en el Stock.
	 * @return ModelAndView
	 */
	@RequestMapping("/listar")
	public ModelAndView listarProductos() {
		
		Stock stock = Stock.getInstance();
		
		ModelMap model = new ModelMap();
		model.put("productos", stock.listarProductosDisponibles());
		
		return new ModelAndView("agregarProductos", model);
		
	}

	/**
	 * Agrega la cantidad de unidades pasadas por parametro <br>
	 * a un producto del Stock.
	 * @param String producto
	 * @param Integer cantidad 
	 * @return ModelAndView
	 */
	@RequestMapping("/{producto}/cantidad/{cantidad}")
	public ModelAndView agregarStockAProducto( @PathVariable String producto, @PathVariable Integer cantidad) {
		
		Stock stock = Stock.getInstance();
		
		stock.agregarStock(producto, cantidad);
		Integer availableStock = stock.obtenerStockDisponible(producto);
		
		ModelMap model = new ModelMap();
		model.put("producto", producto);
		model.put("stock", availableStock);
		
		return new ModelAndView("agregarStock", model);
		
	}

}