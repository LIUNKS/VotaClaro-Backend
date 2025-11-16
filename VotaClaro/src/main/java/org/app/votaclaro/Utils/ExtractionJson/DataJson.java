package org.app.votaclaro.Utils.ExtractionJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Dto.CandidateUrlImg;
import org.app.votaclaro.Infrastructure.DB.Repository.CandidateRepository.JpaCandidateRepositoryAdapter;
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
    private final JpaCandidateRepositoryAdapter jpaCandidateRepository;

    public List<Ciudadano> cargarCiudadanos() {
        try {
            ClassPathResource resource = new ClassPathResource("json_ciudadanos_normFinal.json");

            CiudadanosWrapper wrapper = objectMapper.readValue(
                    resource.getInputStream(),
                    CiudadanosWrapper.class
            );

            // Obtener lista de DNI + url_img desde la BD
            List<CandidateUrlImg> urlCandidates = jpaCandidateRepository.listUrlCandidates();

            // Convertir List<CiudadanoWrapper> → List<Ciudadano> y asignar url_img
            return wrapper.getCiudadanos()
                    .stream()
                    .map(CiudadanoWrapper::getCiudadano)
                    .peek(ciudadano -> {
                        // buscar url_img por dni
                        urlCandidates.stream()
                                .filter(c -> c.dni().equals(ciudadano.getDni()))
                                .findFirst()
                                .ifPresent(c -> ciudadano.setUrl_img(c.img()));
                    })
                    .toList();

        } catch (Exception e) {
            throw new RuntimeException("Error al leer personas.json", e);
        }
    }
}



