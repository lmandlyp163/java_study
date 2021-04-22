package com.lm.java.study;

/**
 * @author lm
 * @version 1.0
 * @desc BmOperationResultEnum
 * @created 2020/9/27 下午2:39
 **/
public enum BmOperationResultEnum {

    SUCCESS(0, "成功"),
    FAIL(1, "失败");

    private int value;
    private String name;

    private BmOperationResultEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }


}