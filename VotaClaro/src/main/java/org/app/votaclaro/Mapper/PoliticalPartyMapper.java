package org.app.votaclaro.Mapper;

import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.app.votaclaro.Dto.PoliticalPartySavePersistence;
import org.app.votaclaro.Http.Request.PoliticalPartyRequest;
import org.app.votaclaro.Http.Response.PoliticalPartyResponse;
import org.app.votaclaro.Infrastructure.DB.Entity.PoliticalPartyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PoliticalPartyMapper {

    PoliticalPartySavePersistence politicalPartyToPoliticalPartySavePersistence(PoliticalParty politicalParty);

    PoliticalPartyEntity politicalPartySavePersistenceToPoliticalPartyEntity(PoliticalPartySavePersistence politicalPartySavePersistence); //No funciona

    PoliticalParty politicalPartyToPoliticalPartyRequest(PoliticalPartyRequest politicalPartyRequest);
    PoliticalPartyResponse politicalPartyToPoliticalPartyResponse(PoliticalParty politicalParty);
    PoliticalPartyEntity politicalPartyToPoliticalPartyEntity(PoliticalParty politicalParty);

    PoliticalParty politicalPartyEntityToPoliticalParty(PoliticalPartyEntity politicalPartyEntity);
}
