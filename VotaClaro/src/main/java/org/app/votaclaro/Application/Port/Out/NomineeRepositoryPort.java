package org.app.votaclaro.Application.Port.Out;

import org.app.votaclaro.Http.Request.NomineeRequest;
import org.app.votaclaro.Http.Response.NomineeResponse;

public interface NomineeRepositoryPort {
    NomineeResponse save(NomineeRequest nomineeRequest);
}
