package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DatosPersonales {
    private String fecha_nacimiento;
    private String sexo;
    private String educacion;
    private LugarNacimiento lugar_nacimiento;
    private String domicilio;

}
