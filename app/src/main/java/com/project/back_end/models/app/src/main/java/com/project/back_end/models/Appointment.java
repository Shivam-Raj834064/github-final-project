
package com.project.back_end.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    @Future
    private LocalDateTime appointmentTime;

    private String status;

    private String reason;

    public Appointment() {
    }

    public Appointment(Doctor doctor, Patient patient,
                       LocalDateTime appointmentTime,
                       String status, String reason) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.reason = reason;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}


import jakarta.validation.constraints.NotNull;


@NotNull
@Future
private LocalDateTime appointmentTime;
