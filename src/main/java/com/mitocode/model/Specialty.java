package com.mitocode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Table(name="specialty")
@NoArgsConstructor
@Data
@NamedQuery(name = "Specialty.listAll", query = "SELECT spe FROM Specialty spe ORDER BY spe.idSpecialty")
public class Specialty implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_specialty")
    private Integer idSpecialty;

    @Column(name = "specialty_name", nullable = false, length = 50)
    @Size(min=3)
    private String specialtyName;

    @Column(name = "status")
    private Boolean status;

    public Specialty(int id) {
        this.idSpecialty = id;
    }
}