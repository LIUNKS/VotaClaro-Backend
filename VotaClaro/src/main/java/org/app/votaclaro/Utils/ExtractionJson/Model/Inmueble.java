package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inmueble {
    private String direccion;
    private String partida_sunarp;
    private String tipo;
    private String caracteristica;
    private double autovaluo;
    private double valor;
    private String comentario;
}
