package com.example.student.service;

import com.example.student.model.Classroom;
import com.example.student.service.Impl.ICrud;

import java.util.ArrayList;
import java.util.List;

public class ClassroomService implements ICrud<Classroom> {
    static List<Classroom> classroomList;
    public ClassroomService(){
        classroomList =new ArrayList<>();
        classroomList.add(new Classroom(1,"C0822G1"));
        classroomList.add(new Classroom(2,"C0922H1"));
        classroomList.add(new Classroom(3,"C01022I1"));
        classroomList.add(new Classroom(4,"C1122K1"));
    }
    @Override
    public List<Classroom> findAll() {
        return classroomList;
    }

    @Override
    public void save(Classroom classroom) {
        classroomList.add(classroom);
    }

    @Override
    public void update(int id, Classroom classroom) {
        classroomList.set(id,classroom);
    }

    @Override
    public void delete(Classroom classroom) {
        classroomList.remove(classroom);
    }

    @Override
    public Classroom findById(int id) {
        Classroom classroom = null;
        for (Classroom e : classroomList) {
          if(e.getId()==id){
              classroom = e;
              break;
          }
        }
        return classroom;
    }
}
