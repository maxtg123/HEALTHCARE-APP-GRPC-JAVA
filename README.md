# 🏥 Spring Boot gRPC Project - Health Care Application

This project demonstrates a gRPC-based microservice application for managing patients, doctors, and appointments in a healthcare context. Each service communicates using gRPC and supports unary, server streaming, client streaming, and bidirectional streaming calls.

---

## 🔧 Prerequisites

- Java 17+
- Maven
- gRPC tools (`grpcurl`, `grpcui`)
- Docker (optional, for containerized deployment)

---

## 🚀 Services Overview

| Service        | Port  | Description                      |
|----------------|-------|----------------------------------|
| PatientService | 9090  | Manage patient registration and details |
| DoctorService  | 9091  | Manage doctor registration and interaction |
| AppointmentService | 9092 | Manage appointments and availability |

---

## 🧪 Patient Service gRPC Calls

### ▶️ List Available Services
```bash
grpcurl -plaintext localhost:9090 list
```

### 🌐 gRPC Web UI
```bash
grpcui -plaintext localhost:9090
```

### 📝 Register Patient
```bash
grpcurl -plaintext -d '{
  "first_name": "John",
  "last_name": "Thomas",
  "email": "john.thomas@example.com",
  "phone": "123-456-7890",
  "address": "123 Main St"
}' localhost:9090 com.example.patient.PatientService/RegisterPatient
```

### 🔍 Get Patient Details
```bash
grpcurl -plaintext -d '{
  "patient_id": 1
}' localhost:9090 com.examle.patient.PatientService/GetPatientDetails
```

### 📡 Stream Patients (Client Streaming)
```bash
grpcurl -d @ -plaintext localhost:9090 com.example.patient.PatientService/StreamPatients <<EOM
{
  "first_name": "John",
  "last_name": "Smith",
  "email": "john.smith@example.com",
  "phone": "1234567890",
  "address": "123 Main St"
}
{
  "first_name": "Jane",
  "last_name": "Smith",
  "email": "jane.smith@example.com",
  "phone": "0987654321",
  "address": "456 Elm St"
}
EOM
```

---

## 👨‍⚕️ Doctor Service gRPC Calls

### ▶️ List Available Services
```bash
grpcurl -plaintext localhost:9091 list
```

### 📝 Register Doctor
```bash
grpcurl -d '{
  "first_name": "Tim",
  "last_name": "Jacob",
  "email": "tim.jacob@example.com",
  "phone": "123-456-7890",
  "specialty": "Cardiology",
  "centre_name": "Health Centre",
  "location": "New York"
}' -plaintext localhost:9091 com.example.doctor.DoctorService/RegisterDoctor
```

### 🔍 Get Doctor Details
```bash
grpcurl -plaintext -d '{
  "doctor_id": 1
}' localhost:9091 com.example.doctor.DoctorService/GetDoctorDetails
```

### 💬 Chat with Doctor (Bidirectional Streaming)
```bash
grpcurl -d @ -plaintext localhost:9091 com.example.doctor.DoctorService/Chat <<EOM
{
  "message": "Hello, Doctor!",
  "from": "Patient",
  "to": "Doctor",
  "timestamp": "2023-10-01T12:00:00Z"
}
{
  "message": "How are you?",
  "from": "Patient",
  "to": "Doctor",
  "timestamp": "2023-10-01T12:01:00Z"
}
EOM
```

---

## 📅 Appointment Service gRPC Calls

### ▶️ List Available Services
```bash
grpcurl -plaintext localhost:9092 list
```

### 🔍 Get Appointment Availability (Server Streaming)
```bash
grpcurl -plaintext -d '{
  "doctor_id": 1
}' localhost:9092 com.example.appointment.AppointmentService/GetAppointmentAvailability
```

### ✅ Book Appointment
```bash
grpcurl -plaintext -d '{
  "doctor_id": 1,
  "patient_id": 1,
  "appointment_date": "2025-02-15",
  "appointment_time": "10:00",
  "reason": "Routine check-up"
}' localhost:9092 com.example.appointment.AppointmentService/BookAppointment
```

---

## 📂 Project Structure

```
healthcare-app/
├── patient-service/
├── doctor-service/
└── appointment-service/
```

---

## 📜 License

This project is for educational purposes. No license applied.

---

## 👨‍💻 Author

**Cao Quang Phong**  
Backend Engineer  

