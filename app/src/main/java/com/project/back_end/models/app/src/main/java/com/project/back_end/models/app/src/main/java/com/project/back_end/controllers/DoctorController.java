package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final List<Doctor> doctors = new ArrayList<>();

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctors.stream()
                .filter(doctor -> doctor.getDoctorId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Create a new doctor
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }

    // Get doctor availability
    @GetMapping("/{id}/availability")
    public List<String> getDoctorAvailability(@PathVariable Long id) {
        List<String> availability = new ArrayList<>();

        // Return available appointment time slots
        availability.add("09:00");
        availability.add("10:00");
        availability.add("11:00");
        availability.add("14:00");
        availability.add("15:00");
        availability.add("16:00");

        return availability;
    }

    // Check whether a doctor is available at a specific time
    @GetMapping("/{id}/availability/check")
    public boolean checkDoctorAvailability(
            @PathVariable Long id,
            @RequestParam String time) {

        List<String> availableTimes = getDoctorAvailability(id);

        return availableTimes.contains(time);
    }
}
