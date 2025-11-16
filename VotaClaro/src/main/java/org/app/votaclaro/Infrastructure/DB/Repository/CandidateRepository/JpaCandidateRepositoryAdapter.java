package org.app.votaclaro.Infrastructure.DB.Repository.CandidateRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.app.votaclaro.Application.Port.Out.CandidateRepositoryPort;
import org.app.votaclaro.Application.Service.ServiceFile.IUploadFilesService;
import org.app.votaclaro.Domain.Model.Candidate;
import org.app.votaclaro.Infrastructure.DB.Entity.CandidateEntity;
import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;
import org.app.votaclaro.Infrastructure.DB.Entity.PresidentialFormEntity;
import org.app.votaclaro.Mapper.CandidateMapperAux;
import org.app.votaclaro.Mapper.PoliticalPartyMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JpaCandidateRepositoryAdapter implements CandidateRepositoryPort {

    private final SpringDateCandidateRepository springDateCandidateRepository;
    private final IUploadFilesService iUploadFilesService;
    private final PoliticalPartyMapper politicalPartyMapper;
    @Override
    public Candidate save(Candidate candidate, MultipartFile urlImgPerson) throws Exception {
        log.info("Guardando imagen de Candidato en el servidor...");
        String ImgPerson = iUploadFilesService.handleFileUpload(urlImgPerson);
        PoliticalPartyEntity politicalPartyEntity = politicalPartyMapper.politicalPartyToPoliticalPartyEntity(candidate.getPoliticalParty());
        System.out.println("Id de PoliticalPartyEntity:"+politicalPartyEntity.getId());
        PresidentialFormEntity presidentialFormEntity = new PresidentialFormEntity(candidate.getPresidentialForm().getId(),candidate.getPresidentialForm().getCount(),candidate.getPresidentialForm().getFull(),null);
        System.out.println("Id de PresidentialFormEntity:"+presidentialFormEntity.getId());
        System.out.println("isFull de PresidentialFormEntity:"+presidentialFormEntity.getIsFull());
        CandidateEntity candidateEntity = new CandidateEntity(null,candidate.getDni(),ImgPerson,politicalPartyEntity,presidentialFormEntity);
        candidateEntity = springDateCandidateRepository.save(candidateEntity);
        return CandidateMapperAux.candidateEntityToCandidatoForNull(candidateEntity);
    }

    @Override
    public Candidate findById(UUID id) {
        CandidateEntity candidate = springDateCandidateRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el Candidato con el id: "+id));
        return CandidateMapperAux.candidateEntityToCandidatoForNull(candidate);
    }

}
