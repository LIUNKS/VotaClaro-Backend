package org.app.votaclaro.Http.Response;

import java.time.LocalDate;
import java.util.UUID;

public record ElectionResponse(
        UUID id,
        LocalDate electionDate,
        NomineeResponse nominee
) {}
