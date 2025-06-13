package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import java.time.Year;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Rainfall;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Flood;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.FloodDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.RainfallDAO;

@Controller
public class WebController {
	private final RainfallDAO rainfallDAO;
	private final FloodDAO floodDAO;

	@Autowired
	public WebController(RainfallDAO rainfallDAO, FloodDAO floodDAO) {
		this.rainfallDAO = rainfallDAO;
		this.floodDAO = floodDAO;
	}

	@GetMapping({ "", "/", "/index" })
	public String showIndex() {
		return "index";
	}

	@GetMapping({ "/data-raw" })
	public String showRawData() {
		return "data-raw";
	}

	@GetMapping("/data-raw/{year}")
	public ResponseEntity<Rainfall> getRainfall(@PathVariable("year") Year year) {
		Optional<Rainfall> rainfallOptional = rainfallDAO.findById(year);
		if (rainfallOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(rainfallOptional.get());
	}

	@GetMapping("/data-raw/all")
	public ResponseEntity<Iterable<Rainfall>> getRainfallAll() {
		return ResponseEntity.ok(rainfallDAO.findAll());
	}
}
