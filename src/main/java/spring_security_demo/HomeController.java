package spring_security_demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/")
	public @ResponseBody String home(HttpServletRequest req) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication.getCredentials());
		System.out.println(authentication.getDetails());
		System.out.println(authentication.getName());
		System.out.println(authentication.getAuthorities());
		Object principal = authentication.getPrincipal();
		System.out.println(principal);
		return "This is home page";
	}
	
	@RequestMapping("/hi")
	public @ResponseBody String hi() {
		return "Hi User";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
