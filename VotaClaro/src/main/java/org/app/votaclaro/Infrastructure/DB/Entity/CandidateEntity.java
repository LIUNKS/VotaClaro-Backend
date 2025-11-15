package org.app.votaclaro.Infrastructure.DB.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

//candidato
@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id")
    private UUID id;
    private String fullName;
    private String dni;
    private LocalDate birthDate;
    private String urlCv;

    @ManyToOne(
            cascade = {CascadeType.REFRESH, CascadeType.MERGE}
    )
    @JoinColumn(
            name = "political_party_id",
            referencedColumnName = "political_party_id",
            nullable = false
    )
    private PoliticalPartyEntity politicalParty;

    @OneToOne(
            cascade = {CascadeType.REFRESH, CascadeType.MERGE}
    )
    @JoinColumn(
            name = "nominee_id",
            referencedColumnName = "nominee_id"
    )
    private NomineeEntity nominee;

    @ManyToOne(
            cascade = {CascadeType.REFRESH, CascadeType.MERGE}
    )
    @JoinColumn(
            name = "presidential_form_id",
            referencedColumnName = "presidential_form_id",
            nullable = false
    )
    private PresidentialFormEntity presidentialForm;
}
