package com.example;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class StudyExecutors {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// CPU-Bound -> Logical processor (8)
		// IO-Bound (disk, networking)    (8 * 16)
		// CPU+IO-Bound
		// GPU-Bound
		Executors.newCachedThreadPool();
		Executors.newSingleThreadExecutor(); // batch
		Executors.newScheduledThreadPool(8);
		
		var tp = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		var task = new MyLotteryTask();
		var future = tp.submit(task);
		System.out.println(future.get());
		tp.shutdown();
	}

}


class MyLotteryTask implements Callable<List<Integer>> {

	@Override
	public List<Integer> call() {
		return ThreadLocalRandom.current().ints(1, 60).distinct().limit(6).sorted().boxed()
				.collect(Collectors.toList());
	}

}