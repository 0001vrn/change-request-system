package com.varun.domain.service;

import java.util.List;
import java.util.UUID;

import com.varun.domain.AppMetadata;
import com.varun.domain.ChgRequest;

public interface ChgRequestService {
    List<ChgRequest> findAll();

    ChgRequest findById(UUID id);

    UUID createChgRequest(AppMetadata appMetadata);

    void beginChgRequest(UUID id);

    void doneChgRequest(UUID id);

    void rollbackChgRequest(UUID id);
}
