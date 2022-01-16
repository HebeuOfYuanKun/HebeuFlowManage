package com.yuankun.mapper;

import com.yuankun.pojo.Role;
import com.yuankun.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    void DeleteStudent();
    Integer QueryAllStudentCount(String Name);
    List<Student> QueryAllStudent(Map<String,Object> map);
    @Select("select * from student where id = #{id}")
    Student QueryStudentById(String id);
    @Update("update student set name=#{Name},grade=#{Grade},sex=#{Sex},college=#{College},phone=#{Phone}" +
            " where id=#{id}")
    Integer UpdateStudent(Student student);
    @Insert("insert student(name,id,sex,college,phone) values(#{Name},#{Id}," +
            "#{Sex},#{College},#{Phone})")
    Integer AddStudent(Student student);
    Integer DeleteStudents(String[] ids);
    //List<Student> QueryStudentByName(String Name);
}
