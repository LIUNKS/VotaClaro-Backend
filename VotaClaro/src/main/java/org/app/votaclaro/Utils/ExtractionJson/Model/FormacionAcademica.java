package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FormacionAcademica {
    private String institucion;
    private String carrera;
    private String grado;
    private Integer anio_fin;
}
