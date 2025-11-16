package org.app.votaclaro.Utils.ExtractionJson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ciudadano {
    private String id;
    private String dni;
    private String nombre_completo;
    private DatosPersonales datos_personales;
    private Antecedentes antecedentes;
    private Ingresos ingresos;
    private Bienes bienes;
    private LocalVotacion local_votacion;
    private List<ExperienciaLaboral> experiencia_laboral;
    private List<FormacionAcademica> formacion_academica;
    private List<Object> cargos_partidarios;
    private List<Object> cargos_eleccion_popular;
}
