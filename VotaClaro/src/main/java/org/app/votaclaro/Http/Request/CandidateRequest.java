package org.app.votaclaro.Http.Request;

import java.time.LocalDate;
import java.util.UUID;

public record CandidateRequest(
        String fullName,
        String dni,
        LocalDate birthDate,
        UUID politicalPartyId,
        UUID presidentialFormId
) {}
