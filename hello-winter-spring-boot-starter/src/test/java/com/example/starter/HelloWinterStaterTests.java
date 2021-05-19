package com.example.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.example.Hello;
import com.example.autoconfigure.HelloAutoConfiguration;
import com.example.winter.HelloWinter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

public class HelloWinterStaterTests {
	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withConfiguration(AutoConfigurations.of(HelloAutoConfiguration.class));

	@Test
	void testHelloWorld() {
		ConditionEvaluationReportLoggingListener initializer = new ConditionEvaluationReportLoggingListener(
				LogLevel.DEBUG);
		contextRunner.withInitializer(initializer).run(ctx -> {
			Hello hi = ctx.getBean(Hello.class);
			assertNotNull(hi);
			assertSame(HelloWinter.class, hi.getClass());

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));
			hi.hello();
			String text = out.toString();
			assertEquals("Hello Winter!", text);
		});
	}
}
