package com.example.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfilerInterceptor implements InvocationHandler {
	private Object target;
	
	public ProfilerInterceptor(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var methodName = method.getName();
		var start = System.nanoTime();
		var result = method.invoke(target, args);
		var stop = System.nanoTime();
		System.err.println(String.format("%s runs %d ns.", methodName, (stop-start)));
		return result;
	}

}
