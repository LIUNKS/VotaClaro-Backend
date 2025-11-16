package org.app.votaclaro.Application.Port.Out;

import org.app.votaclaro.Domain.Model.PoliticalParty;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface PoliticalPartyRepositoryPort {
    PoliticalParty save(PoliticalParty politicalParty, MultipartFile urlLogo, MultipartFile urlListMembers) throws Exception;
    List<PoliticalParty> findAll();
    PoliticalParty findById(UUID id);
}
