package com.example.demo.component;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.demo.domain.DemoEvent;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    /**
     * 使用onApplicationEvent 方法对消息进行接受处理。
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("我(bean-demoListener)接受到了bean-demoPublisher发布的消息:" + msg);
        System.out.println("发生事件的对象是：" + event.getSource());
    }
}