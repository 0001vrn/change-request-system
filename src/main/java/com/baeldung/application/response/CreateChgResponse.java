package com.baeldung.application.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateChgResponse {
    private final UUID id;
}
