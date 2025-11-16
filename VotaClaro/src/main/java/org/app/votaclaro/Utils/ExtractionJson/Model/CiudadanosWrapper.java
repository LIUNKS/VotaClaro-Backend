package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CiudadanosWrapper {
    private List<CiudadanoWrapper> ciudadanos;
}
