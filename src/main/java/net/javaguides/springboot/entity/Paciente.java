package net.javaguides.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "numero")
    private String numero;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "seguro")
    private String seguro;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "nombre_contacto")
    private String nombreContacto;

    @Column(name = "numero_contacto")
    private String numeroContacto;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Column(name = "profesion")
    private String profesion;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    public Paciente() {

    }

    public Paciente(String nombre, String apellido, String email, String numero, String direccion, String identificacion, String seguro, String fechaNacimiento, String nombreContacto, String numeroContacto, String estadoCivil, String profesion, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numero = numero;
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.seguro = seguro;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreContacto = nombreContacto;
        this.numeroContacto = numeroContacto;
        this.estadoCivil = estadoCivil;
        this.profesion = profesion;
        this.nacionalidad = nacionalidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
