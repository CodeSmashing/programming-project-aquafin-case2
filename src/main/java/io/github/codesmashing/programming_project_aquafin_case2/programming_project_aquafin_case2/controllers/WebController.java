package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.FloodRisk;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.PrecipitationData;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Region;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.FloodRiskDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.PrecipitationDataDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.RegionDAO;

@Controller
public class WebController {
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

	@GetMapping({ "", "/", "/index" })
	public String showIndex() {
		return "index";
	}
}
