package org.app.votaclaro.Application.Port.Input;

import org.app.votaclaro.Http.Request.PolicyPlanRequest;
import org.app.votaclaro.Http.Response.PolicyPlanResponse;

public interface CreatePolicyPlanUseCase {
    PolicyPlanResponse createPolicyPlan(PolicyPlanRequest policyPlanRequest);
}
