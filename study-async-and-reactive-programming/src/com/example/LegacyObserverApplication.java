package com.example;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

public class LegacyObserverApplication {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Observable observable = new TradeEventObservable();
		Observer slowObserver = (o, tradeEvent) -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch(InterruptedException e) {}
			System.err.println("Slow observer: "+tradeEvent);
		};
		Observer fastObserver = (o, tradeEvent) -> {
			System.err.println("Fast observer: "+tradeEvent);
		};
		observable.addObserver(slowObserver);
		observable.addObserver(fastObserver);
		List<TradeEvent> tradeEvents = List.of(
				new TradeEvent("ORCL", 1000, 100),
				new TradeEvent("MSFT", 2000, 200),
				new TradeEvent("IBM", 3000, 300),
				new TradeEvent("MSFT", 4000, 400),
				new TradeEvent("ORCL", 5000, 500)
		);
		tradeEvents.forEach(observable::notifyObservers);
	}

}

class TradeEventObservable extends Observable {

	@Override
	public void notifyObservers(Object event) {
		setChanged();
		super.notifyObservers(event);
	}
	
}
