package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.PrecipitationData;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Region;

public interface PrecipitationDataDAO extends CrudRepository<PrecipitationData, Integer> {
	Optional<PrecipitationData> findByRegionAndDateOccurence(Region region, LocalDate dateOccurence);
}
