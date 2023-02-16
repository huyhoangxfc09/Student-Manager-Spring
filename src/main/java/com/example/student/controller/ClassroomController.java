package com.example.student.controller;

import com.example.student.model.Classroom;
import com.example.student.service.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller // Đây là 1 lớp controller
@RequestMapping("/classroom")
// Khai báo URL cho lớp Controller tương ứng
public class ClassroomController {
    ClassroomService classroomService;
    public ClassroomController(){
        classroomService = new ClassroomService();
    }
    @GetMapping
    public String listClassroom(Model model){
        List<Classroom> classroomList = classroomService.findAll();
        model.addAttribute("classroom",classroomList);
        return "/classroom/list";
    }
    @GetMapping("/create")
    public String createForm(){
        return "/classroom/create";
    }
    @PostMapping("/create")
    public String createClassroom(HttpServletRequest request,Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Classroom classroom = new Classroom(id,name);
        classroomService.save(classroom);
        model.addAttribute("message","Tạo mới thành công");
        return "/classroom/create";
    }
    @GetMapping("/update")
    public String updateForm(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Classroom classroom = classroomService.findById(id);
        model.addAttribute("classroom",classroom);
        return "/classroom/update";
    }
    @PostMapping("/update")
    public String updateClassroom(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Classroom classroom = classroomService.findById(id);
        int index = classroomService.findAll().indexOf(classroom);
        Classroom newClassroom = new Classroom(name);
        classroomService.update(index,newClassroom);
        model.addAttribute("classroom",newClassroom);
        model.addAttribute("message","Update thành công");
        return "/classroom/update";
    }
    @GetMapping("/delete")
    public String deleteForm(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Classroom classroom = classroomService.findById(id);
        model.addAttribute("classroom",classroom);
        return "/classroom/delete";
    }
    @PostMapping("/delete")
    public String deleteClassroom(HttpServletRequest request,Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Classroom classroom = classroomService.findById(id);
        classroomService.delete(classroom);
        model.addAttribute("message","Xóa thành công");
        return "/classroom/delete";
    }
}
