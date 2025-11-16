package org.app.votaclaro.Utils.ExtractionJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Utils.ExtractionJson.Model.Ciudadano;
import org.app.votaclaro.Utils.ExtractionJson.Model.CiudadanoWrapper;
import org.app.votaclaro.Utils.ExtractionJson.Model.CiudadanosWrapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataJson {

    private final ObjectMapper objectMapper;

    public List<Ciudadano> cargarCiudadanos() {
        try {
            ClassPathResource resource = new ClassPathResource("personas.json");

            CiudadanosWrapper wrapper = objectMapper.readValue(
                    resource.getInputStream(),
                    CiudadanosWrapper.class
            );

            // convertir List<CiudadanoWrapper> → List<Ciudadano>
            return wrapper.getCiudadanos()
                    .stream()
                    .map(CiudadanoWrapper::getCiudadano)
                    .toList();

        } catch (Exception e) {
            throw new RuntimeException("Error al leer personas.json", e);
        }
    }
}

