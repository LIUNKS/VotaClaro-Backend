package org.app.votaclaro.Infrastructure.DB.Repository.PresidentialFromRepository;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Out.PresidentialFormRepositoryPort;
import org.app.votaclaro.Domain.Model.PresidentialForm;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaPresidentialFromRepositoryAdapter implements PresidentialFormRepositoryPort {

    private final SpringDatePresidentialFormRepository springDatePresidentialFormRepository;

    @Override
    public PresidentialForm save(PresidentialForm presidentialForm) {
        return null;
    }

}
