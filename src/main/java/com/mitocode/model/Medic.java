package com.mitocode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "medic")
@NamedQuery(name = "Medic.listAll", query = "SELECT m FROM Medic m ORDER BY m.idMedic")
public class Medic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medic")
    private Integer idMedic;

    @Column(name = "first_name", nullable = false, length = 70)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 70)
    private String lastName;

    @Column(name = "dui", nullable = false, length = 9)
    private String dui;

    @Column(name = "phone", nullable = false, length = 8)
    private String phone;

    @Email
    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "status")
    private Boolean status;

    public Medic(int id) {
        this.idMedic = id;
    }
}