package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.component.TestComponent;

@Controller
public class HelloController {
	
	@Autowired
	private TestComponent test;
	
	@RequestMapping("/mvc")
	public String lalala(String name, Model m) {
		m.addAttribute("name", name);
		
		test.yell();
		
		return "mvc";
	}
	
}
