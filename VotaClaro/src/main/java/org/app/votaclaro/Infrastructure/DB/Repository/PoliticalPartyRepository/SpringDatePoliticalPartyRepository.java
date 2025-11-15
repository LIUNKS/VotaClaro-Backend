package org.app.votaclaro.Infrastructure.DB.Repository.PoliticalPartyRepository;

import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDatePoliticalPartyRepository extends JpaRepository<PoliticalPartyEntity, UUID> {
}
