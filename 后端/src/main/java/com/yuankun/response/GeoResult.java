package com.yuankun.response;

import com.yuankun.pojo.geography.Feature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GeoResult {
    protected String Type;
    protected List<Feature> features;
}
