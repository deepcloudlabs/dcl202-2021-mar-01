package com.example;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;

import com.example.event.TradeEvent;


public class ReactiveObserver {

	public static void main(String[] args) throws Exception {
		// Flow API -> Publish/Subscribe
		SubmissionPublisher<TradeEvent> publisher = new SubmissionPublisher<>();
		var slowSubscriber = new AlgoTrader();
		var fastSubscriber = new TradeSignalProcessor();
		publisher.subscribe(slowSubscriber);
		publisher.subscribe(fastSubscriber);
		List<TradeEvent> tradeEvents = List.of(
				new TradeEvent("ORCL", 1000, 100),
				new TradeEvent("MSFT", 2000, 200),
				new TradeEvent("IBM", 3000, 300),
				new TradeEvent("MSFT", 4000, 400),
				new TradeEvent("ORCL", 5000, 500)
		);
		Consumer<TradeEvent> submit = publisher::submit;
		Consumer<TradeEvent> wait2sec = tradeEvent -> {
			try { TimeUnit.SECONDS.sleep(2); } 
			catch (InterruptedException e) {}
		};
		
		tradeEvents.forEach(submit.andThen(wait2sec));
		TimeUnit.SECONDS.sleep(60);
		publisher.close();
		System.err.println("Application is done!");
	}

}

class AlgoTrader implements Flow.Subscriber<TradeEvent> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(TradeEvent event) {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) { }
		System.err.println("AlgoTrader: "+event);
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("Error: "+throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.err.println("AlgoTrader is completed!");
	}
	
}

class TradeSignalProcessor implements Flow.Subscriber<TradeEvent> {
	
	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1);
	}
	
	@Override
	public void onNext(TradeEvent event) {
		System.err.println("TradeSignalProcessor: "+event);
		subscription.request(1);
	}
	
	@Override
	public void onError(Throwable throwable) {
		System.err.println("Error: "+throwable.getMessage());
	}
	
	@Override
	public void onComplete() {
		System.err.println("TradeSignalProcessor is completed!");
	}
	
}
