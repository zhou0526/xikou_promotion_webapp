
package com.xikou.promotion.constant;

public class CustomizeTypeEnum {

	public static String getValue(String type) {
		for (CustomizeType ele : CustomizeType.values()) {
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
	 * 个性化规则分类
	 */
	public enum CustomizeType {

		Ranking_method("1", "排名方式"),
		User_purchase_restrictions("2", "用户购买限制");


		// 类型
		private String type;

		// 值
		private String value;

		CustomizeType(String type, String value) {
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
