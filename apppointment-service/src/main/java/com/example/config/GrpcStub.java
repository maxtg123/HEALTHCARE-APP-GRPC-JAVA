package com.example.config;
import com.example.DoctorServiceGrpc;
import com.example.patient.PatientServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class GrpcStub {

    @Bean
    DoctorServiceGrpc.DoctorServiceBlockingStub doctorServiceBlockingStub(GrpcChannelFactory channels) {
        return DoctorServiceGrpc.newBlockingStub(channels.createChannel("doctorService"));
    }

    @Bean
    PatientServiceGrpc.PatientServiceBlockingStub patientServiceBlockingStub(GrpcChannelFactory channels) {
        return PatientServiceGrpc.newBlockingStub(channels.createChannel("patientService"));
    }
}