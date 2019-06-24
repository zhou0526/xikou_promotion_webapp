package com.xikou.promotion.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "规则Vo对象", description = "规则Vo对象")
public class RuleTypeVo implements Serializable {

	private static final long serialVersionUID = -5242846074385908910L;
	@ApiModelProperty(value = "键", name = "type", example = "")
	private String type;
	@ApiModelProperty(value = "值", name = "values", example = "")
	private String values;
	@ApiModelProperty(value = "工具引用标识", name = "CitationClassification", example = "")
	public String CitationClassification;

}
