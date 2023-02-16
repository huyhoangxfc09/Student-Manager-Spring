package com.example.student.service;

import com.example.student.model.Classroom;
import com.example.student.model.Student;
import com.example.student.service.Impl.ICrud;
import java.util.ArrayList;
import java.util.List;


public class StudentService implements ICrud<Student> {
    static List<Student> studentList;
    ClassroomService classroomService;
    public StudentService(ClassroomService classroomService){
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"hoang",28,"thai binh",classroomService.findAll().get(0)));
        studentList.add(new Student(2,"lien",34,"nam dinh",classroomService.findAll().get(1)));
        studentList.add(new Student(3,"son",26,"hai phong",classroomService.findAll().get(2)));
        studentList.add(new Student(4,"vu",22,"hai duong",classroomService.findAll().get(3)));
        this.classroomService = classroomService;
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentList);
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public void update(int id, Student student) {
        studentList.set(id,student);
    }

    @Override
    public void delete(Student student) {
        studentList.remove(student);
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        for (Student e : studentList) {
            if(e.getId()==id){
                student = e;
                break;
            }
        }
        return student;
    }
}
