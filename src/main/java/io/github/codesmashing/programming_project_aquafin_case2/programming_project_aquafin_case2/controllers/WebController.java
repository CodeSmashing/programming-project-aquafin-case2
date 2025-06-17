package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import java.time.Year;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Flood;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Season;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.FloodDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.MonthDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.SeasonDAO;

@Controller
public class WebController {
	private final FloodDAO floodDAO;
	private final SeasonDAO seasonDAO;
	private final MonthDAO monthDAO;

	@Autowired
	public WebController(SeasonDAO seasonDAO, FloodDAO floodDAO, MonthDAO monthDAO) {
		this.seasonDAO = seasonDAO;
		this.floodDAO = floodDAO;
		this.monthDAO = monthDAO;
	}

	@ModelAttribute("rainfallList")
	public Iterable<Season> getRainfallList() {
		return seasonDAO.findAll();
	}

	// @ModelAttribute("rainfallYoungest")
	// public Rainfall getYoungestRainfall() {
	// return monthDAO.findYoungest();
	// }

	@GetMapping({ "", "/", "/index" })
	public String showIndex() {
		return "index";
	}

	// @GetMapping({ "/data-raw", "/data-raw/", "/data-raw/" })
	// public String showRawData(ModelMap mapModelMap map) {
	// Integer stepCount = (int) Math.ceil((double) rainfallDAO.findLargest() / 10);
	// map.put("rainfallTableRulerSteps", stepCount);
	// }

	@GetMapping("/data-raw/{year}")
	public ResponseEntity<Season> getRainfall(@PathVariable("year") Year year) {
		Optional<Season> seasonOptional = seasonDAO.findById(year);
		if (seasonOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(seasonOptional.get());
	}

	@GetMapping("/data-raw/all")
	public ResponseEntity<Iterable<Season>> getSeasonAll() {
		return ResponseEntity.ok(seasonDAO.findAll());
	}
}
