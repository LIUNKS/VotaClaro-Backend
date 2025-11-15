package org.app.votaclaro.Domain.Model;


import java.util.UUID;

public class PolicyPlan {

    private UUID id;
    private String urlPdf;
    private PoliticalParty politicalParty;

    public PolicyPlan(PoliticalParty politicalParty, String urlPdf, UUID id) {
        this.politicalParty = politicalParty;
        this.urlPdf = urlPdf;
        this.id = id;
    }

    public PolicyPlan(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrlPdf() {
        return urlPdf;
    }

    public void setUrlPdf(String urlPdf) {
        this.urlPdf = urlPdf;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

}
