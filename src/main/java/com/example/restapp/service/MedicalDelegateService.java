package com.example.restapp.service;

import com.example.restapp.model.Doctor;
import com.example.restapp.model.MedicalDelegate;
import com.example.restapp.repository.MedicalDelegateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MedicalDelegateService implements BaseService<MedicalDelegate, Long> {

    private final MedicalDelegateRepository medicalDelegateRepository;

    @Override
    public MedicalDelegate save(MedicalDelegate medicalDelegate) {
        return medicalDelegateRepository.save(medicalDelegate);
    }

    @Override
    public MedicalDelegate findById(Long uuid) {
        Optional<MedicalDelegate> md = medicalDelegateRepository.findById(uuid);
        if (md.isPresent()) return md.get();
        else throw new RuntimeException("No such Doctor found");
    }

    @Override
    public boolean existsById(Long uuid) {
        return medicalDelegateRepository.existsById(uuid);
    }

    @Override
    public long count() {
        return medicalDelegateRepository.count();
    }

    @Override
    public List<MedicalDelegate> findAll() {
        return new ArrayList<>(medicalDelegateRepository.findAll());
    }

    @Override
    public List<MedicalDelegate> saveAll(Iterable<MedicalDelegate> itr) {
        List<MedicalDelegate> list = new ArrayList<>();
        for (MedicalDelegate md : itr) {
            list.add(medicalDelegateRepository.save(md));
        }
        return list;
    }

    @Override
    public void delete(Long uuid) {
        if (existsById(uuid)) medicalDelegateRepository.deleteById(uuid);
        else throw new RuntimeException("Medical Delegate not found");
    }
}
