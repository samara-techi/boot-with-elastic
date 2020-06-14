package com.course.practicaljava.rest.controller;

import java.time.LocalTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DefaultRestController {
	@GetMapping("/welcome")
	public String welcome() {
		System.out.println(StringUtils.join("Hai ", "welcome to ", "spring boot ", "REST api."));
		return "Hellow spring boot";
	}
	
	@GetMapping("/time")
	public String showTime() {
		return LocalTime.now().toString();
	}

}
