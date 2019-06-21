
package com.xikou.promotion.constant;

public class PromotionTypeEnum {

	public static String getValue(String type) {
		for (PromotionType ele : PromotionType.values() ) {
			if(ele.getType().equals(type))
				return ele.getValue();
		}
		return type;
	}

/*	public static void main(String[] args) {
		System.out.println(ApiConstant.getValue("1"));
	}*/

		/**
         * 促销规则分类
         */
	public enum PromotionType {

			DISCOUNT("1", "折扣"),
			DIRECT_REDUCTION("2", "直减"),
			FULL_AMOUNT_MINUS("3", "满金额减"),
			LESS_PER_FULL_AMOUNT("4", "每满金额减"),
			LADDER_FULL_AMOUNT_REDUCTION("5", "阶梯满金额减"),
			FULL_QUANTITY_REDUCTION("6", "满数量减"),
			DECREASE_PER_FULL_QUANTITY("7", "每满数量减"),
			DECREASE_THE_NUMBER_OF_LADDERS_FULL("8", "阶梯满数量减"),
			FULL_QUANTITY_GIFT("9", "满数量贈"),
			GIFT_PER_FULL_QUANTITY("10", "每满数量贈"),
			THE_NUMBER_OF_LADDERS_IS_INCREASING("11", "阶梯满数量增"),
			FULL_AMOUNT_OF_GIFT("12", "满金额贈"),
			GIFT_PER_FULL_AMOUNT("13", "每满金额贈"),
			FULL_AMOUNT_OF_LADDER_GIFT("14", "阶梯满金额贈"),
			FULL_QUANTITY_DISCOUNT("15", "满数量折"),
			DISCOUNT_PER_FULL_QUANTITY("16", "每满数量折"),
			STEP_FULL_QUANTITY_DISCOUNT("17", "阶梯满数量折"),
			FULL_AMOUNT_DISCOUNT("18", "满金额折"),
			DISCOUNT_PER_FULL_AMOUNT("19", "每满金额折"),
			FULL_LADDER_DISCOUNT("20", "阶梯满金额折"),
			FULL_AMOUNT_DEDUCTION("21", "满金额抵扣"),
			FULL_QUANTITY_DEDUCTION("22", "满数量抵扣"),
			FULL_AMOUNT_EXCHANGE("23", "满金额换"),
			FULL_QUANTITY_EXCHANGE("24", "满数量换"),
			;

		//类型
		private String type;

		//值
		private String value;

			PromotionType(String type, String value) {
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

