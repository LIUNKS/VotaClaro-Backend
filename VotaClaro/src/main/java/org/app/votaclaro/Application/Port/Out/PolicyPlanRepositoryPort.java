package org.app.votaclaro.Application.Port.Out;

import org.app.votaclaro.Domain.Model.PolicyPlan;
import org.springframework.web.multipart.MultipartFile;

public interface PolicyPlanRepositoryPort {
    PolicyPlan save(PolicyPlan policyPlan, MultipartFile urlPdf) throws Exception;
}
