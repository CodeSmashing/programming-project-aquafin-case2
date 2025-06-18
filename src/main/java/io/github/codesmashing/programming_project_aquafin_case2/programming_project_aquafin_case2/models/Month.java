package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

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
@Table(name = "overstromingsgevaren_maanden")
public class Month {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotNull(message = "Name cannot be null")
	@Column(name = "naam")
	@Size(max = 50, message = "Name cannot exceed 50 characters")
	private String name;

	@NotNull(message = "Season ID cannot be null")
	@ManyToOne
	@JoinColumn(name = "overstromingsgevaren_seizoenen_id", referencedColumnName = "id")
	@JsonManagedReference
	private Season seasonId;

	@NotNull(message = "Rainfall cannot be null")
	@Column(name = "neerslag")
	private Float rainfall;

	@NotNull(message = "Guide value cannot be null")
	@Column(name = "richtwaarde")
	private Float guideValue;

	@Column(name = "laatst_bijgewerkt", updatable = false, insertable = false)
	private java.sql.Timestamp lastUpdated;

	public Month() {
	}

	public Month(
			Integer id, @NotNull(message = "Name cannot be null") String name,
			@NotNull(message = "Season ID cannot be null") Season seasonId,
			@NotNull(message = "Rainfall cannot be null") Float rainfall,
			@NotNull(message = "Guide value cannot be null") Float guideValue,
			java.sql.Timestamp lastUpdated) {
		this.id = id;
		this.name = name;
		this.seasonId = seasonId;
		this.rainfall = rainfall;
		this.guideValue = guideValue;
		this.lastUpdated = lastUpdated;
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

	public Season getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(Season seasonId) {
		this.seasonId = seasonId;
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

	public java.sql.Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(java.sql.Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
