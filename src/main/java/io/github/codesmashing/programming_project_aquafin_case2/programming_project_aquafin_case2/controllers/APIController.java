package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Flood;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Month;
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
	public ResponseEntity<?> getCurrentMonth() {
		LocalDate currentDate = LocalDate.now();
		String currentMonth = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("nl"));
		Optional<Flood> floodOptional = floodDAO.findById(currentDate.getYear());

		if (floodOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Flood not found for current year: " + currentDate.getYear());
		}

		Optional<Month> monthOptional = monthDAO.findByFloodIdAndName(floodOptional.get(), currentMonth);
		if (monthOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Month not found for year " + floodOptional.get().getYear() + ": " + currentMonth);
		}

		return ResponseEntity.ok(monthOptional.get());
	}

	@GetMapping({ "{year}", "/{year}" })
	public ResponseEntity<?> getYear(@PathVariable("year") Integer year) {
		Optional<Flood> floodOptional = floodDAO.findById(year);
		if (floodOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Flood not found: " + year);
		}

		return ResponseEntity.ok(floodOptional.get());
	}

	@GetMapping({ "{year}/{month}", "/{year}/{month}/" })
	public ResponseEntity<?> getSpecificMonth(
			@PathVariable("year") Integer year,
			@PathVariable("month") String month) {
		Optional<Flood> floodOptional = floodDAO.findById(year);
		if (floodOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Flood not found: " + year);
		}

		Boolean isValidMonth = isValidMonth(month);
		if (!isValidMonth) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Invalid month format. Please use full Dutch month names.");
		}

		Optional<Month> monthOptional = monthDAO.findByFloodIdAndName(floodOptional.get(), month);
		if (monthOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Month not found for year " + year + ": " + month);
		}
		return ResponseEntity.ok(monthOptional.get());
	}

	private Boolean isValidMonth(String inputMonth) {
		for (java.time.Month month : java.time.Month.values()) {
			// Check if the input matches the full Dutch name of the month
			if (month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("nl")).equalsIgnoreCase(inputMonth)) {
				return true;
			}
		}
		return false;
	}
}
