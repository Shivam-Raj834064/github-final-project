
# MySQL Database Schema Design

## Overview

The Smart Clinic Management System uses a MySQL relational database to store and manage information about administrators, doctors, patients, and appointments.

## Database Tables

### 1. Admin Table

| Column | Data Type | Description |
|---|---|---|
| admin_id | BIGINT | Primary key |
| username | VARCHAR(100) | Admin username |
| password | VARCHAR(255) | Encrypted admin password |
| role | VARCHAR(50) | Administrator role |

**Primary Key:** `admin_id`

---

### 2. Doctor Table

| Column | Data Type | Description |
|---|---|---|
| doctor_id | BIGINT | Primary key |
| name | VARCHAR(100) | Doctor's name |
| specialization | VARCHAR(100) | Medical specialization |
| email | VARCHAR(150) | Doctor email |
| phone | VARCHAR(20) | Doctor phone number |

**Primary Key:** `doctor_id`

---

### 3. Patient Table

| Column | Data Type | Description |
|---|---|---|
| patient_id | BIGINT | Primary key |
| name | VARCHAR(100) | Patient's name |
| email | VARCHAR(150) | Patient email |
| phone | VARCHAR(20) | Patient phone number |
| date_of_birth | DATE | Patient date of birth |
| address | VARCHAR(255) | Patient address |

**Primary Key:** `patient_id`

---

### 4. Appointment Table

| Column | Data Type | Description |
|---|---|---|
| appointment_id | BIGINT | Primary key |
| doctor_id | BIGINT | References Doctor |
| patient_id | BIGINT | References Patient |
| appointment_time | DATETIME | Date and time of appointment |
| status | VARCHAR(50) | Appointment status |
| reason | VARCHAR(255) | Reason for appointment |

**Primary Key:** `appointment_id`

**Foreign Keys:**
- `doctor_id` → `Doctor(doctor_id)`
- `patient_id` → `Patient(patient_id)`

---

## Relationships

### Doctor and Appointment

One Doctor can have many Appointments.

**Relationship:** One-to-Many

```text
Doctor (1) -------- (Many) Appointment
