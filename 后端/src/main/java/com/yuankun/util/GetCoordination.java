package com.yuankun.util;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yuankun.pojo.Geocode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

@Component
public class GetCoordination {
    @Value("${yuankun.mapkey}")
    private String mapkey;
    public  Geocode getCoordinate(String Stringunitaddr) {
        /*System.out.println(mapkey);
        System.out.println("要查询的地名："+Stringunitaddr);*/

        //去掉中文地址中的空白字符
        String unitaddr=Stringunitaddr.replaceAll("\\s*", "");

        //高德地图api
        String url = "https://restapi.amap.com/v3/geocode/geo?key="+mapkey+"&address=" + unitaddr;

        String json = loadJSON(url);
        /*System.out.println("开始执行高德接口："+url);
        System.out.println("高德返回的json："+json);*/
        if (json != null && !"".equals(json)) {

            //先把String对象转换成json对象
            JSONObject obj= JSONUtil.parseObj(json);


            if ("1".equals(obj .getStr("status"))) {
                //查询成功情况
                /*System.out.println("成功返回的信息："+obj);
                System.out.println(obj.getJSONArray("geocodes"));
                System.out.println(obj.getJSONArray("geocodes").getJSONObject(0));*/
                Geocode geocode=JSONUtil.toBean(obj.getJSONArray("geocodes").getJSONObject(0),Geocode.class);
                //System.out.println(obj.getJSONArray("geocodes").getJSONObject(0).getJSONObject("location"));
                //String location[]=obj.getJSONArray("geocodes").getJSONObject(0).getStr("location").split(",");
                //System.out.println(location);
                /*double lng = obj .getJSONObject("geocodes").getJSONObject("location").getDouble("lng"); // 经度
                double lat = obj .getJSONObject("geocodes").getJSONObject("location").getDouble("lat"); // 纬度*/
                /*Double lng=Double.parseDouble(location[0]);
                Double lat=Double.parseDouble(location[1]);
                DecimalFormat df = new DecimalFormat("#.######");
                System.out.println(df.format(lng) + "," + df.format(lat));*/

                //return df.format(lng)+","+df.format(lat);
                return geocode;

            }else {
                //查询失败情况
                if ("0".equals(obj .getStr("status"))) {
                    //未找到地理位置信息
                    //System.out.println("未找到地理位置返回的信息："+obj);
                    return null;
                }else if("302".equals(obj .getStr("status"))){
                    System.out.println("配额超限返回的信息："+obj);
                    //每天配额超标的情况
                    return null;
                }
            }
        }

        return null;
    }
    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return json.toString();
    }
}
