package com.yuankun.controller;

import com.yuankun.pojo.Leave;
import com.yuankun.pojo.dto.Examine;
import com.yuankun.response.GeoResult;
import com.yuankun.response.Result;
import com.yuankun.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class LeaveController {
    @Autowired
    private LeaveService leaveService;
    @PreAuthorize("hasAuthority('stream:manage:outschool:examine')")
    @GetMapping("/Leave")
    public Result QueryAllLeave(@RequestParam(value = "Name",required = false) String Name,
                                @RequestParam(value = "Id",required = false) Integer Id,
                                @RequestParam(value = "Examine",required = false) String Examine,
                                @RequestParam(value = "CurrentPage",required = false,defaultValue = "1") Integer CurrentPage,
                                @RequestParam(value = "Size", required = false,defaultValue = "10") Integer Size) {
        return leaveService.QueryAllLeave(Name,Id,Examine,CurrentPage, Size);
    }
    @PreAuthorize("hasAuthority('stream:manage:outschool:examine')")
    @GetMapping("/Leave/{id}")
    public Result QueryLeaveById(@PathVariable Integer id) {
        return leaveService.QueryLeaveById(id);
    }
    @PreAuthorize("hasAuthority('stream:manage:outschool:examine:updata')")
    @PutMapping("/Leave")
    public Result UpdateLeave(@RequestBody Leave leave) {
        return leaveService.UpdateLeave(leave);
    }
    @PreAuthorize("hasAuthority('stream:manage:outschool:examine:delete')")
    @DeleteMapping("/Leave")
    public Result DeleteLeave(Integer[] ids) {
        return leaveService.DeleteLeave(ids);
    }
    @PreAuthorize("hasAuthority('stream:manage:student')")
    @GetMapping("/StudentStream")
    public Result QueryStudentStream(){
        return leaveService.QueryStudentStream();
    }
    @PreAuthorize("hasAuthority('data:lastweek:list')")
    @GetMapping("/LastWeek")
    public Result QueryLastWeek(){
        return leaveService.QueryLastWeek();
    }
    @PreAuthorize("hasAuthority('data:today:list')")
    @GetMapping("/DayTime")
    public Result QueryDayTime(){
        return leaveService.QueryDayTime();
    }
    //@PreAuthorize("hasAuthority('data:today:list')")
    @GetMapping("/Address/{Address}")
    public Result QueryGeography(@PathVariable String Address){
        /*System.out.println(Address);*/
        return leaveService.QueryGeography(Address);
    }
    //@PreAuthorize("hasAuthority('data:today:list')")
    @GetMapping("/GeographyJson")
    public GeoResult QueryGeographyJson(){
        return leaveService.QueryGeographyJson();
    }

    @GetMapping("/CityPoint")
    public GeoResult QueryCityPoint(){
        return leaveService.QueryCityPoint();
    }
    @PreAuthorize("hasAuthority('stream:manage:outschool:examine:updata')")
    @PutMapping("/examine/{id}/{examine}")
    public Result UpdataExamine(@PathVariable Integer id,@PathVariable String examine){
        return leaveService.UpdataExamine(id,examine);
    }
    @PreAuthorize("hasAuthority('stream:manage:outschool:examine:save')")
    @PostMapping("/examine")
    public Result AddExamine(@RequestBody Examine examine){
        //System.out.println(examine);
        return leaveService.AddExamine(examine);
    }
}
