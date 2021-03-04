package com.example.banking.application;

import java.io.Closeable;
import java.io.IOException;

public class PreciousResource implements Closeable {
	private int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	@Override
	public void close() throws IOException {
		System.out.println("Closing the resource "+id);
		throw new IllegalStateException("Cannot close the resource");
	}
	
}
