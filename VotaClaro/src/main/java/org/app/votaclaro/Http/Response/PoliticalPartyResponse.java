package org.app.votaclaro.Http.Response;

import java.util.UUID;

public record PoliticalPartyResponse(
        UUID id,
        String name,
        String urlLogo,
        String ideology,
        PolicyPlanResponse policyPlan
) {}
