package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingresos {
    private double total;
    private double publico;
    private double privado;
    private double renta_publico;
    private double renta_privado;
    private double otro_ingreso_publico;
    private double otro_ingreso_privado;
}
