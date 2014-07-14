package tallerweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContadorLetrasController {

	@RequestMapping("/contadorLetras/{nombre}")
	public ModelAndView contadorLetras( @PathVariable String nombre) {
		
		Integer cantidadLetras = nombre.length();
		
		ModelMap model = new ModelMap();
		
		model.put("nombre", nombre);
		model.put("cantidadLetras", cantidadLetras);
		
		return new ModelAndView("contadorLetras", model);
				
	}
	
	
}