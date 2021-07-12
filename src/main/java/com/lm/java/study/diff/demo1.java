package com.lm.java.study.diff;

import lombok.Data;
import lombok.ToString;
import org.javers.core.metamodel.annotation.PropertyName;

import java.util.List;

/**
 * @author lm
 * @version 1.0
 * @desc demo1
 * @created 2021/7/12 下午4:00
 **/
@Data
@ToString
public class demo1 {

    @PropertyName("名称")
    private String name;

    @PropertyName("描述")
    private String desc;

    @PropertyName("结果值")
    private Integer value;

    @PropertyName("list对象")
    private List<Long> list;


    @PropertyName("listdemo对象")
    private List<demo1> listdemo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    public List<demo1> getListdemo() {
        return listdemo;
    }

    public void setListdemo(List<demo1> listdemo) {
        this.listdemo = listdemo;
    }
}