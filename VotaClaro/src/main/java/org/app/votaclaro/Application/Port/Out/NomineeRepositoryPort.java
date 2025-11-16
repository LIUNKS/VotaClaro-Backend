package org.app.votaclaro.Application.Port.Out;

import org.app.votaclaro.Domain.Model.Nominee;

public interface NomineeRepositoryPort {
    Nominee save(Nominee nominee);
}
