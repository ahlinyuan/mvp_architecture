package com.ahlinyuan.mvp.mvp.model;

/**
 * 枚举类
 */
public class Enums {

    //响应状态码
    public enum ResponseCode {
        SUCCESS(1);

        public int value;

        ResponseCode(int value) {
            this.value = value;
        }
    }
}
