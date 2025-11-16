package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExperienciaLaboral {
    private String desde;
    private String hasta;
    private String cargo;
    private String organizacion;
}
