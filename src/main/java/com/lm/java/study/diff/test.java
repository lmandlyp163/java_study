package com.lm.java.study.diff;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;

import java.util.Map;

/**
 * @author lm
 * @version 1.0
 * @desc test
 * @created 2021/7/12 下午4:01
 **/
public class test {
    public static void main(String[] args) throws Exception {
        demo1 demo1 = new demo1();
        demo1.setName("name1");
        demo1.setDesc("desc1");
        demo1.setValue(1);
        demo1.setList(Lists.newArrayList(1l,2l,3l));


        demo1 demo2 = new demo1();
        demo2.setName("name2");
        demo2.setDesc("desc2");
        demo2.setValue(2);
        demo2.setList(Lists.newArrayList(2l,3l));

        demo1.setListdemo(Lists.newArrayList(demo1,demo2));

//
//        List<DiffWapper> diffWappers = AbstractObjectDiff.generateDiff(demo1, demo2);
//        System.out.println(JsonUtils.encode(diffWappers));
//
//        System.out.println("==========");
//
//        String s = ChineseObjectDiff.genChineseDiffStr(demo1, demo2);
//        System.out.println(s);

        Map<String,Object> map1 = Maps.newHashMap();
        map1.put("名称",1);
        map1.put("描述","xx");
        Map<String,Object> map2 = Maps.newHashMap();
        map2.put("名称",2);
        map2.put("描述","yy");

        Javers javers = JaversBuilder.javers().build();
        Diff diff = javers.compare(demo1,demo2);
        System.out.println(diff.toString());


        Diff diffmap = javers.compare(map1,map2);
        System.out.println(diffmap.toString());
    }

}