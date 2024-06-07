package org.example.pg_throughput.repository.jpa;

import org.example.pg_throughput.domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestEntityJpaRepository extends JpaRepository<TestEntity, UUID> {

}
