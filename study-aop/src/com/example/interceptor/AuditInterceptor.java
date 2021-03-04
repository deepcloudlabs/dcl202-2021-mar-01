package com.example.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class AuditInterceptor implements InvocationHandler {
	private Object target;
	
	public AuditInterceptor(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var now = new Date();
		var methodName = method.getName();
		System.err.println(String.format("%s is called at %s.", methodName, now));
		System.err.println("Parameters are "+Arrays.toString(args));
		var result = method.invoke(target, args);
		System.err.println(String.format("%s return %s.", methodName, result));
		return result;
	}

}
