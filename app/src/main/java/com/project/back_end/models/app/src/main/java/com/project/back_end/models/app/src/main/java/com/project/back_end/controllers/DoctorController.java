
package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final List<Doctor> doctors = new ArrayList<>();

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctors.stream()
                .filter(doctor -> doctor.getDoctorId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id,
                               @RequestBody Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getDoctorId().equals(id)) {
                doctors.set(i, updatedDoctor);
                return updatedDoctor;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        boolean removed = doctors.removeIf(
                doctor -> doctor.getDoctorId().equals(id)
        );

        return removed ? "Doctor deleted successfully" : "Doctor not found";
    }
}
