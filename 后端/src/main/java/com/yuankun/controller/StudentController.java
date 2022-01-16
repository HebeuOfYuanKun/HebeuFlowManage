package com.yuankun.controller;

import com.yuankun.pojo.Role;
import com.yuankun.pojo.Student;
import com.yuankun.response.Result;
import com.yuankun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PreAuthorize("hasAuthority('stream:manage:student')")
    @GetMapping("/student")
    public Result QueryAllRole(@RequestParam(value = "Name",required = false) String Name,
                               @RequestParam(value = "CurrentPage",required = false,defaultValue = "1") Integer CurrentPage,
                               @RequestParam(value = "Size", required = false,defaultValue = "10") Integer Size){
        return studentService.QueryAllStudent(Name,CurrentPage,Size);
    }
    @PreAuthorize("hasAuthority('stream:manage:student')")
    @GetMapping("/student/{id}")
    public Result QueryStudentById(@PathVariable String id){
        return studentService.QueryStudentById(id);
    }
    @PreAuthorize("hasAuthority('stream:manage:student:update')")
    @PutMapping("/student")
    public Result UpdateStudent(@RequestBody Student student){
        return studentService.UpdateStudent(student);
    }
    @PreAuthorize("hasAuthority('stream:manage:student:save')")
    @PostMapping("/student")
    public Result AddStudent(@RequestBody Student student){
        return studentService.AddStudent(student);
    }
    @PreAuthorize("hasAuthority('stream:manage:student:delete')")
    @DeleteMapping("/student")
    public Result DeleteManyStudent(String[] ids){
        return studentService.DeleteManyStudent(ids);
    }
    /*@GetMapping("/student/name/{name}")
    public Result QueryStudentByName(@PathVariable String name){
        return studentService.QueryStudentByName(name);
    }*/
}
