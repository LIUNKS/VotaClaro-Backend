package org.app.votaclaro.Application.Port.Input;

import org.app.votaclaro.Http.Request.NomineeRequest;
import org.app.votaclaro.Http.Response.NomineeResponse;

public interface CreateNomineeUseCase {
    NomineeResponse createNominee(NomineeRequest nomineeRequest);
}
