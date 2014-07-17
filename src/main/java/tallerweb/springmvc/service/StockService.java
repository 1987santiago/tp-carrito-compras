package tallerweb.springmvc.service;

import java.util.List;

import tallerweb.springmvc.utils.Producto;

public interface StockService {

	List<Producto> getStock(); 
	
	void agregarStock(Producto producto);
	
}
