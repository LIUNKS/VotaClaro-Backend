package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Antecedentes {
    private int total;
    private int penales;
    private int obligaciones;
    private List<Object> lista_sentencias;
}
