package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "precipitation_data")
public class PrecipitationData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(nullable = false)
	private Integer precipitationDataId;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "region_id", nullable = false)
	@JsonManagedReference
	private Region region;

	@NotNull
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateOccurence;

	@PositiveOrZero
	@NotNull
	@Column(nullable = false)
	private Double quantityInMm;

	@PositiveOrZero
	private Integer dataType; // 0 = historical, 1 = forecast

	@Size(max = 255, message = "Source cannot exceed 255 characters")
	private String source;

	public PrecipitationData() {
	}

	public PrecipitationData(
			Region region,
			LocalDate dateOccurence,
			Double quantityInMm,
			Integer dataType,
			String source) {
		this.region = region;
		this.dateOccurence = dateOccurence;
		this.quantityInMm = quantityInMm;
		this.dataType = dataType;
		this.source = source;
	}

	public Integer getPrecipitationDataId() {
		return precipitationDataId;
	}

	public void setPrecipitationDataId(Integer precipitationDataId) {
		this.precipitationDataId = precipitationDataId;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public LocalDate getDateOccurence() {
		return dateOccurence;
	}

	public void setDateOccurence(LocalDate dateOccurence) {
		this.dateOccurence = dateOccurence;
	}

	public Double getQuantityInMm() {
		return quantityInMm;
	}

	public void setQuantityInMm(Double quantityInMm) {
		this.quantityInMm = quantityInMm;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
