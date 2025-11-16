package org.app.votaclaro.Mapper;

import org.app.votaclaro.Domain.Model.Candidate;
import org.app.votaclaro.Domain.Model.Nominee;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Http.Request.NomineeRequest;

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
}
