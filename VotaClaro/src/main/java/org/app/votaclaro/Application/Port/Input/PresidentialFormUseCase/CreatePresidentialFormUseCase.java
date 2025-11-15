package org.app.votaclaro.Application.Port.Input.PresidentialFormUseCase;

import org.app.votaclaro.Http.Request.PresidentialFormRequest;
import org.app.votaclaro.Http.Response.PresidentialFormResponse;

public interface CreatePresidentialFormUseCase {
    PresidentialFormResponse createPresidentialForm(PresidentialFormRequest presidentialFormRequest);
}
