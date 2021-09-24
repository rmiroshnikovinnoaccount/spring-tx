package com.example.springtx.repository;

import com.example.springtx.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DsMigrationRepository extends CrudRepository<Test, Long> {
}
