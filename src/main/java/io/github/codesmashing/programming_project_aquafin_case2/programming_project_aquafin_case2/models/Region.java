package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "regions")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(nullable = false)
	private Integer regionId;

	@Size(max = 50, message = "Region name cannot exceed 50 characters")
	private String regionName;

	@Size(max = 255, message = "Description cannot exceed 255 characters")
	private String regionDescription;

	@NotNull
	@Column(nullable = false)
	private Double latitude;

	@NotNull
	@Column(nullable = false)
	private Double longitude;

	public Region() {
	}

	public Region(@Size(max = 50, message = "Region name cannot exceed 50 characters") String regionName,
			@Size(max = 255, message = "Description cannot exceed 255 characters") String regionDescription,
			Double latitude, Double longitude) {
		this.regionName = regionName;
		this.regionDescription = regionDescription;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionDescription() {
		return regionDescription;
	}

	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
