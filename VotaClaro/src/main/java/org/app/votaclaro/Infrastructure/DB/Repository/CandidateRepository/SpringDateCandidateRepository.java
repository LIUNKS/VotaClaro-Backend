package org.app.votaclaro.Infrastructure.DB.Repository.CandidateRepository;

import org.app.votaclaro.Infrastructure.DB.Entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDateCandidateRepository extends JpaRepository<CandidateEntity, UUID> {
}
