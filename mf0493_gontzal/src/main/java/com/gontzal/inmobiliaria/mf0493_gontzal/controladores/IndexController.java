package com.gontzal.inmobiliaria.mf0493_gontzal.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/")
	public String index() {
		return "redirect:/inmuebles";
	}
}