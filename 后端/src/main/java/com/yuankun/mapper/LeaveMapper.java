package com.yuankun.mapper;

import com.yuankun.pojo.Leave;
import com.yuankun.pojo.dto.Examine;
import com.yuankun.pojo.dto.LeaveRecord;
import com.yuankun.pojo.geography.Feature;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface LeaveMapper {
    //@Select("select * from leave")
    List<LeaveRecord> FindAllLeaveRecord(Map<String,Object> map);
    Integer FindAllLeaveRecordCount(Map<String,Object> map);
    @Select("select count(student_id) from `leave` where startdate like concat(\"%\",#{today},\"%\")")
    Integer FindSchoolLeave(@Param("today") String today);
    @Select("select count(student_id) from `leave` where startdate like concat(\"%\",#{today},\"%\") and destination not like concat(\"%\",#{city},\"%\")")
    Integer FindCityLeave(@Param("today") String today,@Param("city") String city);
    @Select("select count(student_id) from `leave` where startdate like concat(\"%\",#{today},\"%\") and destination not like concat(\"%\",#{province},\"%\")")
    Integer FindProvinceLeave(@Param("today") String today,@Param("province") String province);
    @Select("select count(student_id) from `leave` where enddate like concat(\"%\",#{today},\"%\")")
    Integer FindSchoolEnter(@Param("today") String today);
    @Select("select count(student_id) from `leave` where startdate >= #{timestart} and startdate < #{timeend}")
    Integer FindDayTimeOut(@Param("timestart") String timestart,@Param("timeend")String timeend);
    @Select("select count(student_id) from `leave` where enddate >= #{timestart} and startdate < #{timeend}")
    Integer FindDayTimeIn(@Param("timestart") String timestart,@Param("timeend")String timeend);
    List<Feature> FindAllFeatue();
    @Select("select geometry_coordinates from feature")
    List<String> FindAllCoordinates();
    @Update("update `leave` set examine=#{examine}" +
            " where id=#{id}")
    Integer UpdataExamine(Integer id,String examine);

    Integer AddExamine(Examine examine);
    Integer DeleteLeave(Integer [] ids);
    Integer AddFeature(Map<String,Object> map);
    @Select("select * from `leave` where id=#{id}")
    Leave FindLeaveById(Integer id);
    @Update("update `leave` set startdate=#{StartDate} , enddate=#{EndDate},isleave=#{IsLeave}," +
            "destination=#{Destination},reason=#{Reason},remark=#{Remark},evidence=#{Evidence}," +
            "statues=#{Statues},examine=#{Examine} where id=#{id}")
    Integer UpdateLeave(Leave leave);
}
