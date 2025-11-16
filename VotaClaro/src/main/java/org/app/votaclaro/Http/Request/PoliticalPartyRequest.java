package org.app.votaclaro.Http.Request;


public record PoliticalPartyRequest(
        String name,
        String ideology,
        String members,
        String location,
        String description,
        String dateFoundation
) {

}
