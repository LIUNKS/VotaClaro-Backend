package org.app.votaclaro.Http.Response;

import java.util.UUID;

public record CandidateResponse(
        UUID id,
        String dni,
        UUID politicalPartyId,
        UUID presidentialFormId
) {}
