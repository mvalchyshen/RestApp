package com.example.restapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "medical_delegate")
public class MedicalDelegate implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "medicalDelegate",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Doctor> doctors;

}
