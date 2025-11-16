package org.app.votaclaro.Application.Service;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Input.PoliticalPartyUseCase.CreatePoliticalPartyUseCase;
import org.app.votaclaro.Application.Port.Input.PoliticalPartyUseCase.ListPoliticalPartyUseCase;
import org.app.votaclaro.Application.Port.Out.PoliticalPartyRepositoryPort;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Http.Request.PoliticalPartyRequest;
import org.app.votaclaro.Http.Response.PoliticalPartyItem;
import org.app.votaclaro.Http.Response.PoliticalPartyResponse;
import org.app.votaclaro.Mapper.PoliticalPartyMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PoliticalPartyService implements CreatePoliticalPartyUseCase, ListPoliticalPartyUseCase {

    private final PoliticalPartyRepositoryPort politicalPartyRepositoryPort;
    private final PoliticalPartyMapper politicalPartyMapper;

    @Override
    public PoliticalPartyResponse createPoliticalParty(PoliticalPartyRequest politicalPartyRequest, MultipartFile urlLogo, MultipartFile urlListMembers) throws Exception {

        PoliticalParty politicalParty = politicalPartyMapper.politicalPartyToPoliticalPartyRequest(politicalPartyRequest);
        politicalParty = politicalPartyRepositoryPort.save(politicalParty, urlLogo, urlListMembers);
        return politicalPartyMapper.politicalPartyToPoliticalPartyResponse(politicalParty);

    }

    @Override
    public List<PoliticalPartyItem> getList() {
        List<PoliticalParty> politicalParties = politicalPartyRepositoryPort.findAll();
        List<PoliticalPartyItem> politicalPartyItems = politicalParties.stream()
                .map(politicalParty -> new PoliticalPartyItem(
                        politicalParty.getId(),
                        politicalParty.getName(),
                        politicalParty.getUrlLogo(),
                        politicalParty.getIdeology(),
                        politicalParty.getMembers(),
                        politicalParty.getLocation(),
                        politicalParty.getDescription(),
                        politicalParty.getDateFoundation()
                ))
                .collect(Collectors.toList()); // ✅ convertir Stream a List
        return politicalPartyItems; // ✅ devolver la lista creada
    }
}
