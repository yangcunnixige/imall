package com.yangnan.mall;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {

        Date date = new Date();
        Timer timer = new Timer();
        //匿名内部类
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTest.run");
            }
        }, date, 24*60*60*1000);
        // 24*60*60*1000
    }
}