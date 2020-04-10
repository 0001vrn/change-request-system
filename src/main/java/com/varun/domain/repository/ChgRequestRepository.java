package com.varun.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.varun.domain.ChgRequest;

public interface ChgRequestRepository {

    List<ChgRequest> findAll();

    Optional<ChgRequest> findById(UUID id);

    void save(ChgRequest chgRequest);
}
