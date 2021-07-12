package com.lm.java.study.diff;

import com.fastobject.diff.DiffLog;
import lombok.Data;

import java.util.List;

/**
 * @author lm
 * @version 1.0
 * @desc demo1
 * @created 2021/7/12 下午4:00
 **/
@Data
public class demo2 {

    @DiffLog(name = "名称")
    private String name;

    @DiffLog(name = "描述")
    private String desc;

    @DiffLog(name = "值")
    private Integer value;

    private List<Long> list;

}