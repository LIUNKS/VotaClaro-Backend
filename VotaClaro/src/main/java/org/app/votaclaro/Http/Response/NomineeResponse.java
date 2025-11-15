package org.app.votaclaro.Http.Response;

import org.app.votaclaro.Enum.NomineeStatus;
import org.app.votaclaro.Enum.PositionType;

import java.util.UUID;

public record NomineeResponse(
        UUID id,
        PositionType position,
        NomineeStatus status,
        Byte viceNum,
        PoliticalPartyResponse politicalParty
) {}
