package org.app.votaclaro.Http.Request;

import java.util.UUID;

public record ElectionRequest(
        String electionDate, UUID nomineeId
) {
}

