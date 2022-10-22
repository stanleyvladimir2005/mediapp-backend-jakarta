package com.mitocode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
@Table(name = "paciente")
@NamedQuery(name = "Paciente.listAll", query = "SELECT p FROM Paciente p ORDER BY p.idPaciente")

public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
    @Column(name = "nombres", nullable = true, length = 70)
    private String nombres;

    @Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")
    @Column(name = "apellidos", nullable = true, length = 70)
    private String apellidos;

    @Size(min = 9, max = 9, message = "DNI debe tener 9 caracteres")
    @Column(name = "dui", nullable = false, length = 9)
    private String dui;

    @Size(min = 3, max = 150, message = "Direccion debe tener minimo 3 caracteres")
    @Column(name = "direccion", length = 150)
    private String direccion;

    @Size(min = 8, max = 8, message = "Telefono debe tener 9 caracteres")
    @Column(name = "telefono", length = 8)
    private String telefono;

    @Email
    @Size(message = "Email debe hasta 150 caracteres en formato xxxxx@xxxxx.com")
    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "estado")
    private Boolean estado;

    //Constructores especiales
    public Paciente(int id) {
        this.idPaciente = id;
    }

    public Paciente() {
    }
}