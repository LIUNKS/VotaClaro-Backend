package org.app.votaclaro.Mapper;

import org.app.votaclaro.Domain.Model.Candidate;
import org.app.votaclaro.Domain.Model.Nominee;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Http.Request.NomineeRequest;
import org.app.votaclaro.Http.Response.NomineeResponse;
import org.app.votaclaro.Infrastructure.DB.Entity.CandidateEntity;
import org.app.votaclaro.Infrastructure.DB.Entity.NomineeEntity;
import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;

public class NomineeMapperAux {
    public static Nominee NomineeRequestToNomineeForService(NomineeRequest nomineeRequest, PoliticalParty politicalParty, Candidate candidate){
        return new Nominee(
                null,
                nomineeRequest.position(),
                nomineeRequest.status(),
                nomineeRequest.viceNum(),
                new PoliticalParty(nomineeRequest.politicalPartyId(),null,null,null,null,null,null,null,null),
                new Candidate(nomineeRequest.candidate_id(),null,null,null,null)
        );
    }
    public static NomineeEntity NomineeToNomineeEntity(Nominee nominee, PoliticalPartyEntity politicalParty, CandidateEntity candidateEntity){
        return new NomineeEntity(
                null,
                nominee.getPosition(),
                nominee.getStatus(),
                nominee.getViceNum(),
                politicalParty,
                candidateEntity
        );
    }
    public static Nominee nomineeEntityToNominee(NomineeEntity nomineeEntity){
        return new Nominee(
                nomineeEntity.getId(),
                nomineeEntity.getPosition(),
                nomineeEntity.getStatus(),
                nomineeEntity.getViceNum(),
                new PoliticalParty(nomineeEntity.getPoliticalParty().getId(),null,null,null,null,null,null,null,null),
                new Candidate(nomineeEntity.getCandidate().getId(),null,null,null,null)
        );
    }
    public static NomineeResponse nomineeTonomineeResponse(Nominee nominee){
        return new NomineeResponse(
                nominee.getId(),
                nominee.getPosition(),
                nominee.getStatus(),
                nominee.getViceNum(),
                nominee.getPoliticalParty().getId(),
                nominee.getCandidate().getId()
        );
    }
}
