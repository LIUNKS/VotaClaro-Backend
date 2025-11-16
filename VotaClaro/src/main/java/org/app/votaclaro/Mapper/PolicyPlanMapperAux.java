package org.app.votaclaro.Mapper;

import org.app.votaclaro.Domain.Model.PolicyPlan;
import org.app.votaclaro.Http.Response.PolicyPlanResponse;

public class PolicyPlanMapperAux {

    public static PolicyPlanResponse policyPlanToPolicyPlanResponse(PolicyPlan policyPlan){
        return new PolicyPlanResponse(
                policyPlan.getId(),
                policyPlan.getUrlPdf(),
                policyPlan.getPoliticalParty().getId()
        );
    };


}
