package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@ApiModel(value = "规则Vo对象", description = "规则Vo对象")
public class RuleVo implements Serializable {
    private static final long serialVersionUID = 7142256210406609700L;
    @ApiModelProperty(value = "规则Id", name = "id", example = "主键ID(采用分布式ObjectId生成策略 24位长度)")
    private String id;
    @ApiModelProperty(value = "规则分类", name = "ruleType", example = "")
    private String ruleType;
    @ApiModelProperty(value = "规则子类引用", name = "ruleChildRef", example = "")
    private String ruleChildRef;
    @ApiModelProperty(value = "促销工具类别", name = "toolTypeId", example = "")
    private String toolTypeId;
    @ApiModelProperty(value = "规则名称", name = "toolTypeId", example = "")
    private String ruleName;
    @ApiModelProperty(value = "规则值引用", name = "ruleValueRef", example = "")
    private String ruleValueRef;
    @ApiModelProperty(value = "是否删除", name = "isDeleted", example = "")
    private Byte isDeleted;
    @ApiModelProperty(value = "创建时间", name = "ruleValueRef", example = "")
    private Date createTime;
    @ApiModelProperty(value = "修改时间", name = "ruleValueRef", example = "")
    private Date updateTime;
}
