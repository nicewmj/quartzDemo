package com.itwei.quartz.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.xml.validation.SchemaFactory;
import java.util.Date;

public class StartQuartz {
    public static void main(String[] args) throws SchedulerException {
        //创建工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //从工厂中获取调度实例
        Scheduler scheduler = sf.getScheduler();
        //创建jobdetail
        JobDetail jb =  JobBuilder.newJob(MyJob.class)
                .withDescription("this is a ram job")//job 的描述
                .withIdentity("ramJob","ramGroup")//job 的name和group
                .build();

        //任务运行的时间，SimpleSchedle类型触发器有效
        long time = System.currentTimeMillis() + 3*1000L;//3秒之后启动
        Date startTime = new Date(time);
        //4.创建Trigger
        //使用SimpleScheduleBuilder或者CronScheduleBuilder

        Trigger t =  TriggerBuilder.newTrigger()
                .withDescription("")
                .withIdentity("ramTigger","ramTriggerGroup")
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                .startAt(startTime)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))//两秒执行一次
                .build();

        //5.注册任务和定时器
        scheduler.scheduleJob(jb,t);
        //6.启动 调度器
        scheduler.start();
    }
}
