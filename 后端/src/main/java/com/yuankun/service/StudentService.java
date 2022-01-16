package com.yuankun.service;

import com.yuankun.pojo.Student;
import com.yuankun.response.Result;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    Result QueryAllStudent(String name, Integer CurrentPage, Integer Size);

    Result QueryStudentById(String id);
    Result UpdateStudent(Student student);
    Result AddStudent(Student student);
    Result DeleteManyStudent(String[] ids);
    //Result QueryStudentByName(String name);
}
