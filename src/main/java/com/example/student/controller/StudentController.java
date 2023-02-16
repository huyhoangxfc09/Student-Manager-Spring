package com.example.student.controller;

import com.example.student.model.Classroom;
import com.example.student.model.Student;
import com.example.student.service.ClassroomService;
import com.example.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller // Đây là 1 lớp controller
@RequestMapping("/student")
public class StudentController {
    static ClassroomService classroomService;
    static StudentService studentService;
    public StudentController(){
        classroomService = new ClassroomService();
        studentService = new StudentService(classroomService);
    }
    @GetMapping
    public String listClassroom(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("student",students);
        return "/student/list";
    }
    @GetMapping("create")
    public String createForm(Model model){
        model.addAttribute("classroom",classroomService.findAll());
        return "/student/create";
    }
    @PostMapping("/create")
    public String createStudent(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        int idClassroom = Integer.parseInt(request.getParameter("classroom"));
        Student student = new Student(id,name,age,address,classroomService.findById(idClassroom));
        studentService.save(student);
        model.addAttribute("message","Tạo mới thành công");
        return "/student/create";
    }
    @GetMapping("/update")
    public String updateForm(HttpServletRequest request, Model model){
       int id = Integer.parseInt(request.getParameter("id"));
       Student student = studentService.findById(id);
       model.addAttribute("classroom",classroomService.findAll());
       model.addAttribute("student",student);
       return "/student/update";
    }
    @PostMapping ("update")
        public  String update(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        int idClassroom = Integer.parseInt(request.getParameter("classroom"));
        int index = studentService.findAll().indexOf(student);
        Student newStudent = new Student(name,age,address,classroomService.findById(idClassroom));
        studentService.update(index,newStudent);
        model.addAttribute("student",newStudent);
        model.addAttribute("classroom",classroomService.findAll());
        model.addAttribute("message","Update thành công");
        return "/student/update";
    }
    @GetMapping("delete")
    public String deleteForm(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        return "/student/delete";
    }
    @PostMapping("/delete")
    public String deleteStudent(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        studentService.delete(student);
        model.addAttribute("message","Xóa thành công");
        return "/student/delete";
    }

}
