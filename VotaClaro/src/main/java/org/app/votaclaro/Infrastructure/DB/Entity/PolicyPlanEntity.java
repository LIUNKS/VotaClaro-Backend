package org.app.votaclaro.Infrastructure.DB.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//Plan de gobierno
@Entity
@Table(name = "policy_plan")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PolicyPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "policy_plan_id")
    private UUID id;
    private String urlPdf;
    @OneToOne(
            cascade = {CascadeType.REFRESH, CascadeType.MERGE}
    )
    @JoinColumn(
            name = "political_party_id",
            referencedColumnName = "political_party_id"
    )
    private PoliticalPartyEntity politicalParty;
}
