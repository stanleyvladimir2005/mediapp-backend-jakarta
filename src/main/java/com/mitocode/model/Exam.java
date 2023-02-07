package com.mitocode.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name ="exam")
@NamedQuery(name = "Exam.listAll", query = "SELECT ex FROM Exam ex ORDER BY ex.idExam")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exam")
    private Integer idExam;

    @Column(name="exam_name", nullable= false, length=50)
    @Size(min=3)
    private String examName;

    @Column(name="description", nullable= false, length=150)
    @Size(min=3)
    private String description;

    @Column(name = "status")
    private Boolean status;

    public Exam(int id) {
        this.idExam = id;
    }
}