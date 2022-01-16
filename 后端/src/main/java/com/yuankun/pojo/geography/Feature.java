package com.yuankun.pojo.geography;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feature {
    protected String Type;
    protected Property Properties;
    protected Geometry Geometry;
}
