package com.example.restapp.mapper;

import com.example.restapp.model.MedicalDelegate;
import com.example.restapp.model.dto.MedicalDelegateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalDelegateMapper {
    MedicalDelegateDTO toMedicalDTO(MedicalDelegate medicalDelegate);
}
