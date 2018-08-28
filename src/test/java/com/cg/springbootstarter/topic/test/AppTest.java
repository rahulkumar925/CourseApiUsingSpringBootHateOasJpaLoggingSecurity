package com.cg.springbootstarter.topic.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.springbootstarter.hello.HelloController;

public class AppTest {

	@Test
	public void test() {
		HelloController hc = new HelloController();
		String result = hc.sayHello();
		assertEquals(result, "Hi");
	}

}
