package org.app.votaclaro.Http.Response;

import java.util.UUID;

public record CandidateResponse(
        UUID id,
        String dni,
        String urlImgPerson,
        UUID politicalPartyId,
        UUID presidentialFormId
) {}
