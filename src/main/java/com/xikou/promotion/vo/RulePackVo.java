package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@ApiModel(value = "规则包Vo对象", description = "规则包Vo对象")
public class RulePackVo implements Serializable {

    private static final long serialVersionUID = 3358192203303544868L;
    @ApiModelProperty(value = "规则包Id", name = "id", example = "主键ID(采用分布式ObjectId生成策略 24位长度)")
    private String id;
    @ApiModelProperty(value = "规则包分类", name = "packType", example = "")
    private Byte packType;
    @ApiModelProperty(value = "规则包名称", name = "packName", example = "")
    private String packName;
    @ApiModelProperty(value = "规则包值", name = "packValueRef", example = "")
    private String packValueRef;
    @ApiModelProperty(value = "是否删除", name = "isDeleted", example = "")
    private Byte isDeleted;
    @ApiModelProperty(value = "创建时间", name = "ruleValueRef", example = "")
    private Date createTime;
    @ApiModelProperty(value = "修改时间", name = "ruleValueRef", example = "")
    private Date updateTime;
}
