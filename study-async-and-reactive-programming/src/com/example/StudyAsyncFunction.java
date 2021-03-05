package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StudyAsyncFunction {
	private static final int CPUS = Runtime.getRuntime().availableProcessors();
	private static final ExecutorService THREAD_POOL =
			//Executors.newFixedThreadPool(CPUS);
			Executors.newCachedThreadPool();
	public static void main(String[] args) throws Exception {
		var lotteryNumbers = new ArrayList<CompletableFuture<List<Integer>>>();
		for (var i=0;i<20;++i) {
		    lotteryNumbers.add(getAsyncNumbers()); //async
		}
		System.err.println("Doing another important job...");
		// asynchronous programming -> event-triggered programming
		for(var numbers : lotteryNumbers)
			numbers.thenAccept( nums -> {
			   System.err.println(Thread.currentThread().getName() + ": "+nums);
		    }); 
		System.err.println("Doing yet another important job...");
		TimeUnit.SECONDS.sleep(30);
	}

	public static CompletableFuture<List<Integer>> getAsyncNumbers(){
		return CompletableFuture.supplyAsync(
			() -> {
				System.err.println(Thread.currentThread().getName() + " is just started.");
				try {
					TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(3, 8));
				} catch (InterruptedException e) { }
				return ThreadLocalRandom.current()
				.ints(1, 60)
				.distinct()
				.limit(6)
				.sorted()
				.boxed()
				.collect(Collectors.toList());
			}, THREAD_POOL
		);		
	}
}
