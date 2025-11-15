package org.app.votaclaro.Infrastructure.DB.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "presidential_form")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PresidentialFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "presidential_form_id")
    private UUID id;
    private Byte count;
    private Boolean isFull;
}
