package com.yuankun;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yuankun.mapper.LeaveMapper;
import com.yuankun.mapper.MenuMapper;
import com.yuankun.mapper.RoleMapper;
import com.yuankun.mapper.UserMapper;
import com.yuankun.pojo.User;
import com.yuankun.pojo.dto.UserTable;
import com.yuankun.response.Result;
import com.yuankun.service.MenuService;
import com.yuankun.util.GetCoordination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@SpringBootTest
class Spring20210716ApplicationTests {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuService menuService;
    @Autowired
    private GetCoordination getCoordination;
    @Autowired
    private LeaveMapper leaveMapper;
    @Test
    void testdate(){
        String today= DateUtil.today();
        today="2222-01-31";
        System.out.println(today);

        DateTime date = DateUtil.parse(today,"yyyy-MM-dd");
        System.out.println(date);
        DateTime d=DateUtil.lastWeek();
        System.out.println(d);
        String format = DateUtil.format(date, "yyyy-MM-dd HH-mm-ss");
        System.out.println(format);
        /*DateTime date1 = DateUtil.parse(today,"yyyy-MM-dd HH-mm-ss");
        System.out.println(date1);*/
        /*DateTime newDate2 = DateUtil.offsetDay(format, 3);
        System.out.println(newDate2);*/
    }
    @Test
    void queryAllFeatures(){
        //System.out.println(leaveMapper.FindAllFeatue());
        String s="{{1.0,2.6,3.5,5.9},{1.0,4.0}}";
        //System.out.println(Double.(s));
        Double a[][]={{1.0,2.6,3.5,5.9},{1.0,4.0}};
        List<String> stringList=leaveMapper.FindAllCoordinates();
        Double[][] doubleList=new Double[stringList.size()*2][2];
        doubleList[0][0]=Double.parseDouble(stringList.get(0).split(",")[0]);
        System.out.println(doubleList[0][0]);
        doubleList[0][1]=Double.parseDouble(stringList.get(0).split(",")[1]);
        System.out.println(doubleList[0][1]);
        System.out.println(leaveMapper.FindAllCoordinates());

    }
    @Test
    void contextLoads() {
        //System.out.println(menuMapper.QueryAllMenu());
        //System.out.println(userMapper.QueryByUserName("admin"));
        //System.out.println(roleMapper.QueryRoleByName("用户"));
        //System.out.println(menuService.QueryAlLMenu());
        /*Calendar instance=new GregorianCalendar();
        instance.add(Calendar.SECOND,1000);
        String token= JWT.create()
                .withClaim("username","xiaoming")
                .withClaim("userid","123456")
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("yuankun"));
        System.out.println(token);*/
        //System.out.println(new Date());
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("111111");
        String encode1 = bCryptPasswordEncoder.encode("1234567");
        System.out.println("加密后"+encode1);
        boolean matches = bCryptPasswordEncoder.matches("1234567", "$2a$10$0ilP4ZD1kLugYwLCs4pmb.ZT9cFqzOZTNaMiHxrBnVIQUGUwEvBI");
        //Result result=new Result();
        System.out.println("是否匹配"+matches);
        //result.setObject(encode);
    }
    @Test
    void TestJwt(){
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256("yuankun")).build();
        DecodedJWT decodedJWT= jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDExOTIwOTEsInVzZXJpZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoieGlhb21pbmcifQ.GSzEClcWfLZEel6FV8xJ9ENbOfSL-m838l8044cAKm");
        System.out.println(decodedJWT.getClaim("username").asString());
        System.out.println(decodedJWT.getClaim("userid").asString());
    }
    @Test
    void TestListToString(){
        List<String> list=new ArrayList<>();
        list.add("小米");
        list.add("小米");
        list.add("小米");
        System.out.println("---------"+list);
        String aa=String.join(",",list);
        System.out.println("--------"+aa);
    }
    @Test
    void TestFather(){
        User user=new UserTable();
        user.setId(1);
        user.setUserName("小米");
        UserTable userTable= (UserTable) user;
        System.out.println(userTable);
        userTable.setUserRole(Arrays.asList(new String[]{"aa", "aaa"}));
        System.out.println(userTable);
    }
    @Test
    void timeTest(){
        System.out.println(DateUtil.date());
    }
    @Test
    void testLocation(){

        System.out.println(getCoordination.getCoordinate("Sjjsj"));

    }

}
