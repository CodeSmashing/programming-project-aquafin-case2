package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.converters.YearConverter;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "seizoenen")
public class Season {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotNull(message = "Year ID cannot be null")
	@ManyToOne
	@JoinColumn(name = "jaar_id", referencedColumnName = "jaar")
	@JsonManagedReference
	private Flood yearId;

	@Nullable
	@OneToOne
	@JoinColumn(name = "maand_id_1", referencedColumnName = "id")
	@JsonManagedReference
	private Month firstMonth;

	@Nullable
	@OneToOne
	@JoinColumn(name = "maand_id_2", referencedColumnName = "id")
	@JsonManagedReference
	private Month secondMonth;

	@Nullable
	@OneToOne
	@JoinColumn(name = "maand_id_3", referencedColumnName = "id")
	@JsonManagedReference
	private Month thirdMonth;

	@NotNull(message = "Guide value cannot be null")
	@Column(name = "richtwaarde")
	private Float guideValue;

	@Column(name = "is_historisch")
	private Boolean isHistoric;

	public Season() {
	}

	public Season(Integer id, @NotNull(message = "Year ID cannot be null") Flood yearId, Month firstMonth,
			Month secondMonth, Month thirdMonth,
			@NotNull(message = "Guide value cannot be null") Float guideValue, Boolean isHistoric) {
		this.id = id;
		this.yearId = yearId;
		this.firstMonth = firstMonth;
		this.secondMonth = secondMonth;
		this.thirdMonth = thirdMonth;
		this.guideValue = guideValue;
		this.isHistoric = isHistoric;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Flood getYearId() {
		return yearId;
	}

	public void setYearId(Flood yearId) {
		this.yearId = yearId;
	}

	public Month getFirstMonth() {
		return firstMonth;
	}

	public void setFirstMonth(Month firstMonth) {
		this.firstMonth = firstMonth;
	}

	public Month getSecondMonth() {
		return secondMonth;
	}

	public void setSecondMonth(Month secondMonth) {
		this.secondMonth = secondMonth;
	}

	public Month getThirdMonth() {
		return thirdMonth;
	}

	public void setThirdMonth(Month thirdMonth) {
		this.thirdMonth = thirdMonth;
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
