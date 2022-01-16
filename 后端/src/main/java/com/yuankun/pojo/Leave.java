package com.yuankun.pojo;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave {//请假表
    protected Integer Id;
    protected Integer Student_Id;
    protected String StartDate;
    protected String EndDate;
    protected String IsLeave;
    protected String Destination;
    protected String Reason;
    protected String Remark;
    protected String Evidence;
    protected String Statues;
    protected String Examine;
}
