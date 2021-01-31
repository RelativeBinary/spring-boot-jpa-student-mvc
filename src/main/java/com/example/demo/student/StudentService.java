package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student s) throws IllegalAccessException {
        Optional<Student> sEmail = studentRepository.findStudentByEmail(s.getEmail());
        if(sEmail.isPresent()){
            throw new IllegalAccessException("email taken.");
        }
        studentRepository.save(s);
    }

    public void deleteStudent(Long id) throws IllegalAccessException {
        Optional<Student> s = studentRepository.findById(id);
        if(!s.isPresent()){
            throw new IllegalAccessException("student doesnt exist");
        }
        studentRepository.deleteById(id);
    }

    //Allows us to update the the entity in a manageable state
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student s = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student doesnt exist"));

        if(name != null && name.length() > 0 && !Objects.equals(s.getName(), name)) {
            s.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(s.getEmail(), name)) {
            Optional<Student> sO = studentRepository.findStudentByEmail(email);
            if(sO.isPresent()){
                throw new IllegalStateException("email taken");
            }
            s.setEmail(email);
        }
    }
}
