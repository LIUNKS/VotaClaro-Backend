package org.app.votaclaro.Infrastructure.DB.Repository.ElectionRepository;

import org.app.votaclaro.Infrastructure.DB.Entity.ElectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDateElectionRepository extends JpaRepository<ElectionEntity, UUID> {
}
