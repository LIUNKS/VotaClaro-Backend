package org.app.votaclaro.Http.Request;

import java.time.LocalDate;
import java.util.UUID;

public record CandidateRequest(
        String dni,
        UUID politicalPartyId,
        UUID presidentialFormId
) {}
