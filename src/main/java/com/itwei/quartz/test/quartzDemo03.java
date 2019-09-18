package com.itwei.quartz.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * \使用ScheduledExecutorService是从Java
 * JavaSE5的java.util.concurrent里，做为并发工具类被引进的
 * ，这是最理想的定时任务实现方式。
 */
public class quartzDemo03 {
    public static void main(String[] args) {
        Runnable runnable =  new Runnable() {
            @Override
            public void run() {
                //任务从这里开始运行
                System.out.println(">>>>>>>>start<<<<<<");
            }
        };
        ScheduledExecutorService service =
                Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
       service.scheduleAtFixedRate(runnable,1,1, TimeUnit.SECONDS);

    }
}
