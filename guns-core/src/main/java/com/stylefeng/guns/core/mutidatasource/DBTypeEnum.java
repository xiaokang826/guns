package com.stylefeng.guns.core.mutidatasource;

/**
 * @Author DGD
 * @date 2018/2/7.
 */
public enum DBTypeEnum {

    guns("dataSourceGuns"), item("dataSourceBiz");

    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}