package tallerweb.springmvc.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

/**
 * alternativa de testing: http://blog.zenika.com/index.php?post/2013/01/15/spring-mvc-test-framework
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class HelloWorldControllerTests {

	@Test
	public void helloWorld() throws Exception {

		HelloWorldController controller = new HelloWorldController();
		ModelAndView modelAndView = controller.helloWorld("Obi");

		Assert.assertEquals("hello", modelAndView.getViewName());
		Assert.assertEquals("Hola, Obi!", modelAndView.getModel().get("message"));

	}

	@Configuration
	public static class TestConfiguration {

		@Bean
		public HelloWorldController helloWorldController() {
			return new HelloWorldController();
		}

	}
}
