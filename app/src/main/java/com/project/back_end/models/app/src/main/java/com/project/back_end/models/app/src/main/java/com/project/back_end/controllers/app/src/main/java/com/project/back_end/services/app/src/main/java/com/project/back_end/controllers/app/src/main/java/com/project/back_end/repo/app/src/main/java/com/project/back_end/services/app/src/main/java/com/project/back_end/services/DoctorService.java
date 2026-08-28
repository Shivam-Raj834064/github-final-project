package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DoctorService {

    private final List<Doctor> doctors = new ArrayList<>();

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Get doctor by ID
    public Doctor getDoctorById(Long id) {
        return doctors.stream()
                .filter(doctor -> doctor.getDoctorId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Create doctor
    public Doctor createDoctor(Doctor doctor) {
        doctors.add(doctor);
        return doctor;
    }

    // Update doctor
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getDoctorId().equals(id)) {
                doctors.set(i, updatedDoctor);
                return updatedDoctor;
            }
        }
        return null;
    }

    // Delete doctor
    public boolean deleteDoctor(Long id) {
        return doctors.removeIf(
                doctor -> doctor.getDoctorId().equals(id)
        );
    }

    // Get doctor availability for a specific date
    public List<String> getDoctorAvailability(
            Long doctorId, LocalDate date) {

        Doctor doctor = getDoctorById(doctorId);

        if (doctor == null || date == null) {
            return new ArrayList<>();
        }

        return Arrays.asList(
                "09:00",
                "10:00",
                "11:00",
                "14:00",
                "15:00",
                "16:00"
        );
    }

    // Validate doctor login using email and password
    public boolean validateDoctorCredentials(
            String email, String password) {

        if (email == null || email.isBlank()
                || password == null || password.isBlank()) {
            return false;
        }

        return doctors.stream()
                .anyMatch(doctor ->
                        doctor.getEmail() != null &&
                        doctor.getPassword() != null &&
                        doctor.getEmail().equalsIgnoreCase(email) &&
                        doctor.getPassword().equals(password)
                );
    }
}







public String getPassword()


    List<String> availableTimes = getDoctorAvailability(id);


doctorService.getDoctorAvailability(id, date);


@GetMapping("/{id}/availability")
public List<String> getDoctorAvailability(
        @PathVariable Long id,
        @RequestParam LocalDate date) {

    return doctorService.getDoctorAvailability(id, date);
}


import java.time.LocalDate;
