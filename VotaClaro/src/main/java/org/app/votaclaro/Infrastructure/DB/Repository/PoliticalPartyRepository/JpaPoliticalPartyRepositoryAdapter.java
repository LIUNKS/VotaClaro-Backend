package org.app.votaclaro.Infrastructure.DB.Repository.PoliticalPartyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.app.votaclaro.Application.Port.Out.PoliticalPartyRepositoryPort;
import org.app.votaclaro.Application.Service.ServiceFile.IUploadFilesService;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Dto.PoliticalPartySavePersistence;
import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;
import org.app.votaclaro.Mapper.PoliticalPartyMapper;
import org.app.votaclaro.Mapper.PoliticalPartyMapperAux;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JpaPoliticalPartyRepositoryAdapter implements PoliticalPartyRepositoryPort {

    private final SpringDatePoliticalPartyRepository springDatePoliticalPartyRepository;
    private final PoliticalPartyMapper politicalPartyMapper;
    private final IUploadFilesService iUploadFilesService;

    @Override
    public PoliticalParty save(PoliticalParty politicalParty, MultipartFile urlLogo, MultipartFile urlListMembers) throws Exception {

        if(springDatePoliticalPartyRepository.existsPoliticalPartyEntitiesByName(politicalParty.getName())){
            throw new RuntimeException("Ya existe un PoliticalParty con el nombre: "+politicalParty.getName());
        }

        log.info("Guardando archivos de PoliticalParty en el servidor");

        String Logo = iUploadFilesService.handleFileUpload(urlLogo);

        String ListMembers = iUploadFilesService.handleFileUpload(urlListMembers);

        PoliticalPartySavePersistence politicalPartySavePersistence = politicalPartyMapper.politicalPartyToPoliticalPartySavePersistence(politicalParty);

        System.out.println("Datos del PoliticalPartySavePersistence:\n");
        System.out.println(politicalPartySavePersistence.name());
        System.out.println(politicalPartySavePersistence.ideology());
        System.out.println(politicalPartySavePersistence.description());
        System.out.println(politicalPartySavePersistence.location());
        System.out.println(politicalPartySavePersistence.dateFoundation());

        PoliticalPartyEntity politicalPartyEntity = PoliticalPartyMapperAux.politicalPartySavePersistenceToPoliticalPartyEntity(politicalPartySavePersistence); //No guarda los datos

        politicalPartyEntity.setUrlLogo(Logo);
        politicalPartyEntity.setUrlListMembers(ListMembers);

        System.out.println("Datos del PoliticalPartyEntity:\n");
        System.out.println(politicalPartyEntity.getName());
        System.out.println(politicalPartyEntity.getIdeology());
        System.out.println(politicalPartyEntity.getUrlLogo());
        System.out.println(politicalPartyEntity.getUrlListMembers());
        System.out.println(politicalPartyEntity.getDescription());
        System.out.println(politicalPartyEntity.getLocation());
        System.out.println(politicalPartyEntity.getDateFoundation());

        log.info("Guardando ubicacion de archivos en PoliticalParty: -Logo({}),-ListMembers({})",Logo,ListMembers);

        politicalPartyEntity = springDatePoliticalPartyRepository.save(politicalPartyEntity);

        log.info("Guardando PoliticalParty en BD: {}",politicalPartyEntity.getId());

        return politicalPartyMapper.politicalPartyEntityToPoliticalParty(politicalPartyEntity);
    }

    @Override
    public List<PoliticalParty> findAll() {
        List<PoliticalPartyEntity>politicalPartyEntities = springDatePoliticalPartyRepository.findAll();
        List<PoliticalParty> politicalPartyList = politicalPartyEntities.stream().map(politicalPartyMapper::politicalPartyEntityToPoliticalParty).collect(Collectors.toList());
        return politicalPartyList;
    }

    @Override
    public PoliticalParty findById(UUID id) {
        PoliticalPartyEntity politicalPartyEntity = springDatePoliticalPartyRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el PoliticalParty con el id: "+id));
        return politicalPartyMapper.politicalPartyEntityToPoliticalParty(politicalPartyEntity);    }


}
