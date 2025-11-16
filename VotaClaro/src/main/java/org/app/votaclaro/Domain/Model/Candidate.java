package org.app.votaclaro.Domain.Model;


import java.util.UUID;

public class Candidate {
    private UUID id;

    private String dni;

    private PoliticalParty politicalParty;
    private PresidentialForm presidentialForm;

    public Candidate(UUID id, String dni, PoliticalParty politicalParty, PresidentialForm presidentialForm) {
        this.id = id;
        this.dni = dni;
        this.politicalParty = politicalParty;
        this.presidentialForm = presidentialForm;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    public PresidentialForm getPresidentialForm() {
        return presidentialForm;
    }

    public void setPresidentialForm(PresidentialForm presidentialForm) {
        this.presidentialForm = presidentialForm;
    }
}
