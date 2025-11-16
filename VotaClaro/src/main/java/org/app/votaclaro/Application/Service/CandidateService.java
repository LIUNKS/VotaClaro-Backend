package org.app.votaclaro.Application.Service;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Input.CandidateUseCase.CreateCandidateUseCase;
import org.app.votaclaro.Application.Port.Out.CandidateRepositoryPort;
import org.app.votaclaro.Application.Port.Out.PoliticalPartyRepositoryPort;
import org.app.votaclaro.Application.Port.Out.PresidentialFormRepositoryPort;
import org.app.votaclaro.Domain.Model.Candidate;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Domain.Model.PresidentialForm;
import org.app.votaclaro.Http.Request.CandidateRequest;
import org.app.votaclaro.Http.Request.CandidateRequestWithoutForm;
import org.app.votaclaro.Http.Response.CandidateResponse;
import org.app.votaclaro.Mapper.CandidateMapperAux;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CandidateService implements CreateCandidateUseCase {

    private final CandidateRepositoryPort candidateRepositoryPort;
    private final PoliticalPartyRepositoryPort politicalPartyRepositoryPort;
    private final PresidentialFormRepositoryPort presidentialFormRepositoryPort;

    @Override
    public CandidateResponse createCandidate(CandidateRequest candidateRequest, MultipartFile urlImgPerson) throws Exception {
        PoliticalParty politicalParty = politicalPartyRepositoryPort.findById(candidateRequest.politicalPartyId());
        PresidentialForm presidentialForm = presidentialFormRepositoryPort.findById(candidateRequest.presidentialFormId());
        presidentialFormRepositoryPort.findByIdCount(candidateRequest.presidentialFormId());
        Candidate candidate = new Candidate(null,candidateRequest.dni(),politicalParty,presidentialForm,null);
        candidate = candidateRepositoryPort.save(candidate,urlImgPerson);
        return CandidateMapperAux.candidateToCandidateResponse(candidate);
    }
    @Override
    public CandidateResponse createCandidateWithoutPresidentialForm(CandidateRequestWithoutForm candidateRequestWithoutForm, MultipartFile urlImgPerson) throws Exception {
        PoliticalParty politicalParty = politicalPartyRepositoryPort.findById(candidateRequestWithoutForm.politicalPartyId());
        Candidate candidate = new Candidate(null,candidateRequestWithoutForm.dni(),politicalParty,null,null);
        candidate = candidateRepositoryPort.saveWithoutPresidentForm(candidate,urlImgPerson);
        return CandidateMapperAux.candidateToCandidateResponseWithoutForm(candidate);
    }
}