package com.lm.java.study.mutilthread.s01_wait_notity.多生成多消费;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lm
 * @version 1.0
 * @desc TestRun
 * @created 2020/12/1 下午4:58
 **/
public class TestRun {

        public static void main(String[] args) {
            List list = new ArrayList();
            for (int i =1 ;i <=5 ; i++){
                Thread pt = new Thread(() -> {
                    Producer p = new Producer(list);
                    p.add();});
                pt.setName("线程"+i);
                pt.start();

                Thread ct = new Thread(() -> {
                    Comsumer c = new Comsumer(list);
                    c.remove();
                });
                ct.setName("线程"+i);
                ct.start();
            }
        }


}