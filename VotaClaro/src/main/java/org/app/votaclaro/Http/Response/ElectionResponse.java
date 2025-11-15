package org.app.votaclaro.Http.Response;

import java.util.UUID;

public record ElectionResponse(
        UUID id,
        String electionDate,
        UUID nomineeId
) {}
