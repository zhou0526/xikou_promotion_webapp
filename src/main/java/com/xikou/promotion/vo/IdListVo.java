package com.xikou.promotion.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class IdListVo implements Serializable {

    private static final long serialVersionUID = -2020061814643364139L;
    @ApiModelProperty(value = "批量id", name = "ids", example = "批量操作id集合")
    private List<String> ids;

}
