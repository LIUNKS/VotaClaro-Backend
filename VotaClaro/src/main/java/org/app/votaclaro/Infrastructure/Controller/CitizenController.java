package org.app.votaclaro.Infrastructure.Controller;

import lombok.RequiredArgsConstructor;
import org.app.votaclaro.Utils.ExtractionJson.CiudadanoService;
import org.app.votaclaro.Utils.ExtractionJson.DataJson;
import org.app.votaclaro.Utils.ExtractionJson.Model.Ciudadano;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
@RequiredArgsConstructor
public class CitizenController {

    private final DataJson ciudadanos;
    private final CiudadanoService service;

    @GetMapping
    public List<Ciudadano> listarCiudadanos() {
        return ciudadanos.cargarCiudadanos();
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> getByDni(@PathVariable String dni){
        Ciudadano c = service.findByDni(dni);
        return (c!=null) ? ResponseEntity.ok(c): ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Ciudadano>> getByNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.findByNombre(nombre));
    }

    //paginacion 5 en 5
    @GetMapping("/page/{page}")
    public ResponseEntity<List<Ciudadano>> paginate(@PathVariable int page){
        return ResponseEntity.ok(service.paginate(page));
    }

}
