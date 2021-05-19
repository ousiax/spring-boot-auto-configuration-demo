package com.example;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class HelloTests {

	@Test
	public void testDefaultHello() throws SecurityException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		HelloImp hi = new HelloImp();
		hi.hello();
		String greeting = out.toString();
		assertEquals("Hello World!", greeting);
	}

	static class HelloImp implements Hello {
	}
}
