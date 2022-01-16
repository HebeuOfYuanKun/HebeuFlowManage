package com.yuankun.service;

import com.yuankun.pojo.Leave;
import com.yuankun.pojo.dto.Examine;
import com.yuankun.response.GeoResult;
import com.yuankun.response.Result;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface LeaveService {
    Result QueryAllLeave(String name,Integer id,String Examine, Integer currentPage, Integer sizep);
    Result QueryStudentStream();
    Result QueryLastWeek();

    Result QueryDayTime();
    Result QueryGeography(String Address);

    GeoResult QueryGeographyJson();

    GeoResult QueryCityPoint();
    Result UpdataExamine(Integer id,String examine);

    Result AddExamine(Examine examine);

    Result DeleteLeave(Integer[] ids);

    Result QueryLeaveById(Integer id);

    Result UpdateLeave(Leave leave);
}
