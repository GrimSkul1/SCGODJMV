package net.javaguides.springboot.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="consult")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "idCita")
    private long idCita;

    @Column(name = "idDoctor")
    private long idDoctor;

    @Column(name = "idPaciente")
    private long idPaciente;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "time")
    private LocalTime time;

    @Column(name = "cost")
    private float cost;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "diagnostico")
    private String diagnostico;

    @ManyToMany
    private List<Procedures> procedimientos;

    @ManyToMany
    private List<Enfermedad> enfermedades;

    public Consulta(long idCita, long idDoctor, long idPaciente, LocalDate date, LocalTime time, float costo, String observaciones, String diagnostico, List<Procedures> procedimientos, List<Enfermedad> enfermedades) {
        this.idCita = idCita;
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
        this.date = date;
        this.time = time;
        this.cost = costo;
        this.observaciones = observaciones;
        this.diagnostico = diagnostico;
        this.procedimientos = procedimientos;
        this.enfermedades = enfermedades;
    }

    public Consulta() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCita() {
        return idCita;
    }

    public void setIdCita(long idCita) {
        this.idCita = idCita;
    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setProcedimientos(List<Procedures> procedimientos) {
        this.procedimientos = procedimientos;
    }

    public List<Procedures> getProcedimientos() {
        return procedimientos;
    }

    public List<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }
}
