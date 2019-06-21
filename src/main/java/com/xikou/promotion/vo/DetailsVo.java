package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class DetailsVo implements Serializable {

    private static final long serialVersionUID = -2970827720074085112L;
    @ApiModelProperty(value = "ID",name = "id" )
        private String id;
        @ApiModelProperty(value = "引用值（规则详情删除之后的留规则值，规则包详情删除之后的规则包值）",name = "ValueRef" )
        private String ValueRef;
}
