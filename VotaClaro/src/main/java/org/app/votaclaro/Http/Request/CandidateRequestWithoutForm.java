package org.app.votaclaro.Http.Request;

import java.util.UUID;

public record CandidateRequestWithoutForm(
        String dni,
        UUID politicalPartyId
) {
}
