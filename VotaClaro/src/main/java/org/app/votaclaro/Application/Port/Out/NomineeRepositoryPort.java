package org.app.votaclaro.Application.Port.Out;

import org.app.votaclaro.Domain.Model.Nominee;
import org.app.votaclaro.Http.Request.NomineeRequest;
import org.app.votaclaro.Http.Response.NomineeResponse;

public interface NomineeRepositoryPort {
    Nominee save(Nominee nominee);
}
