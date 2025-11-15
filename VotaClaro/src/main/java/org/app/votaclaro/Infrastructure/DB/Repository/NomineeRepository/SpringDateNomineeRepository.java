package org.app.votaclaro.Infrastructure.DB.Repository.NomineeRepository;

import org.app.votaclaro.Infrastructure.DB.Entity.NomineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDateNomineeRepository extends JpaRepository<NomineeEntity, UUID> {
}
