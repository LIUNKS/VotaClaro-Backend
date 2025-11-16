package org.app.votaclaro.Domain.Model;

import java.util.UUID;

public class PresidentialForm {

    private UUID id;
    private Integer count;
    private Boolean isFull;
    private PoliticalParty politicalParty;

    public PresidentialForm(UUID id, Integer count, Boolean isFull, PoliticalParty politicalParty) {
        this.id = id;
        this.count = count;
        this.isFull = isFull;
        this.politicalParty = politicalParty;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getFull() {
        return isFull;
    }

    public void setFull(Boolean full) {
        isFull = full;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }
}
