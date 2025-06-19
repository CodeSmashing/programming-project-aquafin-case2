package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.FloodRisk;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.PrecipitationData;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Region;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.FloodRiskDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.PrecipitationDataDAO;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO.RegionDAO;

@RestController
@RequestMapping("/api")
public class APIController {
	private final FloodRiskDAO floodRiskDAO;
	private final RegionDAO regionDAO;
	private final PrecipitationDataDAO precipitationDataDAO;

	@Autowired
	public APIController(RegionDAO regionDAO, FloodRiskDAO floodRiskDAO, PrecipitationDataDAO precipitationDataDAO) {
		this.regionDAO = regionDAO;
		this.floodRiskDAO = floodRiskDAO;
		this.precipitationDataDAO = precipitationDataDAO;
	}

	@GetMapping({ "/regions" })
	public ResponseEntity<Iterable<Region>> getRegions() {
		return ResponseEntity.ok(regionDAO.findAll());
	}

	@GetMapping({ "/precipitation/all" })
	public ResponseEntity<Iterable<PrecipitationData>> getPrecipitations() {
		return ResponseEntity.ok(precipitationDataDAO.findAll());
	}

	@GetMapping({ "/precipitation" })
	public ResponseEntity<?> getPrecipitationPerRegionPerMonth(
			@RequestParam(value = "region_id", required = false) Integer id,
			@RequestParam(value = "region_name", required = false) String name,
			@RequestParam("date") @DateTimeFormat(pattern = "dd/MM/yyyy") String dateString) {
		LocalDate date;

		try {
			date = LocalDate.parse(dateString);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body("The date was not in a correct format: " + dateString);
		}

		Optional<Region> regionOptional = Optional.empty();

		if (id != null) {
			regionOptional = regionDAO.findById(id);
		}

		if (regionOptional.isEmpty() && name != null) {
			regionOptional = regionDAO.findByRegionName(name);
		}

		if (regionOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Region not found by name: " + name + ". Or by ID: " + id);
		}

		Optional<PrecipitationData> precipitationOptional = precipitationDataDAO
				.findByRegionAndDateOccurence(regionOptional.get(), date);
		if (precipitationOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Precipitation not found for region " + regionOptional.get().getRegionName() + ": " + date);
		}

		return ResponseEntity.ok(precipitationOptional.get());
	}

	@GetMapping({ "/flood-risk/all" })
	public ResponseEntity<Iterable<FloodRisk>> getFloodRisks() {
		return ResponseEntity.ok(floodRiskDAO.findAll());
	}

	@GetMapping({ "/flood-risk" })
	public ResponseEntity<?> getFloodRiskPerRegionPerMonth(
			@RequestParam(value = "region_id", required = false) Integer id,
			@RequestParam(value = "region_name", required = false) String name,
			@RequestParam("date") @DateTimeFormat(pattern = "dd/MM/yyyy") String dateString) {
		LocalDate date;

		try {
			date = LocalDate.parse(dateString);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body("The date was not in a correct format: " + dateString);
		}

		Optional<Region> regionOptional = Optional.empty();

		if (id != null) {
			regionOptional = regionDAO.findById(id);
		}

		if (regionOptional.isEmpty() && name != null) {
			regionOptional = regionDAO.findByRegionName(name);
		}

		if (regionOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Region not found by name: " + name + ". Or by ID: " + id);
		}

		Optional<FloodRisk> floodRiskOptional = floodRiskDAO
				.findByRegionAndDateOccurence(regionOptional.get(), date);
		if (floodRiskOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Flood risk not found for region " + regionOptional.get().getRegionName() + ": " + date);
		}

		return ResponseEntity.ok(floodRiskOptional.get());
	}

	@PostMapping({ "/precipitation" })
	public ResponseEntity<?> addPrecipitation(
			@RequestParam(value = "region_id", required = false) Integer id,
			@RequestParam(name = "region_name", required = false) String name,
			@RequestParam("date") @DateTimeFormat(pattern = "dd/MM/yyyy") String dateString,
			@RequestParam("rainfall") Double rainfall,
			@RequestParam(value = "type") Integer dataType,
			@RequestParam(value = "source", required = false) String source) {
		LocalDate date;

		try {
			date = LocalDate.parse(dateString);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body("The date was not in a correct format: " + dateString);
		}

		Optional<Region> regionOptional = Optional.empty();

		if (id != null) {
			regionOptional = regionDAO.findById(id);
		}

		if (regionOptional.isEmpty() && name != null) {
			regionOptional = regionDAO.findByRegionName(name);
		}

		if (regionOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Region not found by name: " + name + ". Or by ID: " + id);
		}

		PrecipitationData newPrecipitationData = new PrecipitationData();
		newPrecipitationData.setDataType(dataType);
		newPrecipitationData.setDateOccurence(date);
		newPrecipitationData.setQuantityInMm(rainfall);
		newPrecipitationData.setRegion(regionOptional.get());
		newPrecipitationData.setSource(source);

		precipitationDataDAO.save(newPrecipitationData);

		return ResponseEntity.ok("Event created successfully");
	}

	// (optioneel) POST /flood-risks – handmatig risico toevoegen
}
