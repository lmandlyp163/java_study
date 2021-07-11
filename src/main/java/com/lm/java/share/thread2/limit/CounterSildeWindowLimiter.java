package com.lm.java.share.thread2.limit;

import com.sankuai.meituan.banma.biz.common.util.JsonUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author lm
 * @version 1.0
 * @desc CounterSildeWindowLimiter
 * @created 2021/7/7 下午4:37
 **/
public class CounterSildeWindowLimiter {
    /**
     * 每分钟限制请求数
     */
    private long permitsPerMinute;
    /**
     * 计数器, k-为当前窗口的开始时间值秒，value为当前窗口的计数
     */
    private final TreeMap<Long, Integer> counters;

    public CounterSildeWindowLimiter(long permitsPerMinute) {
        this.permitsPerMinute = permitsPerMinute;
        this.counters = new TreeMap<>();
    }

    public synchronized boolean tryAcquire() {
        // 获取当前时间的所在的子窗口值； 10s一个窗口
        long currentWindowTime =
                LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) / 10 * 10;
        // 获取当前窗口的请求总量
        int currentWindowCount = getCurrentWindowCount(currentWindowTime);
        if (currentWindowCount >= permitsPerMinute) {
            return false;
        }
        // 计数器 + 1
        counters.merge(currentWindowTime, 1, Integer::sum);
        return true;
    }

    /**
     * 获取当前窗口中的所有请求数（并删除所有无效的子窗口计数器）
     *
     * @param currentWindowTime 当前子窗口时间
     * @return 当前窗口中的计数
     */
    private int getCurrentWindowCount(long currentWindowTime) {
        // 计算出窗口的开始位置时间
        long startTime = currentWindowTime - 60;
        int result = 0;
        // 遍历当前存储的计数器，删除无效的子窗口计数器，并累加当前窗口中的所有计数器之和
        Iterator<Map.Entry<Long, Integer>> iterator =
                counters.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Integer> entry = iterator.next();
            if (entry.getKey() < startTime) {
                iterator.remove();
            } else {
                result += entry.getValue();
            }
        }
        System.out.println(JsonUtils.encode(counters));
        return result;
    }
    public static void main(String[] args) throws InterruptedException {
        CounterSildeWindowLimiter counterSildeWindowLimiter =
                new CounterSildeWindowLimiter(10);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (counterSildeWindowLimiter.tryAcquire()) {
                System.out.println(i + "--》成功");
                Thread.sleep(new Random().nextInt(10) * 1000);
            } else {
                System.out.println(i + "--》失败");
                Thread.sleep(new Random().nextInt(10) * 1000);
            }
        }
    }
}