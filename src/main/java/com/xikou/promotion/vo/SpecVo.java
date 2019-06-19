package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@ToString
@ApiModel(value = "规格Vo对象", description = "规格Vo对象")
public class SpecVo implements Serializable {
    private static final long serialVersionUID = -862029278460989229L;
    @ApiModelProperty(value = "规格Id", name = "id", example = "主键ID(采用分布式ObjectId生成策略 24位长度)")
    private String id;
    @ApiModelProperty(value = "规格名称", name = "specName", example = "")
    private String specName;
    @ApiModelProperty(value = "起始值", name = "initValue", example = "")
    private Integer initValue;
    @ApiModelProperty(value = "到达值", name = "targetValue", example = "")
    private Integer targetValue;
    @ApiModelProperty(value = "偏移值", name = "offsetValue", example = "")
    private Integer offsetValue;
    @ApiModelProperty(value = "是否删除", name = "isDeleted", example = "")
    private Byte isDeleted;
    @ApiModelProperty(value = "创建时间", name = "ruleValueRef", example = "")
    private Date createTime;
    @ApiModelProperty(value = "修改时间", name = "ruleValueRef", example = "")
    private Date updateTime;
}
