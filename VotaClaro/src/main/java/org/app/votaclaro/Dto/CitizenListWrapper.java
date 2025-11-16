package org.app.votaclaro.Dto;

import lombok.Data;
import org.app.votaclaro.Domain.Model.Citizen;

import java.util.List;

@Data
public class CitizenListWrapper {
    private List<Citizen> citizens;
}
