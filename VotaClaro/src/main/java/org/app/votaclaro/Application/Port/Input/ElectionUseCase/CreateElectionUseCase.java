package org.app.votaclaro.Application.Port.Input.ElectionUseCase;

import org.app.votaclaro.Http.Request.ElectionRequest;
import org.app.votaclaro.Http.Response.ElectionResponse;

public interface CreateElectionUseCase {
    ElectionResponse createElection(ElectionRequest electionRequest);
}
