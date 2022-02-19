package com.example.restapp.service;

import com.example.restapp.mapper.MedicalDelegateMapper;
import com.example.restapp.model.Doctor;
import com.example.restapp.model.MedicalDelegate;
import com.example.restapp.model.dto.MedicalDelegateDTO;
import com.example.restapp.repository.DoctorRepository;
import com.example.restapp.repository.MedicalDelegateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService implements BaseService<Doctor, Long> {

    private final DoctorRepository doctorRepository;
    private final MedicalDelegateMapper mapper;
    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor findById(Long uuid) {
        Optional<Doctor> doctor = doctorRepository.findById(uuid);
        if (doctor.isPresent()) return doctor.get();
        else throw new RuntimeException("No such Doctor found");
    }

    @Override
    public boolean existsById(Long uuid) {
        return doctorRepository.existsById(uuid);
    }

    @Override
    public long count() {
        return doctorRepository.count();
    }

    @Override
    public List<Doctor> findAll() {
        return new ArrayList<>(doctorRepository.findAll());
    }

    @Override
    public List<Doctor> saveAll(Iterable<Doctor> itr) {
        List<Doctor> list = new ArrayList<>();
        for (Doctor d : itr) {
            list.add(doctorRepository.save(d));
        }
        return list;
    }

    @Override
    public void delete(Long uuid) {
        if (existsById(uuid)) doctorRepository.deleteById(uuid);
        else throw new RuntimeException("Doctor with such id not found");
    }

    public MedicalDelegateDTO getMedicalDelegate(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return mapper.toMedicalDTO(doctor.get().getMedicalDelegate());
        }
        throw new RuntimeException("No medical delegate");
    }
}
