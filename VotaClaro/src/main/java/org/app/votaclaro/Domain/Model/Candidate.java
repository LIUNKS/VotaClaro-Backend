package org.app.votaclaro.Domain.Model;


import java.time.LocalDate;
import java.util.UUID;

public class Candidate {
    private UUID id;
    private String fullName;
    private String dni;
    private LocalDate birthDate;
    private String urlCv;
    private PoliticalParty politicalParty;
    private Nominee nominee;
    private PresidentialForm presidentialForm;

    public Candidate(UUID id, String fullName, String dni, LocalDate birthDate, String urlCv, PoliticalParty politicalParty, Nominee nominee, PresidentialForm presidentialForm) {
        this.id = id;
        this.fullName = fullName;
        this.dni = dni;
        this.birthDate = birthDate;
        this.urlCv = urlCv;
        this.politicalParty = politicalParty;
        this.nominee = nominee;
        this.presidentialForm = presidentialForm;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getUrlCv() {
        return urlCv;
    }

    public void setUrlCv(String urlCv) {
        this.urlCv = urlCv;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }

    public PresidentialForm getPresidentialForm() {
        return presidentialForm;
    }

    public void setPresidentialForm(PresidentialForm presidentialForm) {
        this.presidentialForm = presidentialForm;
    }
}
