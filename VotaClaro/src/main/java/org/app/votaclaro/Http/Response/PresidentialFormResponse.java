package org.app.votaclaro.Http.Response;

import java.util.UUID;

public record PresidentialFormResponse(
        UUID id,
        Integer count,
        Boolean isFull,
        UUID political_party_id
) {}
