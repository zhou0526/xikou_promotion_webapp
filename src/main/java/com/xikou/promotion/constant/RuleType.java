package com.xikou.promotion.constant;

import java.util.ArrayList;
import java.util.List;

public class RuleType {
	private static List<RuleType> Type = null;
	public String type;

	public String values;

	// 促销工具类别(1: 优惠券 2: 任务值 3:红包 4: 赠品 5: 换品 6： 积分 ) ;
	public String CitationClassification;// 1:(不需要促销工具) 2（5: 换品） 3（1: 优惠券 3: 红包 4: 赠品 6： 积分） 4（1:
											// 优惠券 3: 红包 6： 积分）

	public String getCitationClassification() {
		return CitationClassification;
	}

	public void setCitationClassification(String citationClassification) {
		CitationClassification = citationClassification;
	}

	public RuleType(String type, String values) {
		this.type = type;
		this.values = values;
	}

	public RuleType(String type, String values, String CitationClassification) {
		this.type = type;
		this.values = values;
		this.CitationClassification = CitationClassification;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	// 规则类型
	public static List<RuleType> RuleType() {
		Type = new ArrayList();
		Type.add(new RuleType("1", "活动商品规则分类"));
		Type.add(new RuleType("2", "促销规则分类"));
		Type.add(new RuleType("3", "个性化规则"));
		Type.add(new RuleType("4", "展示方式规则分类"));
		return Type;
	}

	// 促销规则分类
	public static List<RuleType> PromotionType() {
		Type = new ArrayList();
		Type.add(new RuleType("1", "折扣", "1"));
		Type.add(new RuleType("2", "直减", "1"));
		Type.add(new RuleType("3", "满金额减", "1"));
		Type.add(new RuleType("4", "每满金额减", "1"));
		Type.add(new RuleType("5", "阶梯满金额减", "1"));
		Type.add(new RuleType("6", "满数量减", "1"));
		Type.add(new RuleType("7", "每满数量减", "1"));
		Type.add(new RuleType("8", "阶梯满数量减", "1"));
		Type.add(new RuleType("9", "满数量贈", "3"));
		Type.add(new RuleType("10", "每满数量贈", "3"));
		Type.add(new RuleType("11", "阶梯满数量贈", "3"));
		Type.add(new RuleType("12", "满金额贈", "3"));
		Type.add(new RuleType("13", "每满金额贈", "3"));
		Type.add(new RuleType("14", "阶梯满金额贈", "3"));
		Type.add(new RuleType("15", "满数量折", "1"));
		Type.add(new RuleType("16", "阶梯满数量折", "1"));
		Type.add(new RuleType("17", "满金额折", "1"));
		Type.add(new RuleType("18", "阶梯满金额折", "1"));
		Type.add(new RuleType("19", "满金额抵扣", "3"));
		Type.add(new RuleType("20", "满数量抵扣", "3"));
		Type.add(new RuleType("21", "满金额换", "2"));
		Type.add(new RuleType("22", "满数量换", "2"));
		return Type;
	}

	// 活动商品规则分类
	public static List<RuleType> ActivityCommodityType() {
		Type = new ArrayList();

		return Type;
	}

	// 个性化规则分类
	public static List<RuleType> CustomizeType() {
		Type = new ArrayList();
		return Type;
	}

	// 展示方式规则分类
	public static List<RuleType> DisplayModeType() {
		Type = new ArrayList();
		return Type;
	}

	// 促销工具类别
	public static List<RuleType> PromotionToolType() {
		Type = new ArrayList();
		Type.add(new RuleType("1", "优惠券"));
		Type.add(new RuleType("2", "任务值"));
		Type.add(new RuleType("3", "红包"));
		Type.add(new RuleType("4", "赠品"));
		Type.add(new RuleType("5", "换品"));
		Type.add(new RuleType("6", "积分"));
		return Type;
	}

	// 促销工具类别
	public static List<RuleType> PromotionToolType1() {
        Type= new ArrayList();
        return Type;
	}

	// 促销工具类别
	public static List<RuleType> PromotionToolType2() {
        Type= new ArrayList();
        Type.add(new RuleType("5", "换品"));
		return Type;
	}

	// 促销工具类别
	public static List<RuleType> PromotionToolType3() {
        Type= new ArrayList();
        Type.add(new RuleType("1", "优惠券"));
		Type.add(new RuleType("3", "红包"));
		Type.add(new RuleType("4", "赠品"));
		Type.add(new RuleType("6", "积分"));
		return Type;
	}

	// 促销工具类别
	public static List<RuleType> PromotionToolType4() {
        Type= new ArrayList();
        Type.add(new RuleType("1", "优惠券"));
		Type.add(new RuleType("3", "红包"));
		Type.add(new RuleType("6", "积分"));
		return Type;
	}
}
