package com.yuankun.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examine {
    protected Integer id;
    protected Integer student_id;
    protected String startdate;
    protected String enddate;
    protected String reason;
    protected String destination;
    protected String remark;
}
