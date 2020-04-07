package com.baeldung.application.controller.changerequest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.application.request.CreateChgRequest;
import com.baeldung.application.response.AppMetaDataResponse;
import com.baeldung.application.response.CreateChgResponse;
import com.baeldung.domain.ChgRequest;
import com.baeldung.domain.service.ChgRequestService;

@RestController
@RequestMapping("/crq")
public class ChgRequestController {

    private final ChgRequestService chgRequestService;

    @Autowired
    public ChgRequestController(ChgRequestService chgRequestService) {
        this.chgRequestService = chgRequestService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AppMetaDataResponse> getAll() {
        return chgRequestService.findAll()
                .stream()
                .map(ChgRequest::appMetaDataResponse)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateChgResponse createInvoice(@RequestBody final CreateChgRequest createChgRequest) {
        final UUID invoiceId = chgRequestService.createChgRequest(createChgRequest.getAppMetadata());

        return new CreateChgResponse(invoiceId);
    }

    @GetMapping(value = "/{id}/begin")
    void transitionBegin(@PathVariable final UUID id) {
        chgRequestService.beginChgRequest(id);
    }

    @GetMapping(value = "/{id}/done")
    void transitionDone(@PathVariable final UUID id) {
        chgRequestService.doneChgRequest(id);
    }

    @GetMapping(value = "/{id}/rollback")
    void transitionRollback(@PathVariable final UUID id) {
        chgRequestService.rollbackChgRequest(id);
    }

    @GetMapping(value = "/{id}")
    AppMetaDataResponse displayMetadata(@PathVariable final UUID id) {
        return chgRequestService.findById(id).appMetaDataResponse();
    }
}
