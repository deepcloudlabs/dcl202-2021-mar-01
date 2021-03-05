package com.example.banking.application;

@SuppressWarnings("finally")
public class CatchMeIfYouCan {
	public static int gun() {
    	try {
    		return 42;
    	} finally {
    		return 108;
    	}
    }  
    public static int sun() {
    	try {
    		System.exit(42);
    	} finally {
    		return 108;
    	}
    }  
	public static void fun() {
		try {
			throw new IllegalArgumentException("illegal");
		} catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
			throw new MyRuntimeException(); 
		} finally {
			System.err.println("Finally, we arrived here!");
		}
	}
	
	public static void main(String[] args) {
		System.err.println(Thread.currentThread().getName());
		System.out.println(sun());

	}

}

@SuppressWarnings("serial")
class MyRuntimeException extends RuntimeException { }