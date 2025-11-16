package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehiculo {
    private String modelo;
    private Integer anio;
    private String placa;
    private String caracteristica;
    private double valor;
    private String comentario;
}
