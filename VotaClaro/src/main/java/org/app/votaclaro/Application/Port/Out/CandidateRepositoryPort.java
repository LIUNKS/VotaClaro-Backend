package org.app.votaclaro.Application.Port.Out;

import org.app.votaclaro.Domain.Model.Candidate;
import org.springframework.web.multipart.MultipartFile;

public interface CandidateRepositoryPort {
    Candidate save(Candidate candidate, MultipartFile urlCv);
}
