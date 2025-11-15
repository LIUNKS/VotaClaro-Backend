package org.app.votaclaro.Http.Request;

import java.util.UUID;

public record PolicyPlanRequest(
        UUID political_party_id
) {}
