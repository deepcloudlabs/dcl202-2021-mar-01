package com.example.lottery.application;

import com.example.lottery.model.LotteryViewModel;
import com.example.lottery.service.RandomNumberService;

public class LotteryApplication {

	public static void main(String[] args) throws Exception {
		var randomNumberService = new RandomNumberService();
		LotteryViewModel model = new LotteryViewModel();
		randomNumberService.generate(model);
		System.out.println(model.getNumbers());

	}

}
