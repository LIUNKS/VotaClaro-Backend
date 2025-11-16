package org.app.votaclaro.Http.Request;

import java.util.UUID;

public record PresidentialFormRequest(
        UUID political_party_id
) {}
