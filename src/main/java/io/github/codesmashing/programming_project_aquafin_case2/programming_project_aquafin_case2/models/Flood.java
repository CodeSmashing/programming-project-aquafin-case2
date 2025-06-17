package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.converters.YearConverter;
import io.micrometer.common.lang.Nullable;

@Entity
@Table(name = "overstromingsgevaren")
public class Flood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jaar")
    @Convert(converter = YearConverter.class)
    private Year year;

    @Nullable
    @OneToOne
    @JoinColumn(name = "winter_id", referencedColumnName = "id")
    @JsonManagedReference
    private Season winter;

    @Nullable
    @OneToOne
    @JoinColumn(name = "lente_id", referencedColumnName = "id")
    @JsonManagedReference
    private Season spring;

    @Nullable
    @OneToOne
    @JoinColumn(name = "zomer_id", referencedColumnName = "id")
    @JsonManagedReference
    private Season summer;

    @Nullable
    @OneToOne
    @JoinColumn(name = "herfst_id", referencedColumnName = "id")
    @JsonManagedReference
    private Season fall;

    @NotNull(message = "Guide value cannot be null")
    @Column(name = "richtwaarde")
    @Max(value = 100, message = "Guide value cannot exceed 100")
    @Min(value = 0, message = "Guide value cannot be less than 0")
    private Float guideValue;

    public Flood() {
    }

    public Flood(Year year, Season winter, Season spring, Season summer, Season fall,
            @NotNull(message = "Guide value cannot be null") Float guideValue) {
        this.year = year;
        this.winter = winter;
        this.spring = spring;
        this.summer = summer;
        this.fall = fall;
        this.guideValue = guideValue;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Season getWinter() {
        return winter;
    }

    public void setWinter(Season winter) {
        this.winter = winter;
    }

    public Season getSpring() {
        return spring;
    }

    public void setSpring(Season spring) {
        this.spring = spring;
    }

    public Season getSummer() {
        return summer;
    }

    public void setSummer(Season summer) {
        this.summer = summer;
    }

    public Season getFall() {
        return fall;
    }

    public void setFall(Season fall) {
        this.fall = fall;
    }

    public Float getGuideValue() {
        return guideValue;
    }

    public void setGuideValue(Float guideValue) {
        this.guideValue = guideValue;
    }

    // public boolean isMoreThenGuide() {
    // return this.total != null && this.guideValue != null &&
    // this.total.compareTo(this.guideValue) > 0;
    // }
}
