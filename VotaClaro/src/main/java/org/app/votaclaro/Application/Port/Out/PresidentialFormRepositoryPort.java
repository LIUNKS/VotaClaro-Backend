package org.app.votaclaro.Application.Port.Out;

import org.app.votaclaro.Domain.Model.PresidentialForm;

import java.util.UUID;

public interface PresidentialFormRepositoryPort {
    PresidentialForm save(PresidentialForm presidentialForm);
    PresidentialForm findById(UUID id);
}
