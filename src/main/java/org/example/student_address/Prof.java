package org.example.student_address;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profs")
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @ManyToMany(mappedBy = "profs")
    private List<Student> students = new ArrayList<>();

    public Prof() {}

    public Prof(String nom) {
        this.nom = nom;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addStudent(Student student) {
        students.add(student);
        student.getProfs().add(this);
    }
}
