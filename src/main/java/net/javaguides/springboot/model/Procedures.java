package net.javaguides.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="procedures")

public class Procedures {

    @Id
    private String ICD;
    private String nombre;
    private float costo;

    public Procedures() {
    }

    public Procedures(String ICD, String nombre, float costo) {
        this.ICD = ICD;
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getICD() {
        return ICD;
    }

    public void setICD(String ICD) {
        this.ICD = ICD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
