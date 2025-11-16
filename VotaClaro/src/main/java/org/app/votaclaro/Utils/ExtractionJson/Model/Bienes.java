package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bienes {
    private double valor_total;
    private List<Object> muebles;
    private List<Inmueble> inmuebles;
    private List<Vehiculo> vehiculos;
    private List<Accion> acciones;
}
