package org.app.votaclaro.Domain.Model;

import java.util.UUID;

public class PoliticalParty {

    private UUID id;
    private String name;
    private String urlLogo;
    private String ideology;

    public PoliticalParty(UUID id, String name, String urlLogo, String ideology) {
        this.id = id;
        this.name = name;
        this.urlLogo = urlLogo;
        this.ideology = ideology;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getIdeology() {
        return ideology;
    }

    public void setIdeology(String ideology) {
        this.ideology = ideology;
    }

}
