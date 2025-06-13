package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.Year;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.converters.YearConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "jaarlijkseneerslagdata")
public class Rainfall {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jaar")
	@Convert(converter = YearConverter.class)
	private Year year;

	@NotNull(message = "January rainfall cannot be null")
	@Column(name = "neerslag_jan")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer january;

	@NotNull(message = "February rainfall cannot be null")
	@Column(name = "neerslag_feb")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer february;

	@NotNull(message = "March rainfall cannot be null")
	@Column(name = "neerslag_mrt")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer march;

	@NotNull(message = "April rainfall cannot be null")
	@Column(name = "neerslag_apr")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer april;

	@NotNull(message = "May rainfall cannot be null")
	@Column(name = "neerslag_mei")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer may;

	@NotNull(message = "June rainfall cannot be null")
	@Column(name = "neerslag_jun")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer june;

	@NotNull(message = "July rainfall cannot be null")
	@Column(name = "neerslag_jul")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer july;

	@NotNull(message = "August rainfall cannot be null")
	@Column(name = "neerslag_aug")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer august;

	@NotNull(message = "September rainfall cannot be null")
	@Column(name = "neerslag_sep")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer september;

	@NotNull(message = "October rainfall cannot be null")
	@Column(name = "neerslag_okt")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer october;

	@NotNull(message = "November rainfall cannot be null")
	@Column(name = "neerslag_nov")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer november;

	@NotNull(message = "December rainfall cannot be null")
	@Column(name = "neerslag_dec")
	@Min(value = 0, message = "Rainfall cannot be less than 0")
	@Max(value = 1000, message = "Rainfall cannot exceed 1000")
	private Integer december;

	public Rainfall() {
	}

	public Rainfall(Year year, Integer january, Integer february, Integer march, Integer april, Integer may,
			Integer june, Integer july, Integer august, Integer september, Integer october, Integer november,
			Integer december) {
		this.year = year;
		this.january = january;
		this.february = february;
		this.march = march;
		this.april = april;
		this.may = may;
		this.june = june;
		this.july = july;
		this.august = august;
		this.september = september;
		this.october = october;
		this.november = november;
		this.december = december;
	}

	// Getters
	public Year getYear() {
		return this.year;
	}

	public Integer getJanuary() {
		return this.january;
	}

	public Integer getFebruary() {
		return this.february;
	}

	public Integer getMarch() {
		return this.march;
	}

	public Integer getApril() {
		return this.april;
	}

	public Integer getMay() {
		return this.may;
	}

	public Integer getJune() {
		return this.june;
	}

	public Integer getJuly() {
		return this.july;
	}

	public Integer getAugust() {
		return this.august;
	}

	public Integer getSeptember() {
		return this.september;
	}

	public Integer getOctober() {
		return this.october;
	}

	public Integer getNovember() {
		return this.november;
	}

	public Integer getDecember() {
		return this.december;
	}

	// Setters
	public void setYear(Year year) {
		this.year = year;
	}

	public void setJanuary(Integer january) {
		this.january = january;
	}

	public void setFebruary(Integer february) {
		this.february = february;
	}

	public void setMarch(Integer march) {
		this.march = march;
	}

	public void setApril(Integer april) {
		this.april = april;
	}

	public void setMay(Integer may) {
		this.may = may;
	}

	public void setJune(Integer june) {
		this.june = june;
	}

	public void setJuly(Integer july) {
		this.july = july;
	}

	public void setAugust(Integer august) {
		this.august = august;
	}

	public void setSeptember(Integer september) {
		this.september = september;
	}

	public void setOctober(Integer october) {
		this.october = october;
	}

	public void setNovember(Integer november) {
		this.november = november;
	}

	public void setDecember(Integer december) {
		this.december = december;
	}
}
