package org.app.votaclaro.Domain.Model;

import java.util.UUID;

public class PresidentialForm {

    private UUID id;
    private Integer count;
    private Boolean isFull;
    private PoliticalParty politicalParty;

    public PresidentialForm(UUID id, Integer count, Boolean isFull, PoliticalParty politicalParty) {

        if (id == null) {
            throw new IllegalArgumentException("El ID de la fórmula presidencial no puede ser nulo.");
        }

        int safeCount = (count == null ? 0 : count);

        if (Boolean.TRUE.equals(isFull)) {
            throw new RuntimeException("La lista de participantes ya está llena (límite 3).");
        }

        this.id = id;

        this.count = safeCount + 1;

        this.isFull = this.count >= 3;

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
