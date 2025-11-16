package org.app.votaclaro.Infrastructure.DB.Repository.NomineeRepository;

import org.app.votaclaro.Application.Port.Out.NomineeRepositoryPort;
import org.app.votaclaro.Http.Request.NomineeRequest;
import org.app.votaclaro.Http.Response.NomineeResponse;

public class JpaNomineeRepositoryAdapter implements NomineeRepositoryPort {

    @Override
    public NomineeResponse save(NomineeRequest nomineeRequest) {
        return null;
    }

}
