package org.app.votaclaro.Infrastructure.DB.Repository.PolicyPlanRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.app.votaclaro.Application.Port.Out.PolicyPlanRepositoryPort;
import org.app.votaclaro.Application.Service.ServiceFile.IUploadFilesService;
import org.app.votaclaro.Domain.Model.PolicyPlan;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Infrastructure.DB.Entity.PolicyPlanEntity;
import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;
import org.app.votaclaro.Mapper.PolicyPlanMapper;
import org.app.votaclaro.Mapper.PoliticalPartyMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JpaPolicyPlanRepositoryAdapter implements PolicyPlanRepositoryPort {

    private final PolicyPlanMapper policyPlanMapper;
    private final IUploadFilesService iUploadFilesService;
    private final SpringDatePolicyPlanRepository springDatePolicyPlanRepository;
    private final PoliticalPartyMapper politicalPartyMapper;


    @Override
    public PolicyPlan save(PolicyPlan policyPlan, MultipartFile urlPdf) throws Exception {

        PoliticalPartyEntity politicalPartyEntity = politicalPartyMapper.politicalPartyToPoliticalPartyEntity(policyPlan.getPoliticalParty());

        log.info("Guardando el archivo pdf del PolicyPlan en el servidor...");

        String Pdf = iUploadFilesService.handleFileUpload(urlPdf);

        PolicyPlanEntity policyPlanEntity = new PolicyPlanEntity(Pdf, politicalPartyEntity);

        log.info("Guardando PolicyPlan en BD: {}",policyPlanEntity.getId());

        policyPlanEntity = springDatePolicyPlanRepository.save(policyPlanEntity);

        PolicyPlan policyPlan1 = policyPlanMapper.policyPlanEntityToPolicyPlan(policyPlanEntity);

        PoliticalPartyEntity politicalParty = policyPlanEntity.getPoliticalParty();

        PoliticalParty politicalParty1 = politicalPartyMapper.politicalPartyEntityToPoliticalParty(politicalParty);

        policyPlan1.setPoliticalParty(politicalParty1);

        return policyPlan1;
    }

}
