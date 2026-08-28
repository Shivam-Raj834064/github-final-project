
package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final List<Prescription> prescriptions = new ArrayList<>();

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable Long id) {
        return prescriptions.stream()
                .filter(prescription ->
                        prescription.getPrescriptionId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Prescription createPrescription(
            @RequestBody Prescription prescription) {
        prescriptions.add(prescription);
        return prescription;
    }

    @PutMapping("/{id}")
    public Prescription updatePrescription(
            @PathVariable Long id,
            @RequestBody Prescription updatedPrescription) {

        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).getPrescriptionId().equals(id)) {
                prescriptions.set(i, updatedPrescription);
                return updatedPrescription;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deletePrescription(@PathVariable Long id) {

        boolean removed = prescriptions.removeIf(
                prescription ->
                        prescription.getPrescriptionId().equals(id)
        );

        return removed
                ? "Prescription deleted successfully"
                : "Prescription not found";
    }
}











@PostMapping
public ResponseEntity<Prescription> createPrescription(
        @Valid @RequestBody Prescription prescription) {
    return ResponseEntity.ok(prescription);
}




import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;






