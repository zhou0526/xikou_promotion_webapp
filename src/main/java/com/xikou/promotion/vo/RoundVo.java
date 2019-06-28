package com.xikou.promotion.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "活动场次vo", description = "活动场次vo")

public class RoundVo implements Serializable {

    private static final long serialVersionUID = 5339767461078891287L;

    @ApiModelProperty(value = "场次Id")
    private String id;

    @ApiModelProperty(value = "活动Id")
    private String activityId;

    @ApiModelProperty(value = "场次标题")
    private String roundTitle;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "状态：1：有效，2：无效")
    private Integer state;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}