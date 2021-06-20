package com.aboba.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer yearsOfExperience;

    @OneToOne
    private User user;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "vet_specialization",
            joinColumns = {@JoinColumn(name = "vet_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialization_id")})
    private List<Specialization> specializations;
}
