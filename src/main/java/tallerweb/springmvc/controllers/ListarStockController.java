package tallerweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Stock;

@Controller
public class ListarStockController {
	
	@RequestMapping("/products/listarStock")
	public ModelAndView listarStock() {
		
		Stock stock = Stock.getInstance();
		ModelMap model = new ModelMap();
		
//		model.putAll(stock.obtenerStock());
		
		return new ModelAndView("listarStock", model);
		
	}

}
