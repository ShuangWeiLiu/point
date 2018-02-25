package com.example.demo.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ThreadPoolTest {
	
	public static void main(String[] args) {
//		System.out.println("1");
		Runnable myRunnable = new Runnable() {
		    @Override
		    public void run() {
		        try {
		            Thread.sleep(2000);
		            System.out.println(Thread.currentThread().getName() + " run");
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		    }
		};
		
		// SynchronousQueue
		// LinkedBlockingDeque
		// ArrayBlockingQueue
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("yes-pool-%d").build();
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
		
		try {
			System.out.println("----开始----");
			System.out.println("核心线程数" + executor.getCorePoolSize());
			System.out.println("线程池数" + executor.getPoolSize());
			System.out.println("队列任务数" + executor.getQueue().size());
			
			executor.execute(myRunnable);
			executor.execute(myRunnable);
			executor.execute(myRunnable);
			executor.execute(myRunnable);
			System.out.println("---先开4个---");
			System.out.println("核心线程数" + executor.getCorePoolSize());
			System.out.println("线程池数" + executor.getPoolSize());
			System.out.println("队列任务数" + executor.getQueue().size());
			executor.execute(myRunnable);
			executor.execute(myRunnable);
			executor.execute(myRunnable);
			executor.execute(myRunnable);
			System.out.println("---再开4个---");
			System.out.println("核心线程数" + executor.getCorePoolSize());
			System.out.println("线程池数" + executor.getPoolSize());
			System.out.println("队列任务数" + executor.getQueue().size());
			Thread.sleep(8000);
			System.out.println("----8秒之后----");
			System.out.println("核心线程数" + executor.getCorePoolSize());
			System.out.println("线程池数" + executor.getPoolSize());
			System.out.println("队列任务数" + executor.getQueue().size());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
