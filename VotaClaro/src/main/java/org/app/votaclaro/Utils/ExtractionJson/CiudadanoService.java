package org.app.votaclaro.Utils.ExtractionJson;

import org.app.votaclaro.Utils.ExtractionJson.Model.Ciudadano;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CiudadanoService {
    private final List<Ciudadano> ciudadanos;

    public CiudadanoService(DataJson dataJson){
        this.ciudadanos = dataJson.cargarCiudadanos();
    }

    public Boolean findByDniExists(String dni){
        return ciudadanos.stream()
                .anyMatch(c -> c.getDni().equals(dni));
    }

    public Ciudadano findByDni(String dni){
        return ciudadanos.stream()
                .filter(c -> c.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(null);
    }

    public List<Ciudadano> findByNombre(String nombre){
        return ciudadanos.stream()
                .filter(c -> c.getNombre_completo().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Ciudadano> paginate(int page){
        int size = 5;
        int from = page*size;

        if(from>= ciudadanos.size()) return List.of();

        int to = Math.min(from + size, ciudadanos.size());

        return ciudadanos.subList(from,to);
    }
}
