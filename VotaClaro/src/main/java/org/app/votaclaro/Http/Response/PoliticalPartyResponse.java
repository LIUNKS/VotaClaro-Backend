package org.app.votaclaro.Http.Response;

import java.util.UUID;

public record PoliticalPartyResponse(
        UUID id,
        String name,
        String urlLogo,
        String ideology,
        String urlListMembers,
        String members,
        String location,
        String description,
        String dateFoundation
) {}
