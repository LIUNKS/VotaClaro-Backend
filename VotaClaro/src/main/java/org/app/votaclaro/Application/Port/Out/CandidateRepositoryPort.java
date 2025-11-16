package org.app.votaclaro.Application.Port.Out;

import org.app.votaclaro.Domain.Model.Candidate;
import org.app.votaclaro.Dto.CandidateUrlImg;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface CandidateRepositoryPort {
    Candidate save(Candidate candidate, MultipartFile urlImgPerson) throws Exception;
    Candidate saveWithoutPresidentForm(Candidate candidate, MultipartFile urlImgPerson) throws Exception;
    Candidate findById(UUID id);
    List<CandidateUrlImg>listUrlCandidates();
}
