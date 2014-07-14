package tallerweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/hi")
	public ModelAndView helloWorld( @RequestParam("nombre") String nombre) {

//		String message = "Hola, " + nombre + "!";
		return new ModelAndView("hello", "nombre", nombre);
		// ModelAndView("file", "varName", variable);
	}

	@RequestMapping("/hola/{nombre}")
	public ModelAndView helloWorld2(@PathVariable String nombre) {

//		String message = "Hola, " + nombre + "!";
		return new ModelAndView("hello", "nombre", nombre);
	}
	
}