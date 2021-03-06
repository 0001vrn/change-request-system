package com.varun.infrastructure.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.varun.domain.AppMetadata;
import com.varun.domain.ChgRequest;
import com.varun.domain.repository.ChgRequestRepository;

@SpringJUnitConfig
@SpringBootTest
@ActiveProfiles("test")
class CassandraDbChgRequestRepositoryTest {

    @Autowired
    private SpringDataCassandraChgRequestRepository cassandraChgRequestRepository;

    @Autowired
    private ChgRequestRepository chgRequestRepository;

    @AfterEach
    void tearDown() {
        cassandraChgRequestRepository.deleteAll();
    }

    @Test
    void shouldFindAll_ThenReturnChgRequest() {
        // Arrange
        var alpha = new AppMetadata("alpha", "1.3.1", "random jira link", "prod-us-west-2", "rolling out new feature");

        var alphaChgRequest = new ChgRequest(UUID.randomUUID(), alpha);
        alphaChgRequest.createChgRequest(alpha);

        // Act
        chgRequestRepository.save(alphaChgRequest);

        // Assert
        assertNotNull(chgRequestRepository.findAll());
    }

    @Test
    void shouldFindById_ThenReturnChgRequest() {
        // Arrange
        var tango = new AppMetadata("tango", "2.3.1", "random jira link", "prod-us-east-1", "rolling out new feature");
        var chgRequest = new ChgRequest(UUID.randomUUID(), tango);
        chgRequest.createChgRequest(tango);

        // Act
        chgRequestRepository.save(chgRequest);
        var mayBeChgRequest = chgRequestRepository.findById(chgRequest.getId());

        // Assert
        mayBeChgRequest.ifPresent(chgRequestFromDao -> assertEquals(chgRequest.getId(), chgRequestFromDao.getId()));
    }
}
