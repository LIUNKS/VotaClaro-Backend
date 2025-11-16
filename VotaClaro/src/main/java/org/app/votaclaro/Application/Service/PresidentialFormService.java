package org.app.votaclaro.Application.Service;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Input.PresidentialFormUseCase.CreatePresidentialFormUseCase;
import org.app.votaclaro.Application.Port.Out.PresidentialFormRepositoryPort;
import org.app.votaclaro.Http.Request.PresidentialFormRequest;
import org.app.votaclaro.Http.Response.PresidentialFormResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PresidentialFormService implements CreatePresidentialFormUseCase {


    private final PresidentialFormRepositoryPort presidentialFormRepositoryPort;

    private final PoliticalPartyService politicalPartyService;

    @Override
    public PresidentialFormResponse createPresidentialForm(PresidentialFormRequest presidentialFormRequest) {



        return null;
    }

}
