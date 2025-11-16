package org.app.votaclaro.Application.Service;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Input.PresidentialFormUseCase.CreatePresidentialFormUseCase;
import org.app.votaclaro.Application.Port.Out.PoliticalPartyRepositoryPort;
import org.app.votaclaro.Application.Port.Out.PresidentialFormRepositoryPort;

import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Domain.Model.PresidentialForm;
import org.app.votaclaro.Http.Request.PresidentialFormRequest;
import org.app.votaclaro.Http.Response.PresidentialFormResponse;
import org.app.votaclaro.Mapper.PresidentialFormResponseMapperAux;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PresidentialFormService implements CreatePresidentialFormUseCase {


    private final PresidentialFormRepositoryPort presidentialFormRepositoryPort;
    private final PoliticalPartyRepositoryPort politicalPartyRepositoryPort;

    @Override
    public PresidentialFormResponse createPresidentialForm(PresidentialFormRequest presidentialFormRequest) {
        PoliticalParty politicalParty = politicalPartyRepositoryPort.findById(presidentialFormRequest.political_party_id());
        PresidentialForm presidentialForm = new PresidentialForm(null,null,null,politicalParty);
        presidentialForm = presidentialFormRepositoryPort.save(presidentialForm);
        return PresidentialFormResponseMapperAux.presidentialFormToPresidentialFormResponse(presidentialForm);
    }

}
