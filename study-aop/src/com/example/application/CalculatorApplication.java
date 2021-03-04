package com.example.application;

import java.lang.reflect.Proxy;

import com.example.interceptor.AuditInterceptor;
import com.example.interceptor.ProfilerInterceptor;
import com.example.service.Calculator;
import com.example.service.business.StandardCalculator;

public class CalculatorApplication {

	public static void main(String[] args) {
		var standardCalculator = new StandardCalculator();
		Calculator calculator = standardCalculator;
		var profilerInterceptor = new ProfilerInterceptor(calculator);
		var clazz = calculator.getClass();
		var loader = clazz.getClassLoader();
		var interfaces = clazz.getInterfaces();
		calculator = (Calculator) Proxy.newProxyInstance(loader, interfaces, profilerInterceptor);
		var auditInterceptor = new AuditInterceptor(calculator);
		calculator = (Calculator) Proxy.newProxyInstance(loader, interfaces, auditInterceptor);
		standardCalculator.setSelf(calculator);
		System.err.println("5*10= "+calculator.mul(5, 10));
		// System.err.println("3+5= "+calculator.add(3, 5));
		// System.err.println("3-5= "+calculator.sub(3, 5));
		// System.err.println("3/5= "+calculator.div(3, 5));
	}

}
