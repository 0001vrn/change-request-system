package com.baeldung.application.request;

import javax.validation.constraints.NotNull;

import com.baeldung.domain.AppMetadata;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AddInvoiceRequest {
    @NotNull
    private AppMetadata appMetadata;

    @JsonCreator
    public AddInvoiceRequest(@JsonProperty("product") final AppMetadata appMetadata) {
        this.appMetadata = appMetadata;
    }
}
