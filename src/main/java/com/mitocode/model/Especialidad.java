package com.mitocode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.io.Serializable;

@Entity
@Table(name="especialidad")
@Data
@NamedQuery(name = "Especialidad.listAll", query = "SELECT esp FROM Especialidad esp ORDER BY esp.idEspecialidad")

public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;

    @Column(name = "nombre", nullable = false, length = 50)
    @Size(min=3, message ="El nombre de la especialidad debe contener 3-50 caracteres")
    private String nombre;

    @Column(name = "estado")
    private Boolean estado;

    //Constructores especiales
    public Especialidad(int id) {
        this.idEspecialidad = id;
    }

    public Especialidad() {
    }
}