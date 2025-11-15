package org.app.votaclaro.Http.Response;

import java.util.UUID;

public record PolicyPlanResponse(
        UUID id,
        String urlPdf,
        UUID political_party_id
) {}
