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
    // Required path variables: user, doctorId, date, token
    @GetMapping("/{user}/{doctorId}/availability/{date}/{token}")
    public List<String> getDoctorAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        // Validate token
        if (token == null || token.isBlank() || !isValidToken(token)) {
            return new ArrayList<>();
        }

        List<String> availability = new ArrayList<>();

        availability.add("09:00");
        availability.add("10:00");
        availability.add("11:00");
        availability.add("14:00");
        availability.add("15:00");
        availability.add("16:00");

        return availability;
    }

    // Check whether a doctor is available at a specific time
    @GetMapping("/{user}/{doctorId}/availability/{date}/{token}/check")
    public boolean checkDoctorAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token,
            @RequestParam String time) {

        if (token == null || token.isBlank() || !isValidToken(token)) {
            return false;
        }

        List<String> availableTimes =
                getDoctorAvailability(user, doctorId, date, token);

        return availableTimes.contains(time);
    }

    // Basic token validation
    private boolean isValidToken(String token) {
        return token.equals("valid-token");
    }
}
