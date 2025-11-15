package org.app.votaclaro.Http.Request;

import org.app.votaclaro.Enum.NomineeStatus;
import org.app.votaclaro.Enum.PositionType;

import java.util.UUID;

public record NomineeRequest(
        PositionType position,
        NomineeStatus status,
        Byte viceNum,
        UUID politicalPartyId
) {}
