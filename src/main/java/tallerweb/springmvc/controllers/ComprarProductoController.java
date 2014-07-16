package tallerweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Stock;

@Controller
@RequestMapping("/buying")
public class ComprarProductoController {
	
	@RequestMapping("/product/{productName}")
	public ModelAndView comprar(@PathVariable String productName) {
		
		Stock stock = Stock.getInstance();
		Integer availableStock = stock.obtenerStockDisponible(productName);
		
		ModelMap model = new ModelMap();
		
		model.put("producto", productName);
		model.put("stock", availableStock);
		
		return new ModelAndView("comprarProducto", model);
		
	}

	@RequestMapping("/product/{productName}/{quantity}")
	public ModelAndView comprarProducto(@PathVariable String productName, @PathVariable Integer quantity) {
		
		Stock stock = Stock.getInstance();
		
		Integer availableStock = stock.obtenerStockDisponible(productName);

		ModelMap model = new ModelMap();
		
		if (availableStock >= quantity ) {			
			stock.comprarProducto(productName, quantity);
		} else {
			model.put("message", "Stock agotado");
		}

		Integer updateStock = stock.obtenerStockDisponible(productName);
		
		model.put("producto", productName);
		model.put("stock", updateStock);
		
		return new ModelAndView("comprarProducto", model);
		
	}
	
}
