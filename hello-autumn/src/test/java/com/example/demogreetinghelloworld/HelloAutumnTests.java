package com.example.demogreetinghelloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.example.autumn.HelloAutumn;

import org.junit.jupiter.api.Test;

public class HelloAutumnTests {

	@Test
	public void testHelloAutumn() throws SecurityException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		HelloAutumn hi = new HelloAutumn();
		hi.hello();
		String greeting = out.toString();
		assertEquals("Hello Autumn!", greeting);
	}
}
