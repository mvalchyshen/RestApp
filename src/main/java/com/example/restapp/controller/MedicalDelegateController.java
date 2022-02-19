package com.example.restapp.controller;

import com.example.restapp.model.ApiResponse;
import com.example.restapp.model.MedicalDelegate;
import com.example.restapp.service.MedicalDelegateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.restapp.controller.Endpoints.ID;
import static com.example.restapp.controller.Endpoints.MEDICAL_DELEGATE;

@RestController
//@RequestMapping(MEDICAL_DELEGATE)
@RequiredArgsConstructor
public class MedicalDelegateController {

    private final MedicalDelegateService medicalDelegateService;

    @GetMapping
    public ResponseEntity<List<MedicalDelegate>> getAll() {
        return ResponseEntity.ok(medicalDelegateService.findAll());
    }
    @GetMapping(ID)
    public ResponseEntity<MedicalDelegate> getOne(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(medicalDelegateService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MedicalDelegate> save(@RequestBody MedicalDelegate medicalDelegate) {
        return ResponseEntity.ok(medicalDelegateService.save(medicalDelegate));
    }

    @DeleteMapping(ID)
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        medicalDelegateService.delete(id);
        return ResponseEntity.status(204).body(ApiResponse.builder()
                .status(204)
                .message("medical delegate was deleted").build());
    }
}
