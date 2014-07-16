package tallerweb.springmvc.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Stock;

@Controller
public class ListarStockController {
	
	@RequestMapping("/listarStock")
	public ModelAndView listarStock() {
		
		Stock stock = Stock.getInstance();
		stock.agregarProducto("Manzana");
		stock.agregarProducto("Pera");
		stock.agregarStock("Manzana", 100);
		stock.agregarStock("Pera", 40);
		
		List<String> products = new ArrayList<String>();

		products.add("Tomate");
		products.add("Zanangoria");
		products.add("Papa");
		products.add("S‡ndia");

		/**
		 * TODO: generar un mapa con la key y el stock de cada producto
		 * ej: {Ê{"name" : "Tomate", "stock" : 1000}, {"name" : "Papa", "stock" : 400} } 
		 */
		
		// Obtenemos una coleccion con los valores de stock de cada producto
		Collection<Integer> q = stock.obtenerStock().values();
		
		ModelMap model = new ModelMap();
		
		model.put("nombre", "stockList");
		model.put("productos", stock.listarProductosDisponibles());
		model.put("stock", stock.obtenerStock());
		model.put("cantidades", q);
		
		return new ModelAndView("listarStock", model);
		
	}

}
