package com.varun.application.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.varun.domain.AppMetadata;
import lombok.Getter;

@Getter
public class CreateChgRequest {
    @NotNull
    private AppMetadata appMetadata;

    @JsonCreator
    public CreateChgRequest(@JsonProperty("appMetadata") @NotNull final AppMetadata appMetadata) {
        this.appMetadata = appMetadata;
    }
}
