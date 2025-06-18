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
@Table(name = "overstromingsgevaren_seizoenen")
public class Season {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotNull(message = "Flood ID cannot be null")
	@ManyToOne
	@JoinColumn(name = "overstromingsgevaren_id", referencedColumnName = "jaar")
	@JsonManagedReference
	private Flood floodId;

	@NotNull(message = "Season name cannot be null")
	@Column(name = "naam")
	@Size(max = 50, message = "Season name cannot exceed 50 characters")
	private String name;

	@NotNull(message = "Guide value cannot be null")
	@Column(name = "richtwaarde")
	private Float guideValue;

	@Column(name = "laatst_bijgewerkt", updatable = false, insertable = false)
	private java.sql.Timestamp lastUpdated;

	public Season() {
	}

	public Season(
			Integer id,
			@NotNull(message = "Flood ID cannot be null") Flood floodId,
			@NotNull(message = "Guide value cannot be null") Float guideValue,
			@NotNull(message = "Season name cannot be null") String name,
			java.sql.Timestamp lastUpdated) {
		this.id = id;
		this.floodId = floodId;
		this.guideValue = guideValue;
		this.name = name;
		this.lastUpdated = lastUpdated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Flood getFloodId() {
		return floodId;
	}

	public void setFloodId(Flood floodId) {
		this.floodId = floodId;
	}

	public Float getGuideValue() {
		return guideValue;
	}

	public void setGuideValue(Float guideValue) {
		this.guideValue = guideValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.sql.Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(java.sql.Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
