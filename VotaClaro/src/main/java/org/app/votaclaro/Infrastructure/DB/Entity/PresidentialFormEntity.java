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
    private Integer count = 0;
    private Boolean isFull = Boolean.FALSE;
    @OneToOne(
            cascade = {CascadeType.REFRESH, CascadeType.MERGE}
    )
    @JoinColumn(
            name = "political_party_id",
            referencedColumnName = "political_party_id"
    )
    private PoliticalPartyEntity politicalPartyEntity;
}
