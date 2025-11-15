package org.app.votaclaro.Application.Service;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Input.PoliticalPartyUseCase.CreatePoliticalPartyUseCase;
import org.app.votaclaro.Application.Port.Out.PoliticalPartyRepositoryPort;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Http.Request.PoliticalPartyRequest;
import org.app.votaclaro.Http.Response.PoliticalPartyResponse;
import org.app.votaclaro.Mapper.PoliticalPartyMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PoliticalPartyService implements CreatePoliticalPartyUseCase {

    private final PoliticalPartyRepositoryPort politicalPartyRepositoryPort;
    private final PoliticalPartyMapper politicalPartyMapper;

    @Override
    public PoliticalPartyResponse createPoliticalParty(PoliticalPartyRequest politicalPartyRequest, MultipartFile urlLogo, MultipartFile urlListMembers) throws Exception {
        PoliticalParty politicalParty = politicalPartyMapper.politicalPartyToPoliticalPartyRequest(politicalPartyRequest);
        politicalParty = politicalPartyRepositoryPort.save(politicalParty, urlLogo, urlListMembers);
        return politicalPartyMapper.politicalPartyToPoliticalPartyResponse(politicalParty);
    }

}
