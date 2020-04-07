package com.baeldung.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.baeldung.domain.repository.ChgRequestRepository;

// TODO: finish all tests
class ChgRequestServiceImplTest {

    private ChgRequestServiceImpl chgRequestService;

    @Mock
    private ChgRequestRepository chgRequestRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        chgRequestService = new ChgRequestServiceImpl(chgRequestRepository);
    }

    @Test
    void findAll() {
    }

    @Test
    void createInvoice() {
    }

    @Test
    void addProduct() {
    }

    @Test
    void deleteProduct() {
    }
}
