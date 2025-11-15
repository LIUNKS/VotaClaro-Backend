package org.app.votaclaro.Application.Service;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Input.PolicyPlanUseCase.CreatePolicyPlanUseCase;
import org.app.votaclaro.Application.Port.Out.PolicyPlanRepositoryPort;
import org.app.votaclaro.Application.Port.Out.PoliticalPartyRepositoryPort;
import org.app.votaclaro.Domain.Model.PolicyPlan;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Http.Request.PolicyPlanRequest;
import org.app.votaclaro.Http.Response.PolicyPlanResponse;
import org.app.votaclaro.Mapper.PolicyPlanMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PolicyPlanService implements CreatePolicyPlanUseCase {

    private final PolicyPlanMapper policyPlanMapper;
    private final PolicyPlanRepositoryPort policyPlanRepositoryPort;
    private final PoliticalPartyRepositoryPort politicalPartyRepositoryPort;
    @Override
    public PolicyPlanResponse createPolicyPlan(PolicyPlanRequest policyPlanRequest, MultipartFile urlPdf) throws Exception {

        PoliticalParty politicalParty = politicalPartyRepositoryPort.findById(policyPlanRequest.political_party_id());

        PolicyPlan policyPlan = new PolicyPlan(politicalParty);

        policyPlanRepositoryPort.save(policyPlan, urlPdf);

        return null;
    }

}
