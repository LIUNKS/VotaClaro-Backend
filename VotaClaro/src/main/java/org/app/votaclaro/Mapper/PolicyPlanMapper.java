package org.app.votaclaro.Mapper;

import org.app.votaclaro.Domain.Model.PolicyPlan;
import org.app.votaclaro.Infrastructure.DB.Entity.PolicyPlanEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PolicyPlanMapper {
    PolicyPlan policyPlanEntityToPolicyPlan(PolicyPlanEntity policyPlanEntity);
}
