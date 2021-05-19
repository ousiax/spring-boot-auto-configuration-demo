package com.example.autoconfigure;

import java.lang.reflect.InvocationTargetException;

import com.example.Hello;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Hello.class)
@ConditionalOnMissingBean(Hello.class)
public class HelloAutoConfiguration {
	private final String AUTUMN_CLS = "com.example.autumn.HelloAutumn";
	private final String WINTER_CLS = "com.example.winter.HelloWinter";

	@Bean
	@ConditionalOnClass(name = AUTUMN_CLS)
	public Hello helloAutumn() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Hello hi = (Hello) Class.forName(AUTUMN_CLS).getConstructor().newInstance();
		return hi;
	}

	@Bean
	@ConditionalOnClass(name = WINTER_CLS)
	public Hello helloWinter() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Hello hi = (Hello) Class.forName(WINTER_CLS).getConstructor().newInstance();
		return hi;
	}

	// @Bean
	// @ConditionalOnMissingClass({ AUTUMN_CLS, WINTER_CLS })
	// public Hello helloWorld() {
	// return new Hello() {
	// };
	// }
}
