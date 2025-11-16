package org.app.votaclaro.Domain.Model;

import lombok.Data;

import java.util.UUID;

@Data
public class Citizen {
    private UUID id;
    private String dni;
    private String fullname;
    //datos personales
    //faltan mas datos para JSON
}
