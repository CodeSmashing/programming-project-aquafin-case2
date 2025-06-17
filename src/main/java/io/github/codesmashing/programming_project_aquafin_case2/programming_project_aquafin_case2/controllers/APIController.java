package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Flood;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.FloodDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.MonthDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.SeasonDAO;

@RestController
@RequestMapping("/api")
public class APIController {
	private final FloodDAO floodDAO;
	private final SeasonDAO seasonDAO;
	private final MonthDAO monthDAO;

	@Autowired
	public APIController(SeasonDAO seasonDAO, FloodDAO floodDAO, MonthDAO monthDAO) {
		this.seasonDAO = seasonDAO;
		this.floodDAO = floodDAO;
		this.monthDAO = monthDAO;
	}

	@GetMapping({ "", "/" })
	public ResponseEntity<String> getResponse() {
		return ResponseEntity.ok("Successfully requested response");
	}

	@GetMapping("/data-raw/all")
	public ResponseEntity<Iterable<Flood>> getAllRainfallData() {
		return ResponseEntity.ok(floodDAO.findAll());
	}

}
