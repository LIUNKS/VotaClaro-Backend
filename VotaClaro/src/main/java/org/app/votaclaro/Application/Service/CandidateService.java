package org.app.votaclaro.Application.Service;

import org.app.votaclaro.Application.Port.Input.CandidateUseCase.CreateCandidateUseCase;
import org.app.votaclaro.Http.Request.CandidateRequest;
import org.app.votaclaro.Http.Response.CandidateResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CandidateService implements CreateCandidateUseCase {

    @Override
    public CandidateResponse createCandidate(CandidateRequest candidateRequest, MultipartFile urlCv) {
        return null;
    }

}