package com.mitocode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patient")
@NamedQuery(name = "Patient.listAll", query = "SELECT p FROM Patient p ORDER BY p.idPatient")
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Integer idPatient;

    @Size(min = 3)
    @Column(name = "first_name", length = 70)
    private String firstName;

    @Size(min = 3)
    @Column(name = "last_name", length = 70)
    private String lastName;

    @Size(min = 9, max = 9)
    @Column(name = "dui", nullable = false, length = 9)
    private String dui;

    @Size(min = 3, max = 150)
    @Column(name = "address", length = 150)
    private String address;

    @Size(min = 8, max = 8)
    @Column(name = "phone", length = 8)
    private String phone;

    @Email
    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "status")
    private Boolean status;

    public Patient(int id) {
        this.idPatient = id;
    }
}