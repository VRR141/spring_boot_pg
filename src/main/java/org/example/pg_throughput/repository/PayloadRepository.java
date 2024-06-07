package org.example.pg_throughput.repository;

import org.example.pg_throughput.dto.PayloadDto;

import java.util.UUID;

public interface PayloadRepository {
    String save(PayloadDto d);
    PayloadDto get(UUID id);
}
