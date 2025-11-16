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
                politicalPartySavePersistence.ideology(),
                null
        );
    }
    public static PoliticalParty politicalPartyEntityToPoliticalParty(PoliticalPartyEntity politicalPartyEntity){
        return new PoliticalParty(
                politicalPartyEntity.getId(),
                politicalPartyEntity.getName(),
                politicalPartyEntity.getUrlLogo(),
                politicalPartyEntity.getIdeology(),
                politicalPartyEntity.getUrlListMembers()
        );
    }
}
