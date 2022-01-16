package com.yuankun.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentStream {//今日流动情况类
    protected Integer SchoolLeave;
    protected Integer CityLeave;
    protected Integer ProvinceLeave;
    protected Integer SchoolEnter;
}
