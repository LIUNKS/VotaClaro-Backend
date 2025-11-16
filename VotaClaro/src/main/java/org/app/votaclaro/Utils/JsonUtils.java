package org.app.votaclaro.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.app.votaclaro.Domain.Model.Citizen;
import org.app.votaclaro.Dto.CitizenListWrapper;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    //leer archivo y retornar lista
    public static List<Citizen> loadCitizens(String filepath){
        try {
            CitizenListWrapper wrapper = mapper.readValue(
                    new File(filepath), CitizenListWrapper.class
            );
            return wrapper.getCitizens();
        } catch (Exception e){
            throw new RuntimeException("Error lectura json: "+e.getMessage(), e);
        }
    }

    public static Citizen findByDni(List<Citizen> list, String dni){
        return list.stream()
                .filter( c -> c.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .orElse(null);
    }

    public static List<Citizen> findByName(List<Citizen> list, String name){
        return list.stream()
                .filter(c -> c.getFullname().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<Citizen> paginate(List<Citizen> list, int page, int size){
        int from = page * size;
        int to = Math.min(from + size, list.size());

        if(from >= list.size()){
            return List.of();
        }
        return list.subList(from, to);
    }

}
