package com.yuankun.service.Impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import com.yuankun.mapper.LeaveMapper;
import com.yuankun.pojo.Geocode;
import com.yuankun.pojo.Leave;
import com.yuankun.pojo.Role;
import com.yuankun.pojo.dto.Examine;
import com.yuankun.pojo.dto.LeaveRecord;
import com.yuankun.pojo.dto.StudentStream;
import com.yuankun.pojo.geography.Feature;
import com.yuankun.pojo.geography.Geometry;
import com.yuankun.pojo.geography.Property;
import com.yuankun.response.GeoResult;
import com.yuankun.response.Result;
import com.yuankun.service.LeaveService;
import com.yuankun.util.GetCoordination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private GetCoordination getCoordination;
    @Value("${yuankun.longitude}")
    private Double longitude;
    @Value("${yuankun.laitude}")
    private Double laitude;
    @Value("${yuankun.city}")
    private String city;
    @Value("${yuankun.province}")
    private String province;
    @Autowired
    private LeaveMapper leaveMapper;
    private final static String []times= {"00:00","03:00","06:00","09:00","12:00","15:00","18:00","21:00","24:00"};
    @Override
    public Result QueryAllLeave(String name,Integer id,String examine,Integer currentPage,Integer size) {
        Map<String,Object> map=new HashMap<>();
        map.put("Name",name);
        map.put("Id",id);
        map.put("Examine",examine);
        map.put("start",(currentPage-1)*size);
        map.put("end",currentPage*size);
        Result result=new Result();
        Map<Object, Object> ResMap = MapUtil.builder()
                .put("data",null)
                .put("TotalCount", 0)
                .build();
        Integer TotalCount=leaveMapper.FindAllLeaveRecordCount(map);
        if(TotalCount==0){
            result.setMsg("没有符合条件的记录");
            ResMap.replace("TotalCount",0);
            result.setObject(ResMap);
            result.setStateCode(50);
            return result;
        }else{
            List<LeaveRecord> leaveRecordList=leaveMapper.FindAllLeaveRecord(map);
            if(leaveRecordList==null){
                result.setMsg("没有符合条件的记录");
                result.setObject(ResMap);
                result.setStateCode(50);
            }else{
                result.setMsg("查询成功");
                ResMap.replace("data",leaveRecordList);
                ResMap.replace("TotalCount",TotalCount);
                result.setObject(ResMap);
                result.setStateCode(200);
            }
            return result;
        }
    }
    public Result QueryStudentStream(){
        Result result=new Result();
        String today= DateUtil.today();
        StudentStream studentStream=new StudentStream(leaveMapper.FindSchoolLeave(today),leaveMapper.FindCityLeave(today,city)
                ,leaveMapper.FindProvinceLeave(today,province),leaveMapper.FindSchoolEnter(today));
        result.setObject(studentStream);
        result.setMsg("查询成功");
        result.setStateCode(200);
        return result;
    }

    @Override
    public Result QueryLastWeek() {
        Result result=new Result();
        String today= DateUtil.today();
        Date date=DateUtil.parse(today);
        String lastWeek[]=new String[7];
        DateTime last1 = DateUtil.offsetDay(date, -1);
        lastWeek[6]=DateUtil.format(last1, "yyyy-MM-dd");
        DateTime last2 = DateUtil.offsetDay(date, -2);
        lastWeek[5]=DateUtil.format(last2, "yyyy-MM-dd");
        DateTime last3 = DateUtil.offsetDay(date, -3);
        lastWeek[4]=DateUtil.format(last3, "yyyy-MM-dd");
        DateTime last4 = DateUtil.offsetDay(date, -4);
        lastWeek[3]=DateUtil.format(last4, "yyyy-MM-dd");
        DateTime last5 = DateUtil.offsetDay(date, -5);
        lastWeek[2]=DateUtil.format(last5, "yyyy-MM-dd");
        DateTime last6 = DateUtil.offsetDay(date, -6);
        lastWeek[1]=DateUtil.format(last6, "yyyy-MM-dd");
        DateTime last7 = DateUtil.offsetDay(date, -7);
        lastWeek[0]=DateUtil.format(last7, "yyyy-MM-dd");
        StudentStream studentStreams[]=new StudentStream[7];
        Integer SchoolLeave[]=new Integer[7];
        Integer CityLeave[]=new Integer[7];
        Integer ProvinceLeave[]=new Integer[7];
        Integer SchoolEnter[]=new Integer[7];
        for (int i=0;i<7;i++){
            studentStreams[i]=new StudentStream(leaveMapper.FindSchoolLeave(lastWeek[i]),leaveMapper.FindCityLeave(lastWeek[i],city)
                    ,leaveMapper.FindProvinceLeave(lastWeek[i],province),leaveMapper.FindSchoolEnter(lastWeek[i]));
            SchoolLeave[i]=studentStreams[i].getSchoolLeave();
            CityLeave[i]=studentStreams[i].getCityLeave();
            ProvinceLeave[i]=studentStreams[i].getProvinceLeave();
            SchoolEnter[i]=studentStreams[i].getSchoolEnter();

        }
        Map<String,Object> map=new HashMap<>();
        map.put("SchoolLeave",SchoolLeave);
        map.put("CityLeave",CityLeave);
        map.put("ProvinceLeave",ProvinceLeave);
        map.put("SchoolEnter",SchoolEnter);
        map.put("LastWeek",lastWeek);
        /*List<Object> list=new ArrayList<>();
        list.add(SchoolLeave);
        list.add(CityLeave);
        list.add(ProvinceLeave);
        list.add(SchoolEnter);
        list.add(lastWeek);*/
        result.setObject(map);
        result.setMsg("查询成功");
        result.setStateCode(200);
        return result;
    }

    @Override
    public Result QueryDayTime() {
        Result result=new Result();
        String today= DateUtil.today();
        Integer []in=new Integer[8];
        Integer []out=new Integer[8];
        for(int i=0;i<8;i++){
            String timestart=today+ " " +times[i];
            String timeend=today+ " " +times[i+1];
            leaveMapper.FindDayTimeIn(timestart,timeend);

            in[i]=leaveMapper.FindDayTimeIn(timestart,timeend);
            out[i]=leaveMapper.FindDayTimeOut(timestart,timeend);


        }
        Map<String,Object> map=new HashMap<>();
        map.put("in",in);
        map.put("out",out);
        result.setStateCode(200);
        result.setMsg("查询成功");
        result.setObject(map);
        return result;
    }

    @Override
    public Result QueryGeography(String Address) {
        Result result=new Result();
        Geocode geocode=getCoordination.getCoordinate(Address);
        if(geocode==null){
            result.setObject(null);
            result.setMsg("查询失败");
            result.setStateCode(300);
        }else{
            result.setObject(geocode);
            result.setMsg("查询成功");
            result.setStateCode(200);
        }
        return result;

    }

    @Override
    public GeoResult QueryGeographyJson() {
        GeoResult geoResult=new GeoResult();
        geoResult.setType("FeatureCollection");
        Feature feature=new Feature();
        List<Feature> list= leaveMapper.FindAllFeatue();
        //System.out.println(list);
        //System.out.println("list的大小");
        //System.out.println(list.size());
        List<String> stringList=leaveMapper.FindAllCoordinates();
        //System.out.println(stringList.size());
        for (int i=0;i<list.size();i++) {

            Double[][] doubleList=new Double[2][2];
            doubleList[0][0]=longitude;
            doubleList[0][1]=laitude;
            doubleList[1][0]=Double.parseDouble(stringList.get(i).split(",")[0]);
            //System.out.println(stringList.get(i).split(",")[0]);
            doubleList[1][1]=Double.parseDouble(stringList.get(i).split(",")[1]);
            //System.out.println(stringList.get(i).split(",")[1]);

            //System.out.println(doubleList);
            Geometry geometry=list.get(i).getGeometry();
            geometry.setCoordinates(doubleList);
            list.get(i).setGeometry(geometry);
        }
        /*Feature properties=list.get(0);
        Geometry geometry=properties.getGeometry();
        Double [][] a={{116.405285,39.904989},{115.482331,38.867657}};
        geometry.setCoordinates(a);
        properties.setGeometry(geometry);
        list.set(0,properties);*/

        /*feature.setProperties("");*/
        geoResult.setFeatures(list);
        /*System.out.println(leaveMapper.FindAllFeatue());*/
        return geoResult;
    }

    @Override
    public GeoResult QueryCityPoint() {
        GeoResult geoResult=new GeoResult();
        geoResult.setType("FeatureCollection");
        List<Feature> list= leaveMapper.FindAllFeatue();
        List<String> stringList=leaveMapper.FindAllCoordinates();
        for (int i=0;i<list.size();i++) {

            Double[][] doubleList=new Double[1][2];
            doubleList[0][0]=Double.parseDouble(stringList.get(i).split(",")[0]);
            doubleList[0][1]=Double.parseDouble(stringList.get(i).split(",")[1]);
            Geometry geometry=list.get(i).getGeometry();
            geometry.setCoordinates(doubleList);
            geometry.setType("Point");
            Property property=list.get(i).getProperties();
            property.setType(2);
            list.get(i).setProperties(property);
            list.get(i).setGeometry(geometry);

        }
        geoResult.setFeatures(list);
        return geoResult;
    }

    @Override
    public Result UpdataExamine(Integer id,String examine) {
        Result result=new Result();
        Integer count=leaveMapper.UpdataExamine(id,examine);
        if(count==0){
            result.setObject(null);
            result.setMsg("更新失败");
            result.setStateCode(300);
        }else{
            result.setObject(null);
            result.setMsg("更新成功");
            result.setStateCode(200);
        }

        return result;
    }

    @Override
    public Result AddExamine(Examine examine) {
        Result result=new Result();
        Integer integer=leaveMapper.AddExamine(examine);
        Geocode geocode=getCoordination.getCoordinate(examine.getDestination());
        Map<String,Object> map=new HashMap<>();
        map.put("leave_id",examine.getId());
        map.put("location",geocode.getLocation());
        Integer count=leaveMapper.AddFeature(map);
        //System.out.println(geocode.getLocation());
        if(integer==null||integer==0){
            result.setObject(null);
            result.setMsg("申请失败");
            result.setStateCode(300);
        }else{
            result.setObject(null);
            result.setMsg("申请成功");
            result.setStateCode(200);
        }
        return result;
    }

    @Override
    public Result DeleteLeave(Integer[] ids) {
        Result result=new Result();
        Integer integer=leaveMapper.DeleteLeave(ids);
        if(integer==null||integer==0){
            result.setObject(null);
            result.setMsg("删除失败");
            result.setStateCode(300);
        }else{
            result.setObject(null);
            result.setMsg("删除成功");
            result.setStateCode(200);
        }
        return result;
    }

    @Override
    public Result QueryLeaveById(Integer id) {
        Result result=new Result();
        Leave leave=leaveMapper.FindLeaveById(id);
        if(leave==null){
            result.setObject(null);
            result.setMsg("查询失败");
            result.setStateCode(300);

        }else{
            result.setObject(leave);
            result.setMsg("查询成功");
            result.setStateCode(200);
        }
        return result;
    }

    @Override
    public Result UpdateLeave(Leave leave) {
        Result result=new Result();
        Integer integer=leaveMapper.UpdateLeave(leave);
        if(integer==0||integer==null){
            result.setObject(null);
            result.setMsg("修改失败");
            result.setStateCode(300);
        }else{
            result.setObject(null);
            result.setMsg("修改成功");
            result.setStateCode(200);
        }
        return result;
    }
}
