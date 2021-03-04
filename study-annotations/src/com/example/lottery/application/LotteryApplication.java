package com.example.lottery.application;

import com.example.lottery.model.LotteryViewModel;

public class LotteryApplication {

	public static void main(String[] args) {
		LotteryViewModel model = new LotteryViewModel();
		System.out.println(model.getNumbers());

	}

}
