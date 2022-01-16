package com.yuankun.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student {//学生
    protected Integer Id;
    protected String Name;
    protected String Grade;
    protected String Sex;
    protected String College;
    protected String Phone;

}
