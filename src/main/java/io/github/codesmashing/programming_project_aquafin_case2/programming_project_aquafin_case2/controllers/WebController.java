package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.FloodRisk;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.PrecipitationData;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Region;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.FloodRiskDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.PrecipitationDataDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.RegionDAO;

@Controller
public class WebController {
	private final String apiBaseUrl = "http://localhost:8080/api";
	private final FloodRiskDAO floodRiskDAO;
	private final RegionDAO regionDAO;
	private final PrecipitationDataDAO precipitationDataDAO;

	@Autowired
	public WebController(RegionDAO regionDAO, FloodRiskDAO floodRiskDAO, PrecipitationDataDAO precipitationDataDAO) {
		this.floodRiskDAO = floodRiskDAO;
		this.regionDAO = regionDAO;
		this.precipitationDataDAO = precipitationDataDAO;
	}

	@ModelAttribute("floodRiskList")
	public Iterable<FloodRisk> getFloodRiskList() {
		return floodRiskDAO.findAll();
	}

	@ModelAttribute("regionList")
	public Iterable<Region> getRegionList() {
		return regionDAO.findAll();
	}

	@ModelAttribute("precipitationDataList")
	public Iterable<PrecipitationData> getPrecipitationDataList() {
		return precipitationDataDAO.findAll();
	}

	@ModelAttribute("currentDate")
	public String getCurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);

		return formattedDate;
	}

	@ModelAttribute("floodRisk")
	public FloodRisk getNewBlankFloodRisk() {
		return new FloodRisk();
	}

	@GetMapping({ "", "/", "/index" })
	public String showIndex() {
		return "index";
	}

	@GetMapping("/index/floodRisk")
	public String getFloodRisk(
			@RequestParam(required = false) Integer id,
			@RequestParam(required = false) String name,
			@RequestParam(name = "date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") String dateString,
			Model model) {
		if (dateString == null) {
			dateString = (String) model.getAttribute("currentDate");
		}

		// Roept API aan voor data
		RestTemplate restTemplate = new RestTemplate();
		String url = apiBaseUrl + "/flood-risk";

		if (id != null || name != null) {
			if (id != null) {
				url += "?region_id=" + id + "&date=" + dateString;
			}

			if (name != null) {
				url += "?region_name=" + name + "&date=" + dateString;
			}

			FloodRisk risk = restTemplate.getForObject(url, FloodRisk.class);
			model.addAttribute("risk", risk);
		}
		return "index";
	}

	@RequestMapping(value = "/save/floodRisk", method = RequestMethod.POST)
	public String saveFloodRisk(Model model, @ModelAttribute("floodRisk") FloodRisk floodRisk) {
		// logic to process input data
		return "index";
	}
}
