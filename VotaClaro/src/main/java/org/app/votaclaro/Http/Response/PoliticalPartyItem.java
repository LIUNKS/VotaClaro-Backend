package org.app.votaclaro.Http.Response;

import java.util.UUID;

public record PoliticalPartyItem(
        UUID id,
        String name,
        String urlLogo,
        String ideology,
        String members,
        String location,
        String description,
        String dateFoundation
) {
}
