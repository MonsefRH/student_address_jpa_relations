package org.example.student_address;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Matière> matieres= new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "prof_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "prof_id")
    )
    private List<Prof> profs = new ArrayList<>();

    public Student() {}

    public Student(String name){
        this.name = name;
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
    public List<Matière> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matière> matieres) {
        this.matieres = matieres;
    }

    public List<Prof> getProfs() {
        return profs;
    }

    public void setProfs(List<Prof> profs) {
        this.profs = profs;
    }
    public Address getAddresses() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
        address.setStudent(this);
    }
    public void addMatière(Matière matière) {
        this.matieres.add(matière);
        matière.setStudent(this);
    }
    public void addProf(Prof prof) {
        profs.add(prof);
        prof.getStudents().add(this);
    }


}

