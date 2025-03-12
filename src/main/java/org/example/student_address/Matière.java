package org.example.student_address;

import jakarta.persistence.*;

@Entity
@Table(name = "matieres")
public class Matière {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Matière(){}
    public Matière(String name) {
        this.name = name;
    }
    public Matière(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }


}
