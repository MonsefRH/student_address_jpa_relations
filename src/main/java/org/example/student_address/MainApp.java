package org.example.student_address;

public class MainApp {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Address address= new Address("av kenidi", "Safi");
        Prof prof1 = new Prof("Mohamed" );
        Prof prof2 = new Prof("Amine" );

        Student student = new Student("Monsef");
        student.setAddress(address);
        Matière matiere1= new Matière("web2.0");
        Matière matiere2= new Matière("AI");
        student.addMatière(matiere1);
        student.addMatière(matiere2);
        student.addProf(prof1);
        student.addProf(prof2);
        studentDAO.save(student);

        // update de student
        Student fetchedStudent = studentDAO.findById(student.getId());
        if (fetchedStudent != null) {
            fetchedStudent.setName("Monsef Updated");
            studentDAO.save(fetchedStudent);
        }

        System.out.println("Données insérées et mises à jour avec succès !");
    }
}

