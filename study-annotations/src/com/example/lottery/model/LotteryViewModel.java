package com.example.lottery.model;

import java.util.List;

public class LotteryViewModel {
	// metadata
	// @RandomNumber(min=1,max=60,size=6,sorted=true,unique=true)
	@RandomNumber
	private List<Integer> numbers;

	public LotteryViewModel() {
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
	
}
