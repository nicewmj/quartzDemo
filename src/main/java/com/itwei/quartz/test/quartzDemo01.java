package com.itwei.quartz.test;

/**
 *线程实现 定时
 */
public class quartzDemo01 {

    public static void main(String[] args) {
        final int[] cont = {0};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        cont[0]++;
                        System.out.println(">>>>>>start<<<<<<<<" + cont[0]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
