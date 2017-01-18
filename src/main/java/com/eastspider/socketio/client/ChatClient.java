package com.eastspider.socketio.client;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ChatClient {
	

	public static void main(String[] args) throws URISyntaxException, InterruptedException {
		
		Socket socket = IO.socket("http://localhost:9092");
		
		socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

		  @Override
		  public void call(Object... args) {
			  System.out.println("已建立");
		  }

		});
		
		socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

		  @Override
		  public void call(Object... args) {
		  }

		});
		socket.connect();
		Thread.sleep(Integer.MAX_VALUE);
	}

}
