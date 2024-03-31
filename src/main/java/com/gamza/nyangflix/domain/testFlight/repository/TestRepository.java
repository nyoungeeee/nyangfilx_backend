package com.gamza.nyangflix.domain.testFlight.repository;

import com.gamza.nyangflix.domain.testFlight.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
