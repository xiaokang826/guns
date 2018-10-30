package com.stylefeng.guns.core.mutidatasource;

/**
 * @Author DGD
 * @date 2018/2/7.
 */
public enum DBTypeEnum {

    guns("guns"),
    item("item"),
    report("report"),
    gold("gold"),
    domino("domino"),
    niuniu("niuniu");

    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
