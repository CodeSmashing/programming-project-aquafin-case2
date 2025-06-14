package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO;

import java.time.Year;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Rainfall;

public interface RainfallDAO extends CrudRepository<Rainfall, Year> {
	@Query(value = "SELECT GREATEST(MAX(neerslag_jan), MAX(neerslag_feb), MAX(neerslag_mrt), MAX(neerslag_apr), MAX(neerslag_mei), MAX(neerslag_jun), MAX(neerslag_jul), MAX(neerslag_aug), MAX(neerslag_sep), MAX(neerslag_okt), MAX(neerslag_nov), MAX(neerslag_dec)) AS LargestRainfall FROM jaarlijkseneerslagdata", nativeQuery = true)
	Integer findLargest();

	@Query(value = "SELECT * FROM jaarlijkseneerslagdata ORDER BY jaar DESC LIMIT 0, 1", nativeQuery = true)
	Rainfall findYoungest();
}
