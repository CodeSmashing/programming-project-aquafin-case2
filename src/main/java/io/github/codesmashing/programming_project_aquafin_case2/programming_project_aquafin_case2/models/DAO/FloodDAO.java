package io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.DAO;

import java.time.Year;

import org.springframework.data.repository.CrudRepository;

import io.github.codesmashing.programming_project_aquafin_case2.programming_project_aquafin_case2.models.Flood;

public interface FloodDAO extends CrudRepository<Flood, Year> {
}
