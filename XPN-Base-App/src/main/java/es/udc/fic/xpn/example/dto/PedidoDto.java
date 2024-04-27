package es.udc.fic.xpn.example.dto;

import java.time.LocalDate;

public class PedidoDto {


    private Long id;

    private String dni;

    private String nombre;

    private String apellido;

    private Boolean entradaVip;

    private Float saldoPulsera;

    private String email;

    private LocalDate fechaNacimiento;

    private String direccion;

    private Boolean confirmado;

    public PedidoDto() {
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", entradaVip=" + entradaVip +
                ", saldoPulsera=" + saldoPulsera +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccion='" + direccion + '\'' +
                ", confirmado=" + confirmado +
                '}';
    }

    public PedidoDto(Long id, String dni, String nombre, String apellido, Boolean entradaVip, Float saldoPulsera,
                  String email, LocalDate fechaNacimiento, String direccion, Boolean confirmado){
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.entradaVip = entradaVip;
        this.saldoPulsera = saldoPulsera;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.confirmado = confirmado;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Boolean getEntradaVip() {
        return entradaVip;
    }

    public void setEntradaVip(Boolean entradaVip) {
        this.entradaVip = entradaVip;
    }

    public Float getSaldoPulsera() {
        return saldoPulsera;
    }

    public void setSaldoPulsera(Float saldoPulsera) {
        this.saldoPulsera = saldoPulsera;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }


}
