package com.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class StudyRunnableThread {

	public static void main(String[] args) {
		var task = new LotteryTask();
		var t1 = new Thread(task);
		t1.start();
		// Synchronization ?
		do {
			try {
				t1.join(10);
				if(t1.isAlive()) {
					System.err.println(Thread.currentThread().getName()+": Working on an import task...");
				} else {
					System.err.println(task.getNumbers());
					break;
				}
			} catch (InterruptedException e) {
				System.err.println("Error: "+e.getMessage());
			} // blocking
		} while (true);
	}

}

class LotteryTask implements Runnable {
	private List<Integer> numbers;

	@Override
	public void run() {
		numbers = ThreadLocalRandom.current().ints(1, 60).distinct().limit(6).sorted().boxed()
				.collect(Collectors.toList());
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}