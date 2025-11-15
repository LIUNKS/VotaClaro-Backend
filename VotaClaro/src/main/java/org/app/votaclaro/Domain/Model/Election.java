package org.app.votaclaro.Domain.Model;


import java.util.UUID;

public class Election {
    private UUID id;
    private String electionDate;
    private Nominee nominee;

    public Election(UUID id, String electionDate, Nominee nominee) {
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

    public String getElectionDate() {
        return electionDate;
    }

    public void setElectionDate(String electionDate) {
        this.electionDate = electionDate;
    }

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }
}
