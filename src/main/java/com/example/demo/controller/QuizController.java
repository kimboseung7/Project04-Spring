package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Quiz")
public class QuizController {

	@GetMapping("/Quiz1")
	public String Quiz1() {
		return "/jsp/Quiz1";
	}
	
	@GetMapping("/Quiz2")
	public String Quiz2() {
		return "/jsp/Quiz2";
	}
}
