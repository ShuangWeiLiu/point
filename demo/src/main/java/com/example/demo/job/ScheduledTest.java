package com.example.demo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTest {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);
	 
    @Scheduled(cron="0/1 * 1 * * ?")
    public void executeTask1() {
 
        // 间隔2分钟,执行任务    
        Thread current = Thread.currentThread(); 
        System.out.println("定时任务1:"+current.getId());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }
    
    @Scheduled(cron="0/10 * 1 * * ?")
    public void executeTask2() throws InterruptedException {
 
        // 间隔2分钟,执行任务    
        Thread current = Thread.currentThread();
        System.out.println("定时任务2:"+current.getId() + "开始");
        Thread.sleep(20000L);
        System.out.println("定时任务2:"+current.getId() + "结束");
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务2:"+current.getId()+ ",name:"+current.getName());
    }
	
}
