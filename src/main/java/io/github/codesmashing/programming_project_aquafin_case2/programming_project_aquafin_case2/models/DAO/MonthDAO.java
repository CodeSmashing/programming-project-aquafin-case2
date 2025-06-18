package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Flood;
import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Month;

public interface MonthDAO extends CrudRepository<Month, Integer> {
	Optional<Month> findByDangerIdAndName(Flood dangerId, String name);
}
