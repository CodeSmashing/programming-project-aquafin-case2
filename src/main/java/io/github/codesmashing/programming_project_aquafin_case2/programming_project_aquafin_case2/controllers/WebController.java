package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Flood;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Month;
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
		this.floodDAO = floodDAO;
		this.seasonDAO = seasonDAO;
		this.monthDAO = monthDAO;
	}

	@ModelAttribute("floodList")
	public Iterable<Flood> getFloodList() {
		return floodDAO.findAll();
	}

	@ModelAttribute("seasonList")
	public Iterable<Season> getSeasonList() {
		return seasonDAO.findAll();
	}

	@ModelAttribute("monthList")
	public Iterable<Month> getMonthList() {
		return monthDAO.findAll();
	}

	@ModelAttribute("currentDate")
	public String getCurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);

		return formattedDate;
	}

	@GetMapping({ "", "/", "/index" })
	public String showIndex() {
		return "index";
	}

	// @GetMapping("/data-raw/{year}")
	// public ResponseEntity<Season> getRainfall(@PathVariable("year") Year year) {
	// Optional<Season> seasonOptional = seasonDAO.findById(year);
	// if (seasonOptional.isEmpty()) {
	// return ResponseEntity.notFound().build();
	// }

	// return ResponseEntity.ok(seasonOptional.get());
	// }

	// @GetMapping("/data-raw/all")
	// public ResponseEntity<Iterable<Season>> getSeasonAll() {
	// return ResponseEntity.ok(seasonDAO.findAll());
	// }
}
