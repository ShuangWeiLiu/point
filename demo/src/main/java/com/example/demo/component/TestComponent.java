package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {
	private int count = 0;
	
	public void yell() {
		System.out.println("i am a compent");
		count++;
		System.out.println("-----count:" + count);
	}
	
}
