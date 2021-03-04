package com.example.service.business;

import com.example.service.Calculator;

public class StandardCalculator implements Calculator {
	private Calculator self = this;
	
	public void setSelf(Calculator self) {
		this.self = self;
	}

	@Override
	public double add(double x, double y) {
		return x+y;
	}

	@Override
	public double sub(double x, double y) {
		return x-y;
	}

	@Override
	public double mul(double x, double y) {
		var sum = 0.;
		for (var i=x;i>0;i--)
			sum = self.add(sum,y);
		return sum;
	}

	@Override
	public double div(double x, double y) {
		return x/y;
	}

}
