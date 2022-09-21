package com.mitocode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name ="examen")
@NamedQuery(name = "Examen.listAll", query = "SELECT ex FROM Examen ex ORDER BY ex.idExamen")
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen")
    private int idExamen;

    @Column(name="nombre", nullable= false, length=50)
    @Size(min=3, message="El nombre del examen debe contener 3-50 caracteres")
    private String nombre;

    @Column(name="descripcion", nullable= false, length=150)
    @Size(min=3, message="El nombre del examen debe contener 3-150 caracteres")
    private String descripcion;

    @Column(name = "estado")
    private Boolean estado;

    //Constructores especiales
    public Examen(int id) {
        this.idExamen = id;
    }

    public Examen() {
    }
}
