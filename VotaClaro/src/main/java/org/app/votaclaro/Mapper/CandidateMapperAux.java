package org.app.votaclaro.Mapper;

import org.app.votaclaro.Domain.Model.Candidate;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Domain.Model.PresidentialForm;
import org.app.votaclaro.Http.Response.CandidateResponse;
import org.app.votaclaro.Infrastructure.DB.Entity.CandidateEntity;

public class CandidateMapperAux {
    public static Candidate candidateEntityToCandidatoForNull(CandidateEntity candidateEntity){
        return new Candidate(
                candidateEntity.getId(),
                candidateEntity.getDni(),
                new PoliticalParty(candidateEntity.getPoliticalParty().getId(),null,null,null,null,null,null,null,null),
                new PresidentialForm(candidateEntity.getPresidentialForm().getId(),null,null,null),
                candidateEntity.getUrlImgPerson()
        );
    }
    public static CandidateResponse candidateToCandidateResponse(Candidate candidate){
        return new CandidateResponse(candidate.getId(),candidate.getDni(),candidate.getUrlImgPerson(),candidate.getPoliticalParty().getId(),candidate.getPresidentialForm().getId());
    }
    public static CandidateResponse candidateToCandidateResponseWithoutForm(Candidate candidate){
        return new CandidateResponse(candidate.getId(),candidate.getDni(),candidate.getUrlImgPerson(),candidate.getPoliticalParty().getId(),null);
    }
    public static CandidateEntity candidateToCandidateEntityId(Candidate candidate){
        return new CandidateEntity(candidate.getId(),null,null,null,null);
    }
}
