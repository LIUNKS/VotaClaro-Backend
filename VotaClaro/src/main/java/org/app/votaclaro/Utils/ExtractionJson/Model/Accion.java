package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Accion {
    private String persona_juridica;
    private String tipo;
    private double cantidad;
    private double valor;
    private String comentario;
}
