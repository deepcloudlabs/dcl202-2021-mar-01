package com.example;

import java.util.concurrent.Executors;

public class StudyExecutors {

	public static void main(String[] args) {
		// CPU-Bound -> Logical processor (8)
		// IO-Bound (disk, networking)    (8 * 16)
		// CPU+IO-Bound
		// GPU-Bound
		Executors.newCachedThreadPool();
		Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		Executors.newSingleThreadExecutor();

	}

}
