package org.app.votaclaro.Http.Request;

import java.util.UUID;

public record PoliticalPartyRequest(
        String name,
        String urlLogo,
        String ideology,
        UUID policyPlanId
) {}
