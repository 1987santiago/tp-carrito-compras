package tallerweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Stock;

@Controller
@RequestMapping("/agregarProductos")
public class AgregarProductoController {

	/**
	 * Agrega un nuevo producto al Stock
	 * @return ModelAndView
	 */
	@RequestMapping("/nuevoProducto/{producto}")
	public ModelAndView agregarProducto( @PathVariable String producto) {
		
		Stock stock = Stock.getInstance();
		
		if (!stock.existeProducto(producto)) {
			stock.agregarProducto(producto);
		}
		
		ModelMap model = new ModelMap();
		model.put("productos", stock.listarProductosDisponibles());
		
		return new ModelAndView("agregarProductos", model);
		
	}

}
