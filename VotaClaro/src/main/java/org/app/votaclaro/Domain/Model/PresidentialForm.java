package org.app.votaclaro.Domain.Model;

import java.util.UUID;

public class PresidentialForm {

    private UUID id;
    private Byte count;
    private Boolean isFull;

    public PresidentialForm(UUID id, Byte count, Boolean isFull) {
        this.id = id;
        this.count = count;
        this.isFull = isFull;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Byte getCount() {
        return count;
    }

    public void setCount(Byte count) {
        this.count = count;
    }

    public Boolean getFull() {
        return isFull;
    }

    public void setFull(Boolean full) {
        isFull = full;
    }
}
