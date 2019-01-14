package com.ahlinyuan.mvp.mvp.model.models;

/**
 * 基础对象Model
 */
public class BaseEntityModel<T> extends BaseModel {

    //对象
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
