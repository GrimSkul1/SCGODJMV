package net.javaguides.springboot.web.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppRegistrationDto {
    private String description;
    private LocalDate date;
    private LocalTime time;
    private String doctorID;
    private String pacientID;

    public AppRegistrationDto(String description, LocalDate date, LocalTime time, String doctorID, String pacientID) {
        this.description = description;
        this.date = date;
        this.time = time;
        this.doctorID = doctorID;
        this.pacientID = pacientID;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getPacientID() {
        return pacientID;
    }
}
