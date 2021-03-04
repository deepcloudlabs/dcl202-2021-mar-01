package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class StudyWebsocketClient {
	private static final String URL = 
			"wss://stream.binance.com:9443/ws/btcusdt@trade";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient.newHttpClient()
		          .newWebSocketBuilder()
		          .buildAsync(URI.create(URL), new BinanceWebSocketListener());
		TimeUnit.MINUTES.sleep(1);
	}
}

class BinanceWebSocketListener implements WebSocket.Listener {

	@Override
	public void onOpen(WebSocket webSocket) {
		System.err.println("Connectected to the Binance Server.");
		webSocket.request(1);
	}

	@Override
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
		System.err.println(data);
		webSocket.request(1);
		return null;
	}

	@Override
	public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
		System.err.println("Disconnectected to the Binance Server.");
		return null;
	}

	@Override
	public void onError(WebSocket webSocket, Throwable error) {
		System.err.println("Error: "+error.getMessage());
	}
	
}