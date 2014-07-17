package tallerweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Carrito;
import tallerweb.springmvc.utils.Stock;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@RequestMapping(value="comprar", method=RequestMethod.POST)
	public ModelAndView comprar(@ModelAttribute(value="nombreProducto") String nombreProducto, @ModelAttribute(value="cantidadProducto") Integer cantidadProducto) {
		
		Stock stock = Stock.getInstance();
		Carrito carrito = Carrito.getInstance();
		ModelMap model = new ModelMap();
		
		Integer stockDisponible = stock.obtenerStockDisponible(nombreProducto);
		if (stockDisponible >= cantidadProducto) {
			stock.comprarProducto(nombreProducto, cantidadProducto);
			carrito.agregarProductoConCantidad(nombreProducto, cantidadProducto);			
		} else {
			String msg = "Stock insuficiente para esa cantidad";
			model.put("msg", msg);
		}
		
		stockDisponible = stock.obtenerStockDisponible(nombreProducto);
		
		model.put("producto", nombreProducto);
		model.put("stock", stockDisponible);
		
		return new ModelAndView("comprarProducto", model);
		
	}
	
}
