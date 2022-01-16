package com.yuankun.pojo.geography;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    protected Integer Type;
    protected Double Ratio;
    protected Double LineWidthRatio;
}
