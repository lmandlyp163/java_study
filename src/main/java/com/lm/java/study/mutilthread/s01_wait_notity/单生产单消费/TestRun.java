package com.lm.java.study.mutilthread.s01_wait_notity.单生产单消费;

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

            new Thread(() -> {
                Producer p = new Producer(list);
                p.add();
            }).start();

            new Thread(()->{
                Comsumer c = new Comsumer(list);
                c.remove();
            }).start();


        }


}