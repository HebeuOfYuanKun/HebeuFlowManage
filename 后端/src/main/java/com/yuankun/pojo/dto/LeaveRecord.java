package com.yuankun.pojo.dto;

import cn.hutool.core.date.DateTime;
import com.yuankun.pojo.Leave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRecord {
    protected Integer Id;
    protected String Name;
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
