package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name="procedures")

public class Procedures {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "costo")
    private float costo;

    public Procedures() {
    }

    public Procedures(long id, String nombre, float costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
