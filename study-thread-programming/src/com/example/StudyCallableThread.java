package com.example;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class StudyCallableThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var task = new LotteryCallableTask();
		var future = new FutureTask<>(task);
		var t1 = new Thread(future);
		t1.start();
		// var numbers = future.get(); //blocking: synchronization + solution
		List<Integer> numbers;
		do {
			try {
				numbers = future.get(10, TimeUnit.MILLISECONDS);
				System.err.println(numbers);
				break;
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				System.err.println("Working on an important task...");
			}
		} while (true);
	}

}

class LotteryCallableTask implements Callable<List<Integer>> {

	@Override
	public List<Integer> call() {
		return ThreadLocalRandom.current().ints(1, 60).distinct().limit(6).sorted().boxed()
				.collect(Collectors.toList());
	}

}