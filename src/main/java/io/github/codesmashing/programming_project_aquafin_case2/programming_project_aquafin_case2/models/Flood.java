package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.converters.YearConverter;

@Entity
@Table(name = "Overstromingsberekeningen")
public class Flood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jaar")
    @Convert(converter = YearConverter.class)
    private Year year;

    @NotNull(message = "Season cannot be null")
    @Column(name = "seizoen")
    @Size(max = 20, message = "Season name length cannot exceed 20 characters.")
    private String season;

    @NotNull(message = "Months cannot be null")
    @Column(name = "maanden")
    @Size(max = 20, message = "Months string length cannot exceed 20 characters.")
    private String months;

    @NotNull(message = "Total cannot be null")
    @Column(name = "totaal")
    private Integer total;

    @NotNull(message = "GuideValue cannot be null")
    @Column(name = "richtwaarde")
    private Integer guideValue;

    @OneToOne
    @JoinColumn(name = "data_id", referencedColumnName = "jaar")
    @JsonManagedReference
    private Rainfall rainfall;

    public Flood() {
    }

    public Flood(Year year, String season, String months, Integer total, Integer guideValue) {
        this.year = year;
        this.season = season;
        this.months = months;
        this.total = total;
        this.guideValue = guideValue;
    }

    // Getters
    public Year getYear() {
        return this.year;
    }

    public String getSeason() {
        return this.season;
    }

    public String getMonths() {
        return months;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getGuideValue() {
        return guideValue;
    }

    // Setters
    public void setYear(Year year) {
        this.year = year;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public void setTotaal(Integer total) {
        this.total = total;
    }

    public void setGuideValue(Integer guideValue) {
        this.guideValue = guideValue;
    }

    // Optionele businesslogica
    public boolean isMoreThenGuide() {
        return this.total != null && this.guideValue != null && this.total.compareTo(this.guideValue) > 0;
    }
}
