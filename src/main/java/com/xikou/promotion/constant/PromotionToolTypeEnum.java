
package com.xikou.promotion.constant;

public class PromotionToolTypeEnum {

	public static String getValue(String type) {
		for (PromotionToolType ele : PromotionToolType.values() ) {
			if(ele.getType().equals(type))
				return ele.getValue();
		}
		return type;
	}

/*	public static void main(String[] args) {
		System.out.println(ApiConstant.getValue("1"));
	}*/

		/**
         * 促销工具类别
         */
	public enum PromotionToolType {

            COUPON("1", "优惠券"),
            TASKVALUE("2", "任务值"),
            REDENVELOPES("3", "红包"),
            GIFT("4", "赠品"),
            REPLACEMENT("5", "换品"),
            INTEGRAL("6", "积分")
			     ;

		//类型
		private String type;

		//值
		private String value;

            PromotionToolType(String type, String value) {
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

