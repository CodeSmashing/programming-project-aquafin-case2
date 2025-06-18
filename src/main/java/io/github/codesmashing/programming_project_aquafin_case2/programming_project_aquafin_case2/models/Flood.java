package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "overstromingsgevaren")
public class Flood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jaar")
    @NotNull(message = "Year cannot be null")
    private Integer year;

    @NotNull(message = "Guide value cannot be null")
    @Column(name = "richtwaarde")
    @Max(value = 100, message = "Guide value cannot exceed 100")
    @Min(value = 0, message = "Guide value cannot be less than 0")
    private Float guideValue;

    @Column(name = "laatst_bijgewerkt", updatable = false, insertable = false)
    private java.sql.Timestamp lastUpdated;

    public Flood() {
    }

    public Flood(
            Integer year,
            @NotNull(message = "Guide value cannot be null") Float guideValue,
            java.sql.Timestamp lastUpdated) {
        this.year = year;
        this.guideValue = guideValue;
        this.lastUpdated = lastUpdated;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    // public boolean isMoreThenGuide() {
    // return this.total != null && this.guideValue != null &&
    // this.total.compareTo(this.guideValue) > 0;
    // }
}
