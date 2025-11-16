package org.app.votaclaro.Infrastructure.DB.Repository.NomineeRepository;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Out.NomineeRepositoryPort;
import org.app.votaclaro.Domain.Model.Candidate;
import org.app.votaclaro.Domain.Model.Nominee;
import org.app.votaclaro.Http.Request.NomineeRequest;
import org.app.votaclaro.Http.Response.NomineeResponse;
import org.app.votaclaro.Infrastructure.DB.Entity.CandidateEntity;
import org.app.votaclaro.Infrastructure.DB.Entity.NomineeEntity;
import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;
import org.app.votaclaro.Mapper.CandidateMapperAux;
import org.app.votaclaro.Mapper.NomineeMapperAux;
import org.app.votaclaro.Mapper.PoliticalPartyMapperAux;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaNomineeRepositoryAdapter implements NomineeRepositoryPort {

    private final SpringDateNomineeRepository springDateNomineeRepository;

    @Override
    public Nominee save(Nominee nominee) {

        CandidateEntity candidateEntity = CandidateMapperAux.candidateToCandidateEntityId(nominee.getCandidate());
        PoliticalPartyEntity politicalPartyEntity = PoliticalPartyMapperAux.politicalPartyToPoliticalPartyEntity(nominee.getPoliticalParty());

        NomineeEntity nomineeEntity = NomineeMapperAux.NomineeToNomineeEntity(nominee, politicalPartyEntity, candidateEntity);

        nomineeEntity = springDateNomineeRepository.save(nomineeEntity);

        return null;
    }

}
