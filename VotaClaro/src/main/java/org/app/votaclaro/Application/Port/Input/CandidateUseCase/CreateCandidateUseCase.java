package org.app.votaclaro.Application.Port.Input.CandidateUseCase;

import org.app.votaclaro.Http.Request.CandidateRequest;
import org.app.votaclaro.Http.Response.CandidateResponse;

public interface CreateCandidateUseCase {
    CandidateResponse createCandidate(CandidateRequest candidateRequest);
}
