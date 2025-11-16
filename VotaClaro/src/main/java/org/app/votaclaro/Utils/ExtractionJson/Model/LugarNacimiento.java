package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LugarNacimiento {
    private String pais;
    private String departamento;
    private String provincia;
    private String distrito;
}
