package com.cleancodecamp.async;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import lombok.Getter;

public class MyAsyncUncaughtExceptionHandler implements
AsyncUncaughtExceptionHandler {
	
	@Getter
	private static Map<String, Throwable> thrownExceptions = new HashMap<>();

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		thrownExceptions.put(method.getName(), ex);
	}

}
