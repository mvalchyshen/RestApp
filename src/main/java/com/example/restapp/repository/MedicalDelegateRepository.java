package com.example.restapp.repository;

import com.example.restapp.model.Doctor;
import com.example.restapp.model.MedicalDelegate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface MedicalDelegateRepository extends JpaRepository<MedicalDelegate, Long> {
}
