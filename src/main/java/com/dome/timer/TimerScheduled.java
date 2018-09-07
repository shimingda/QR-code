package com.dome.timer;

import org.springframework.stereotype.Component;

/**
 * 定时器任务
 */
@Component
public class TimerScheduled {
//    @Scheduled(fixedRate = 3000)
    public void runTime(){
        System.out.println("running");
    }
}
