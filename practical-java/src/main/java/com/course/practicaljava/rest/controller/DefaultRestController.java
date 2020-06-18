package com.course.practicaljava.rest.controller;

import java.time.LocalTime;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	//Working with headers
	@GetMapping(path="/get-header1")
	public String header1(@RequestHeader("User-agent") String userAgent, 
			              @RequestHeader("Practical-java") String practicalJava) {
		StringBuilder sb = new StringBuilder();
		sb.append("product version: " + userAgent);
		sb.append("||");
		sb.append("About project " + practicalJava);
		
		return sb.toString();
	}
	
	@GetMapping(path="/get-header2")
	public String header2(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("product version: " + request.getHeader("User-agent"));
		sb.append("||");
		sb.append("About project " + request.getHeader("Practical-java"));
		
		return sb.toString();
	}
	
	@GetMapping(path="/get-header3")
	public Map<String, String> header3(@RequestHeader HttpHeaders headers) {
		return headers.toSingleValueMap();
	}

}
