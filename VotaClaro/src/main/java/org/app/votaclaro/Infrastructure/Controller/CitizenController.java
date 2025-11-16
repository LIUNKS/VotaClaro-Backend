package org.app.votaclaro.Infrastructure.Controller;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Utils.ExtractionJson.DataJson;
import org.app.votaclaro.Utils.ExtractionJson.Model.Ciudadano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citizen")
@RequiredArgsConstructor
public class CitizenController {

    private final DataJson ciudadanoService;

    @GetMapping
    public List<Ciudadano> listarCiudadanos() {
        return ciudadanoService.cargarCiudadanos();
    }
}
