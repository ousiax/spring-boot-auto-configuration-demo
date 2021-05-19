package com.example.demogreetinghelloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.example.Hello;
import com.example.winter.HelloWinter;

import org.junit.jupiter.api.Test;

public class HelloWinterTests {

	@Test
	public void helloWinter() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Hello hi = new HelloWinter();
		hi.hello();
		assertEquals("Hello Winter!", out.toString());
	}

}
