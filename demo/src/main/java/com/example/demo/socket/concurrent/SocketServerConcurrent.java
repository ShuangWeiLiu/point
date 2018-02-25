package com.example.demo.socket.concurrent;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServerConcurrent {
	
	/**
	 * 创建的线程会交给线程池来处理
	 * 线程复用，创建线程耗时，回收线程慢
	 * 防止短时间内高并发，指定线程池大小，超过数量将等待，方式短时间创建大量线程导致资源耗尽，服务挂掉
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// 监听指定的端口
	    int port = 55533;
	    ServerSocket server = new ServerSocket(port);
	    // server将一直等待连接的到来
	    System.out.println("server将一直等待连接的到来");

	    //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
	    ExecutorService threadPool = Executors.newFixedThreadPool(100);
	    
	    while (true) {
		      Socket socket = server.accept();
		      
		      Runnable runnable=()->{
		        try {
		          // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
		          InputStream inputStream = socket.getInputStream();
		          byte[] bytes = new byte[1024];
		          int len;
		          StringBuilder sb = new StringBuilder();
		          while ((len = inputStream.read(bytes)) != -1) {
		            // 注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
		            sb.append(new String(bytes, 0, len, "UTF-8"));
		          }
		          System.out.println("get message from client: " + sb);
		          inputStream.close();
		          socket.close();
//		          server.close(); // 不能关闭，重复用
		        } catch (Exception e) {
		          e.printStackTrace();
		        }
		      };
		      
		      threadPool.submit(runnable);
	    }
	    
	    
	}
	
}
