package com.itwei.quartz.test;

import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用TimerTask类实现定时任务
 */
public class quartzDemo02 {

    public static void main(String[] args) {
        final int[] cont = {0};
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                cont[0]++;
                System.out.println(">>>>>>>start<<<<<<"+ cont[0]);

            }
        };
        Timer timer = new Timer();
        //天数
        long day = 0 ;
        //秒数
        long perid =1000;
        timer.scheduleAtFixedRate(timerTask,day,perid);

    }

}
