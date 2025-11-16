package org.app.votaclaro.Application.Service;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Input.NomineeUseCase.CreateNomineeUseCase;
import org.app.votaclaro.Application.Port.Out.CandidateRepositoryPort;
import org.app.votaclaro.Application.Port.Out.NomineeRepositoryPort;
import org.app.votaclaro.Application.Port.Out.PoliticalPartyRepositoryPort;
import org.app.votaclaro.Domain.Model.Candidate;
import org.app.votaclaro.Domain.Model.Nominee;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Http.Request.NomineeRequest;
import org.app.votaclaro.Http.Response.NomineeResponse;
import org.app.votaclaro.Mapper.NomineeMapperAux;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NomineeService implements CreateNomineeUseCase {

    private final PoliticalPartyRepositoryPort politicalPartyRepositoryPort;
    private final NomineeRepositoryPort nomineeRepositoryPort;
    private final CandidateRepositoryPort candidateRepositoryPort;

    @Override
    public NomineeResponse createNominee(NomineeRequest nomineeRequest) {

        PoliticalParty politicalParty = politicalPartyRepositoryPort.findById(nomineeRequest.politicalPartyId());
        Candidate candidate = candidateRepositoryPort.findById(nomineeRequest.candidate_id());

        Nominee nominee = NomineeMapperAux.NomineeRequestToNomineeForService(nomineeRequest, politicalParty, candidate);
        nominee = nomineeRepositoryPort.save(nominee);
        return NomineeMapperAux.nomineeTonomineeResponse(nominee);
    }

}
