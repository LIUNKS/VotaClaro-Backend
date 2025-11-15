package org.app.votaclaro.Application.Port.Input.PoliticalPartyUseCase;

import org.app.votaclaro.Http.Request.PoliticalPartyRequest;
import org.app.votaclaro.Http.Response.PoliticalPartyResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CreatePoliticalPartyUseCase {
    PoliticalPartyResponse createPoliticalParty(PoliticalPartyRequest politicalPartyRequest, MultipartFile urlLogo, MultipartFile urlListMembers) throws Exception;
}
