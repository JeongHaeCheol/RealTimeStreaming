package com.sun.fe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StreamingController {

	
	
	@RequestMapping(value="/streaming", method = RequestMethod.GET)
	public String streaming() {
		
		return "streaming_page";
	}
	
	
	
	
	
}
