package com.yuankun.pojo;

import com.yuankun.pojo.geography.Building;
import com.yuankun.pojo.geography.Neighborhood;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geocode {
    protected String Country;
    protected String Province;
    protected String CityCode;
    protected String City;
    protected String District;
    protected String TownShip;
    protected Neighborhood neighborhood;
    protected Building building;
    protected String Adcode;
    protected String Street;
    protected String Number;
    protected String Location;
    protected String Level;
}
