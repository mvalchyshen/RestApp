package com.example.restapp.controller;

import com.example.restapp.model.ApiResponse;
import com.example.restapp.model.Doctor;
import com.example.restapp.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.restapp.controller.Endpoints.*;

@RestController
@RequestMapping(DOCTOR)
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping(ID)
    public ResponseEntity<Doctor> getById(@PathVariable("id") Long uuid) {
        return ResponseEntity.ok(doctorService.findById(uuid));
    }

    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.save(doctor));
    }

    @DeleteMapping(ID)
    public ResponseEntity<ApiResponse> deleteDoctor(@PathVariable("id") Long id){
        doctorService.delete(id);
        return new ResponseEntity<>(ApiResponse.builder()
                .status(204)
                .message("deleted")
                .build(), HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = ID+MEDICAL_DELEGATE, method = RequestMethod.GET)
    public ResponseEntity<?> getMedicalDelegateByDoctorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(doctorService.getMedicalDelegate(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ApiResponse.builder().status(500).message("delegate not found"));
        }
    }
}
