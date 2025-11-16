package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocalVotacion {
    private String schoolName;
    private String address;
    private String tableNumber;
    private Double latitude;
    private Double longitude;
    private String hours;
    private String capacity;
}
