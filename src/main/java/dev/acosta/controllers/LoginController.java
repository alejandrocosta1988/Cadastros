package dev.acosta.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String viewLoginPage() {
		return "/login";
	}
	
	@GetMapping("/tchau")
	public String logoutPage() {
		return "/tchau";
	}
	
}
