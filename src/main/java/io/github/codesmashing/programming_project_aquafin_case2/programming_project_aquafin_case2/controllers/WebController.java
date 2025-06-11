package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@Autowired
	public WebController() {

	}

	@GetMapping({ "", "/", "/index" })
	public String showIndex() {
		return "index";
	}

	@GetMapping({ "/data-raw" })
	public String showRawData() {
		return "data-raw";
	}
}
