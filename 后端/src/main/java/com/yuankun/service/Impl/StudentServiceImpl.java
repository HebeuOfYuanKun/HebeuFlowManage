package com.yuankun.service.Impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import com.yuankun.mapper.StudentMapper;
import com.yuankun.pojo.Role;
import com.yuankun.pojo.Student;
import com.yuankun.response.Result;
import com.yuankun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Result QueryAllStudent(String name, Integer currentPage, Integer size) {
        Map<String,Object> map=new HashMap<>();
        map.put("Name",name);
        map.put("start",(currentPage-1)*size);
        map.put("end",currentPage*size);
        Result result=new Result();
        Map<Object, Object> ResMap = MapUtil.builder()
                .put("data",null)
                .put("TotalCount", 0)
                .build();
        Integer TotalCount=studentMapper.QueryAllStudentCount(name);
        if(TotalCount==0){
            result.setMsg("没有符合条件的记录");
            ResMap.replace("TotalCount",0);
            result.setObject(ResMap);
            result.setStateCode(50);
            return result;
        }else{
            List<Student> studentList=studentMapper.QueryAllStudent(map);
            if(studentList==null){
                result.setMsg("没有符合条件的记录");
                result.setObject(ResMap);
                result.setStateCode(50);
            }else{
                result.setMsg("查询成功");
                ResMap.replace("data",studentList);
                ResMap.replace("TotalCount",TotalCount);
                result.setObject(ResMap);
                result.setStateCode(200);
            }
            return result;
        }
    }

    @Override
    public Result QueryStudentById(String id) {
        Student student= studentMapper.QueryStudentById(id);
        Result result=new Result();
        if(student==null){
            result.setStateCode(50);
            result.setObject(null);
            result.setMsg("没有符合条件的记录");
        }else{
            result.setStateCode(200);
            result.setObject(student);
            result.setMsg("查询成功");
        }
        return result;
    }

    @Override
    public Result UpdateStudent(Student student) {
        //student.setUpdated(DateUtil.date());
        Integer ResNum=studentMapper.UpdateStudent(student);
        Result result=new Result();
        if(ResNum==0){
            result.setMsg("操作失败");
            result.setStateCode(52);
            result.setObject(null);
        }else{
            result.setMsg("操作成功");
            result.setStateCode(200);
            result.setObject(null);
        }
        return result;
    }

    @Override
    public Result AddStudent(Student student) {
        Integer ResId=studentMapper.AddStudent(student);
        Result result=new Result();
        if(ResId==null){
            result.setMsg("操作失败");
            result.setStateCode(52);
            result.setObject(null);
        }else{
            result.setMsg("操作成功");
            result.setStateCode(200);
            result.setObject(null);
        }
        return result;
    }
    @Override
    public Result DeleteManyStudent( String[] ids) {

        Integer ResId=studentMapper.DeleteStudents(ids);
        //System.out.println("ResId"+ResId);
        Result result=new Result();
        if(ResId==0){
            result.setMsg("操作失败");
            result.setStateCode(52);
            result.setObject(null);
        }else{
            result.setMsg("操作成功");
            result.setStateCode(200);
            result.setObject(null);
        }
        return result;
    }
    /*public Result QueryStudentByName(String name){
        List<Student> studentList =studentMapper.QueryStudentByName(name);
        //System.out.println("ResId"+ResId);
        Result result=new Result();
        if(studentList.size()==0){
            result.setMsg("操作失败");
            result.setStateCode(52);
            result.setObject(null);
        }else{
            result.setMsg("操作成功");
            result.setStateCode(200);
            result.setObject(studentList);
        }
        return result;
    }*/
}
