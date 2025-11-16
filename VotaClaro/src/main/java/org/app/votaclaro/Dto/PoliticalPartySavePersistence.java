package org.app.votaclaro.Dto;

public record PoliticalPartySavePersistence(
        String name,
        String ideology,
        String members,
        String location,
        String description,
        String dateFoundation
) {
}
