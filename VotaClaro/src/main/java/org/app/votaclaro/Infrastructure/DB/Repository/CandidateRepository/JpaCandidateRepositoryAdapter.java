package org.app.votaclaro.Infrastructure.DB.Repository.CandidateRepository;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Out.CandidateRepositoryPort;
import org.app.votaclaro.Domain.Model.Candidate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
@RequiredArgsConstructor
public class JpaCandidateRepositoryAdapter implements CandidateRepositoryPort {

    private final SpringDateCandidateRepository springDateCandidateRepository;

    @Override
    public Candidate save(Candidate candidate, MultipartFile urlImgPerson) {



        return null;
    }

}
