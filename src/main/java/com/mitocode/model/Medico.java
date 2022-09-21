package com.mitocode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "medicos")
@NamedQuery(name = "Medico.listAll", query = "SELECT m FROM Medico m ORDER BY m.idMedico")
public class Medico  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private int idMedico;

    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    @Column(name = "dui", nullable = false, length = 9)
    private String dui;

    @Column(name = "telefono", nullable = false, length = 8)
    private String telefono;

    @Email
    @Size(message = "Email debe hasta 150 caracteres en formato xxxxx@xxxxx.com")
    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "estado")
    private Boolean estado;

    public Medico(int id) {
        this.idMedico = id;
    }

    public Medico() {
    }
}
