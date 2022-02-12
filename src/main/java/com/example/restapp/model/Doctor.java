package com.example.restapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "medical_delegate_id")
    private MedicalDelegate medicalDelegate;
}
