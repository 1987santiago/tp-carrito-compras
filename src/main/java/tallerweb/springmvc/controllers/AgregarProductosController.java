package tallerweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Stock;

@Controller
@RequestMapping("/productos")
public class AgregarProductosController {
	
	@RequestMapping("/agregar/{producto}")
	public ModelAndView agregarProducto( @PathVariable String producto) {
		
		Stock stock = Stock.getInstance();
		
		if (!stock.existeProducto(producto)) {
			stock.agregarProducto(producto);
		}
		
		ModelMap model = new ModelMap();
		model.put("productos", stock.listarProductosDisponibles());
		
		return new ModelAndView("agregarProductos", model);
		
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarProductos() {
		
		Stock stock = Stock.getInstance();
		
		ModelMap model = new ModelMap();
		model.put("productos", stock.listarProductosDisponibles());
		
		return new ModelAndView("agregarProductos", model);
		
	}

}