package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

// Data Parallelism
public class StudyParallelProgramming {
	// List<int> -> 4B
	// [4B 4B 4B ...] -> L1
	// Record
	// Integer (Wrapper Class (int)) -> Heap
	// object -> object header (12B) + 4B = 16B -> 4x
	// List<Integer>
	// [8B 8B 8B ... ] -> L1 ( Locality of reference)
	//   |
	//   V
	//  [12B 4B] (Integer object)
	// 100_000_000 : 2.73 x
	// 200_000_000 : 2.87 x
	List<Integer> nums;
	private static final List<Integer> data = new ArrayList<>();
	private static final int SIZE = 100_000_000;
	private static final int CPUS = Runtime.getRuntime().availableProcessors();
	private static final int SIZE_PER_CPU = SIZE / CPUS;
	private static final ExecutorService es = Executors.newFixedThreadPool(CPUS);

	static {
		IntStream.range(0, SIZE).forEach(data::add);
	}

	public static long solveParallel() throws InterruptedException, ExecutionException {
		var sum = 0L;
		var futures = new ArrayList<Future<Long>>();
		var start = System.nanoTime();
		for (int i = 0, j = 0; i < CPUS; ++i, j += SIZE_PER_CPU) {
			var future = es.submit(new SumTask(data, j, SIZE_PER_CPU));
			futures.add(future);
		}
		for (var future :futures)
			sum += future.get();
		var stop = System.nanoTime();
		System.err.println(String.format("Solution: %16d @ %12d ns.", sum, stop - start));
		return stop - start;
	}

	public static long solveSerial() {
		var sum = 0L;
		var start = System.nanoTime();
		for (var num : data) {
			sum += num;
		}
		var stop = System.nanoTime();
		System.err.println(String.format("Solution: %16d @ %12d ns.", sum, stop - start));
		return stop - start;
	}

	public static void main(String[] args) throws Exception {
		/*
		var minSerialDuration = Long.MAX_VALUE;
		for (var i = 0; i < 10; ++i)
			minSerialDuration = Math.min(minSerialDuration, solveSerial());
		System.err.println("minSerialDuration: " + minSerialDuration);
		var minParallelDuration = Long.MAX_VALUE;
		for (var i = 0; i < 10; ++i)
			minParallelDuration = Math.min(minParallelDuration, solveParallel());
		System.err.println("minParallelDuration: " + minParallelDuration);
		es.shutdown();
		*/
		long start = System.nanoTime();
		var sum = data.stream()
				      .parallel()
				      //.mapToLong(Long::valueOf)
				      .reduce(Integer::sum);
		long stop = System.nanoTime();
		System.out.println("sum="+sum+" @ "+(stop-start)+" ns.");
	}
}

class SumTask implements Callable<Long> {
	private List<Integer> taskData;
	private int start;
	private int length;

	public SumTask(List<Integer> taskData, int start, int length) {
		this.taskData = taskData;
		this.start = start;
		this.length = length;
	}

	@Override
	public Long call() throws Exception {
		var sum = 0L;
		for (int i = start, j = 0; j < length; ++i, ++j) {
			sum += taskData.get(i);
		}
		return sum;
	}

}