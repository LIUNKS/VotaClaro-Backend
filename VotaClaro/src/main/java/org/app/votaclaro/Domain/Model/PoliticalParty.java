package org.app.votaclaro.Domain.Model;

import java.util.UUID;

public class PoliticalParty {

    private UUID id;
    private String name;
    private String ideology;
    private String urlLogo;
    private String urlListMembers;
    private String members;
    private String location;
    private String description;
    private String dateFoundation;

    public PoliticalParty(UUID id, String name, String ideology, String urlLogo, String urlListMembers, String members, String location, String description, String dateFoundation) {
        this.id = id;
        this.name = name;
        this.ideology = ideology;
        this.urlLogo = urlLogo;
        this.urlListMembers = urlListMembers;
        this.members = members;
        this.location = location;
        this.description = description;
        this.dateFoundation = dateFoundation;
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

    public String getIdeology() {
        return ideology;
    }

    public void setIdeology(String ideology) {
        this.ideology = ideology;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getUrlListMembers() {
        return urlListMembers;
    }

    public void setUrlListMembers(String urlListMembers) {
        this.urlListMembers = urlListMembers;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateFoundation() {
        return dateFoundation;
    }

    public void setDateFoundation(String dateFoundation) {
        this.dateFoundation = dateFoundation;
    }
}
