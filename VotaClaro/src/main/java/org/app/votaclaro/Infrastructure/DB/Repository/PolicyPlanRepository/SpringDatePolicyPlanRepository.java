package org.app.votaclaro.Infrastructure.DB.Repository.PolicyPlanRepository;

import org.app.votaclaro.Infrastructure.DB.Entity.PolicyPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDatePolicyPlanRepository extends JpaRepository<PolicyPlanEntity, UUID> {
}
