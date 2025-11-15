package org.app.votaclaro.Application.Port.Input.PoliticalPartyUseCase;

import org.app.votaclaro.Http.Request.PoliticalPartyRequest;
import org.app.votaclaro.Http.Response.PoliticalPartyResponse;

public interface CreatePoliticalPartyUseCase {
    PoliticalPartyResponse createPoliticalParty(PoliticalPartyRequest politicalPartyRequest);
}
