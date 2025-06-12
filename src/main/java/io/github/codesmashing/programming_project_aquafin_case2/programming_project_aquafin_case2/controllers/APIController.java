package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Rainfall;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.FloodDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.RainfallDAO;

@RestController
@RequestMapping("/api")
public class APIController {
	private final RainfallDAO rainfallDAO;
	private final FloodDAO floodDAO;

	@Autowired
	public APIController(RainfallDAO rainfallDAO, FloodDAO floodDAO) {
		this.rainfallDAO = rainfallDAO;
		this.floodDAO = floodDAO;
	}

	@GetMapping({ "", "/" })
	public ResponseEntity<String> getResponse() {
		return ResponseEntity.ok("Successfully requested response");
	}

	@GetMapping("/data-raw/all")
	public ResponseEntity<Iterable<Rainfall>> getAllRainfallData() {
		return ResponseEntity.ok(rainfallDAO.findAll());
	}

}
