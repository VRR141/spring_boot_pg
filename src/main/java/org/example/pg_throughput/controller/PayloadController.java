package org.example.pg_throughput.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.pg_throughput.dto.PayloadDto;
import org.example.pg_throughput.repository.PayloadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payload")
@Slf4j
public class PayloadController {
    private final PayloadRepository repository;

    @PostMapping
    public ResponseEntity<String> post(@RequestBody PayloadDto payload) {
        return ResponseEntity.ok(repository.save(payload));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayloadDto> get(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(repository.get(id));
    }
}
