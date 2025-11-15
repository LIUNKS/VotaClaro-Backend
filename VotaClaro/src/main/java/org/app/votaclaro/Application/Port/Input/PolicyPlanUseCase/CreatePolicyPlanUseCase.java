package org.app.votaclaro.Application.Port.Input.PolicyPlanUseCase;

import org.app.votaclaro.Http.Request.PolicyPlanRequest;
import org.app.votaclaro.Http.Response.PolicyPlanResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CreatePolicyPlanUseCase {
    PolicyPlanResponse createPolicyPlan(PolicyPlanRequest policyPlanRequest, MultipartFile urlPdf);
}
