package org.example.pg_throughput.repository.impl;

import lombok.RequiredArgsConstructor;
import org.example.pg_throughput.domain.TestEntity;
import org.example.pg_throughput.dto.PayloadDto;
import org.example.pg_throughput.repository.PayloadRepository;
import org.example.pg_throughput.repository.jpa.TestEntityJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PayloadRepositoryImpl implements PayloadRepository {

    private final TestEntityJpaRepository testEntityJpaRepository;

    @Override
    @Transactional
    public String save(PayloadDto d) {
        var identifier = UUID.randomUUID();
        var ent = new TestEntity();
        ent.setPayload(d.getPayload());
        ent.setId(identifier);
        testEntityJpaRepository.save(ent);
        return identifier.toString();
    }

    @Override
    @Transactional(readOnly = true)
    public PayloadDto get(UUID id) {
        var ent = testEntityJpaRepository.findById(id);
        if (ent.isPresent()) {
            var unpacked = ent.get();
            var dto = new PayloadDto();
            dto.setPayload(unpacked.getPayload());
        }
        return null;
    }
}
