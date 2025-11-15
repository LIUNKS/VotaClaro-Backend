package org.app.votaclaro.Infrastructure.DB.Repository.PoliticalPartyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.app.votaclaro.Application.Port.Out.PoliticalPartyRepositoryPort;
import org.app.votaclaro.Application.Service.ServiceFile.IUploadFilesService;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;
import org.app.votaclaro.Mapper.PoliticalPartyMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JpaPoliticalPartyRepositoryAdapter implements PoliticalPartyRepositoryPort {

    private final SpringDatePoliticalPartyRepository springDatePoliticalPartyRepository;
    private final PoliticalPartyMapper politicalPartyMapper;
    private final IUploadFilesService iUploadFilesService;

    @Override
    public PoliticalParty save(PoliticalParty politicalParty, MultipartFile urlLogo, MultipartFile urlListMembers) throws Exception {
        log.info("Guardando archivos de PoliticalParty en el servidor");
        String Logo = iUploadFilesService.handleFileUpload(urlLogo);
        String ListMembers = iUploadFilesService.handleFileUpload(urlListMembers);
        PoliticalPartyEntity politicalPartyEntity = politicalPartyMapper.politicalPartyToPoliticalPartyEntity(politicalParty);
        politicalPartyEntity.setUrlLogo(Logo);
        politicalPartyEntity.setUrlListMembers(ListMembers);
        log.info("Guardando ubicacion de archivos en PoliticalParty: -Logo({}),-ListMembers({})",Logo,ListMembers);
        politicalPartyEntity = springDatePoliticalPartyRepository.save(politicalPartyEntity);
        log.info("Guardando PoliticalParty en BD: {}",politicalPartyEntity.getId());
        return politicalPartyMapper.politicalPartyEntityToPoliticalParty(politicalPartyEntity);
    }

    @Override
    public PoliticalParty findById(UUID id) {
        PoliticalPartyEntity politicalPartyEntity = springDatePoliticalPartyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el PoliticalParty con el id: "+id));
        return politicalPartyMapper.politicalPartyEntityToPoliticalParty(politicalPartyEntity);    }


}
