package net.javaguides.springboot.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "description")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "time")
    private LocalTime time;

    @Column(name = "doctor")
    private String doctorID;

    @Column(name = "pacient")
    private String pacientID;

    public Appointment() {

    }

    public Appointment(String description, LocalDate date, LocalTime time, String doctorID, String pacientID) {
        this.description = description;
        this.date = date;
        this.time = time;
        this.doctorID = doctorID;
        this.pacientID = pacientID;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPacientID() {
        return pacientID;
    }

    public void setPacientID(String pacientID) {
        this.pacientID = pacientID;
    }
}