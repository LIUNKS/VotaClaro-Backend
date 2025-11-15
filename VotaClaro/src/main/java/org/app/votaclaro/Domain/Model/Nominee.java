package org.app.votaclaro.Domain.Model;

import org.app.votaclaro.Enum.NomineeStatus;
import org.app.votaclaro.Enum.PositionType;

import java.util.UUID;

public class Nominee {
    private UUID id;
    private PositionType position;
    private NomineeStatus status;
    private Byte ViceNum;
    private PoliticalParty politicalParty;
    private Candidate candidate;

    public Nominee(UUID id, PositionType position, NomineeStatus status, Byte viceNum, PoliticalParty politicalParty, Candidate candidate) {
        this.id = id;
        this.position = position;
        this.status = status;
        this.ViceNum = viceNum;
        this.politicalParty = politicalParty;
        this.candidate = candidate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public NomineeStatus getStatus() {
        return status;
    }

    public void setStatus(NomineeStatus status) {
        this.status = status;
    }

    public Byte getViceNum() {
        return ViceNum;
    }

    public void setViceNum(Byte viceNum) {
        ViceNum = viceNum;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
