package tallerweb.springmvc.service.impl;

import java.util.LinkedList;
import java.util.List;

import tallerweb.springmvc.service.StockService;
import tallerweb.springmvc.utils.Producto;

public class StockServiceImpl implements StockService {

	private List<Producto> productos = new LinkedList<Producto>();
	
	@Override
	public List<Producto> getStock() {
		return productos;
	}

	@Override
	public void agregarStock(Producto producto) {
		productos.add(producto);		
	}
	

}
