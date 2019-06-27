package com.xikou.promotion.constant;

import java.util.ArrayList;
import java.util.List;

public  class test {
    private static List<test> Type=new ArrayList();
    public Integer type;

    public String values;


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public test(Integer type, String values){
        this.type=type;
        this.values=values;
    }

    public static void main(String[] args) {

        List<test> PromotionToolType=PromotionToolType();

        PromotionToolType.sort((x, y) -> Integer.compare(y.getType(),x.getType()));//这方法需要jdk1.8以上

        for (test stu : PromotionToolType) {
            System.out.println(stu.getType());
        }
    }

    //促销工具类别
    public static List<test> PromotionToolType() {
        Type.add(new test(1, "优惠券"));
        Type.add(new test(7, "任务值"));
        Type.add(new test(3, "红包"));
        return  Type;
    }

}

