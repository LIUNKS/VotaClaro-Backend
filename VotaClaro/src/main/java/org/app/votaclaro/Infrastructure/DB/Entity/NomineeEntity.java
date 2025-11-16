package org.app.votaclaro.Infrastructure.DB.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.votaclaro.Enum.NomineeStatus;
import org.app.votaclaro.Enum.PositionType;

import java.util.UUID;

//Postulante
@Entity
@Table(name = "nominee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NomineeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nominee_id")
    private UUID id;

    private PositionType position;

    private NomineeStatus status;

    private Byte ViceNum;

    @ManyToOne(
            cascade = {CascadeType.REFRESH, CascadeType.MERGE}
    )
    @JoinColumn(
            name = "political_party_id",
            referencedColumnName = "political_party_id"
    )
    private PoliticalPartyEntity politicalParty;

    @OneToOne(
            cascade = {CascadeType.REFRESH, CascadeType.MERGE}
    )
    @JoinColumn(
            name = "candidate_id",
            referencedColumnName = "candidate_id"
    )
    private CandidateEntity nominee;

}
