package org.app.votaclaro.Infrastructure.DB.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "election")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "election_id")
    private UUID id;
    private LocalDate electionDate;
    @ManyToOne(
            cascade = {CascadeType.REFRESH, CascadeType.MERGE}
    )
    @JoinColumn(
            name = "nominee_id",
            referencedColumnName = "nominee_id"
    )
    private NomineeEntity nominee;
}
