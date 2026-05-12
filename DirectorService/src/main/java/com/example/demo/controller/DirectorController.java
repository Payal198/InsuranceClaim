package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Director;
@RestController
@RequestMapping("/director")
public class DirectorController {
	@GetMapping(value = "/{id}", produces = "application/json")
	public Director getMovie(@PathVariable int id) {
		Director mv= new Director();
		mv.setId(10);
		mv.setName("Payal");
		mv.setRegion("Mumbai");
		return mv;
	}
}
