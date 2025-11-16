package org.app.votaclaro.Application.Port.Out;

import org.app.votaclaro.Domain.Model.PresidentialForm;

public interface PresidentialFormRepositoryPort {
    PresidentialForm save(PresidentialForm presidentialForm);
}
