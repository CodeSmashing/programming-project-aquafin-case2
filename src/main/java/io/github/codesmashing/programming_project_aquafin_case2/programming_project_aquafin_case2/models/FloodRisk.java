package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "flood_risks")
public class FloodRisk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(nullable = false)
    private Integer floodRiskId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "region_id", nullable = false)
    @JsonManagedReference
    private Region region;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "precipitation_data_id", nullable = false)
    @JsonManagedReference
    private PrecipitationData precipitationData;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOccurence;

    @NotNull
    @Column(nullable = false)
    private Integer riskLevel;

    public FloodRisk() {
    }

    public FloodRisk(
            Region region,
            PrecipitationData precipitationData,
            LocalDate dateOccurence,
            Integer riskLevel) {
        this.region = region;
        this.precipitationData = precipitationData;
        this.dateOccurence = dateOccurence;
        this.riskLevel = riskLevel;
    }

    public Integer getFloodRiskId() {
        return floodRiskId;
    }

    public void setFloodRiskId(Integer floodRiskId) {
        this.floodRiskId = floodRiskId;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public PrecipitationData getPrecipitationData() {
        return precipitationData;
    }

    public void setPrecipitationData(PrecipitationData precipitationData) {
        this.precipitationData = precipitationData;
    }

    public LocalDate getDateOccurence() {
        return dateOccurence;
    }

    public void setDateOccurence(LocalDate dateOccurence) {
        this.dateOccurence = dateOccurence;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }
}
