package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "enfermedades")
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long icd;

    @Column(name = "nombre")
    private String nombre;

    public Enfermedad() {
    }

    public Enfermedad(long icd, String nombre) {
        this.icd = icd;
        this.nombre = nombre;
    }

    public long getIcd() {
        return icd;
    }

    public void setIcd(long icd) {
        this.icd = icd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
