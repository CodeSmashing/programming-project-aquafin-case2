package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Region;

public interface RegionDAO extends CrudRepository<Region, Integer> {
	Optional<Region> findByRegionName(String regionName);
}
