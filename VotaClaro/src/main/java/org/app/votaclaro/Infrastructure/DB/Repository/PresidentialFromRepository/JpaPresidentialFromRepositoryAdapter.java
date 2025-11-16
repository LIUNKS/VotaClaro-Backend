package org.app.votaclaro.Infrastructure.DB.Repository.PresidentialFromRepository;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Application.Port.Out.PresidentialFormRepositoryPort;
import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Domain.Model.PresidentialForm;
import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;
import org.app.votaclaro.Infrastructure.DB.Entity.PresidentialFormEntity;
import org.app.votaclaro.Mapper.PoliticalPartyMapper;
import org.app.votaclaro.Mapper.PresidentialFormResponseMapperAux;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaPresidentialFromRepositoryAdapter implements PresidentialFormRepositoryPort {

    private final SpringDatePresidentialFormRepository springDatePresidentialFormRepository;
    private final PoliticalPartyMapper politicalPartyMapper;


    @Override
    public PresidentialForm save(PresidentialForm presidentialForm) {

        PoliticalPartyEntity politicalPartyEntity = politicalPartyMapper.politicalPartyToPoliticalPartyEntity(presidentialForm.getPoliticalParty());
        PresidentialFormEntity presidentialFormEntity = new PresidentialFormEntity(null, 1,false,politicalPartyEntity);
        presidentialFormEntity = springDatePresidentialFormRepository.save(presidentialFormEntity);

        PoliticalParty politicalParty = politicalPartyMapper.politicalPartyEntityToPoliticalParty(politicalPartyEntity);

        PresidentialForm presidentialForm1 = PresidentialFormResponseMapperAux.presidentialFormToPresidentialFormEntity(presidentialFormEntity);
        presidentialForm1.setPoliticalParty(politicalParty);

        return presidentialForm1;
    }

    @Override
    public PresidentialForm findById(UUID id) {
        PresidentialFormEntity presidentialFormEntity = springDatePresidentialFormRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el presidentialForm con el id: "+id));
        return PresidentialFormResponseMapperAux.presidentialFormToPresidentialFormEntity(presidentialFormEntity);
    }


}
