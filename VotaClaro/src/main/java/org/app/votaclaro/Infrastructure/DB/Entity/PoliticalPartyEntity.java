package org.app.votaclaro.Infrastructure.DB.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//Agrupacion politica
@Entity
@Table(name = "political_party")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PoliticalPartyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "political_party_id")
    private UUID id;
    @Column(unique = true)
    private String name;
    private String urlLogo;
    private String ideology;
    private String urlListMembers;
}
