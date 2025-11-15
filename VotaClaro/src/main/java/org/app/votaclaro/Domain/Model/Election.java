package org.app.votaclaro.Domain.Model;

import java.time.LocalDate;
import java.util.UUID;

public class Election {
    private UUID id;
    private LocalDate electionDate;
    private Nominee nominee;

    public Election(UUID id, LocalDate electionDate, Nominee nominee) {
        this.id = id;
        this.electionDate = electionDate;
        this.nominee = nominee;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getElectionDate() {
        return electionDate;
    }

    public void setElectionDate(LocalDate electionDate) {
        this.electionDate = electionDate;
    }

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }
}
