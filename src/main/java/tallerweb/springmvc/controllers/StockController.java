package tallerweb.springmvc.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.springmvc.utils.Carrito;
import tallerweb.springmvc.utils.Producto;
import tallerweb.springmvc.utils.Stock;

@Controller
@RequestMapping(value="stock")
public class StockController {
		
	@RequestMapping(value="nuevoProducto", method=RequestMethod.POST)
	public ModelAndView agregarProducto(@ModelAttribute(value="nombreProducto") String nombreProducto, @ModelAttribute(value="cantidadProducto") Integer cantidadProducto) {
		
		Stock stock = Stock.getInstance();
		
		if (!stock.existeProducto(nombreProducto)) {
			stock.agregarProducto(nombreProducto);
			stock.agregarStock(nombreProducto, cantidadProducto);
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
		
		Boolean hayProductos = (productList.size() >= 1);

		ModelMap model = new ModelMap();
		model.put("productos", productList);
		model.put("hayProductos", hayProductos);
		
		return new ModelAndView("agregarProductos", model);

	}

	@RequestMapping(value="agregarStock", method=RequestMethod.POST)
	public ModelAndView agregarStock(@ModelAttribute(value="nombreProducto") String nombreProducto, @ModelAttribute(value="cantidadProducto") Integer cantidadProducto) {
		
		Stock stock = Stock.getInstance();
		
		if (cantidadProducto != null) {
			stock.agregarStock(nombreProducto, cantidadProducto);
		}
		cantidadProducto = stock.obtenerStockDisponible(nombreProducto);
		
		ModelMap model = new ModelMap();
		model.put("producto", nombreProducto);
		model.put("stock", cantidadProducto);
		
		return new ModelAndView("agregarStock", model);
		
	}	
	
	@RequestMapping(value="comprar", method=RequestMethod.POST)
	public ModelAndView comprar(@ModelAttribute(value="nombreProducto") String nombreProducto, @ModelAttribute(value="cantidadProducto") Integer cantidadProducto) {
		
		Stock stock = Stock.getInstance();
		Carrito carrito = Carrito.getInstance();
		
		Integer stockDisponible = stock.obtenerStockDisponible(nombreProducto);
		if (stockDisponible > 0) {
			stock.comprarProducto(nombreProducto, cantidadProducto);
			carrito.agregarProductoConCantidad(nombreProducto, cantidadProducto);			
		} 
		
		stockDisponible = stock.obtenerStockDisponible(nombreProducto);
		
		ModelMap model = new ModelMap();
		model.put("producto", nombreProducto);
		model.put("stock", stockDisponible);
		
		return new ModelAndView("comprarProducto", model);
		
	}
	
}
