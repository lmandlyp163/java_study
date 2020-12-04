package com.lm.java.study.mutilthread.s00_base.c01_JMM.指令重排;

/**
 * @author lm
 * @version 1.0
 * @desc PossibleReordering
 * @created 2020/12/3 下午3:51
 **/
public class PossibleReordering {
    private static int x = 0, y = 0;
    private static int a = 0, b =0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while(true) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;

            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });

            one.start();two.start();
            one.join();two.join();

            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }
}