package org.app.votaclaro.Http.Response;

import java.time.LocalDate;
import java.util.UUID;

public record CandidateResponse(
        UUID id,
        String fullName,
        String dni,
        LocalDate birthDate,
        String urlCv,
        PoliticalPartyResponse politicalParty,
        NomineeResponse nominee,
        PresidentialFormResponse presidentialForm
) {}
