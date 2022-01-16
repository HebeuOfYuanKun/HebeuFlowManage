package com.yuankun.pojo.geography;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geometry {
    protected String Type;
    protected Double[][] Coordinates;
}
