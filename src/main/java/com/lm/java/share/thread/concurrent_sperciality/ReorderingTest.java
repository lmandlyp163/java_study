package com.lm.java.share.thread.concurrent_sperciality;

/**
 * @author lm
 * 预期结果:(0,1)(1,1)(1,0)
 **/
public class ReorderingTest {
    private static int x = 0, y = 0;
    private static int a = 0, b =0;
    public static void main(String[] args) throws Exception {
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