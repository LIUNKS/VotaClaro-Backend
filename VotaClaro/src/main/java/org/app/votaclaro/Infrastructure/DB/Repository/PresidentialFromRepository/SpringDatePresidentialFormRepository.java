package org.app.votaclaro.Infrastructure.DB.Repository.PresidentialFromRepository;

import org.app.votaclaro.Infrastructure.DB.Entity.PresidentialFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDatePresidentialFormRepository extends JpaRepository<PresidentialFormEntity, UUID> {
}
