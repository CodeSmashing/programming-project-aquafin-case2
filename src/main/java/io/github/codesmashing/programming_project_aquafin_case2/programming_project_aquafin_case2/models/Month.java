package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "maanden")
public class Month {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotNull(message = "Name cannot be null")
	@Column(name = "naam")
	@Size(max = 50, message = "Name cannot exceed 50 characters")
	private String name;

	@NotNull(message = "Year ID cannot be null")
	@ManyToOne
	@JoinColumn(name = "jaar_id", referencedColumnName = "jaar")
	@JsonManagedReference
	private Flood yearId;

	@NotNull(message = "Rainfall cannot be null")
	@Column(name = "neerslag")
	private Float rainfall;

	@NotNull(message = "Guide value cannot be null")
	@Column(name = "richtwaarde")
	private Float guideValue;

	@Column(name = "is_historisch")
	private Boolean isHistoric;

	public Month() {
	}

	public Month(Integer id, @NotNull(message = "Name cannot be null") String name,
			@NotNull(message = "Year ID cannot be null") Flood yearId,
			@NotNull(message = "Rainfall cannot be null") Float rainfall,
			@NotNull(message = "Guide value cannot be null") Float guideValue, Boolean isHistoric) {
		this.id = id;
		this.name = name;
		this.yearId = yearId;
		this.rainfall = rainfall;
		this.guideValue = guideValue;
		this.isHistoric = isHistoric;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Flood getYearId() {
		return yearId;
	}

	public void setYearId(Flood yearId) {
		this.yearId = yearId;
	}

	public Float getRainfall() {
		return rainfall;
	}

	public void setRainfall(Float rainfall) {
		this.rainfall = rainfall;
	}

	public Float getGuideValue() {
		return guideValue;
	}

	public void setGuideValue(Float guideValue) {
		this.guideValue = guideValue;
	}

	public Boolean getIsHistoric() {
		return isHistoric;
	}

	public void setIsHistoric(Boolean isHistoric) {
		this.isHistoric = isHistoric;
	}
}
