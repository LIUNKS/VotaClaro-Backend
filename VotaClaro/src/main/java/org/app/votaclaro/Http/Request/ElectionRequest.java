package org.app.votaclaro.Http.Request;

import java.time.LocalDate;
import java.util.UUID;

public record ElectionRequest(LocalDate electionDate, UUID nomineeId) {
}

