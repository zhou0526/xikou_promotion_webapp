
package com.xikou.promotion.constant;

public class DisplayModeTypeEnum {

	public static String getValue(String type) {
		for (DisplayModeType ele : DisplayModeType.values()) {
			if (ele.getType().equals(type))
				return ele.getValue();
		}
		return type;
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(ApiConstant.getValue("1")); }
	 */

	/**
	 * 展示方式规则分类
	 */
	public enum DisplayModeType {

		activity_commodity_type("1", "活动商品规则分类"),
		display_mode_type("2", "展示方式规则分类"),
		promotion_type("3", "促销规则分类"),
		customize_type("4", "个性化规则");

		// 类型
		private String type;

		// 值
		private String value;

		DisplayModeType(String type, String value) {
			this.type = type;
			this.value = value;

		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
