package org.app.votaclaro.Mapper;

import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Dto.PoliticalPartySavePersistence;
import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;

public class PoliticalPartyMapperAux {
    public static PoliticalPartyEntity politicalPartySavePersistenceToPoliticalPartyEntity(PoliticalPartySavePersistence politicalPartySavePersistence){
        return new PoliticalPartyEntity(
                null,
                politicalPartySavePersistence.name(),
                null,
                politicalPartySavePersistence.members(),
                politicalPartySavePersistence.location(),
                politicalPartySavePersistence.description(),
                politicalPartySavePersistence.dateFoundation(),
                politicalPartySavePersistence.ideology(),
                null
        );
    }
    public static PoliticalParty politicalPartyEntityToPoliticalParty(PoliticalPartyEntity politicalPartyEntity){
        return new PoliticalParty(
                politicalPartyEntity.getId(),
                politicalPartyEntity.getName(),
                politicalPartyEntity.getIdeology(),
                politicalPartyEntity.getUrlLogo(),
                politicalPartyEntity.getUrlListMembers(),
                politicalPartyEntity.getMembers(),
                politicalPartyEntity.getLocation(),
                politicalPartyEntity.getDescription(),
                politicalPartyEntity.getDateFoundation()
        );
    }
}
