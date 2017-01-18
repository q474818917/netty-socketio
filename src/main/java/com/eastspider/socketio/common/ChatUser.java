package com.eastspider.socketio.common;

import java.io.Serializable;

import com.corundumstudio.socketio.SocketIOServer;

public class ChatUser implements Serializable {
	
	private static final long serialVersionUID = 7942654130781339551L;
	
	private String userId;
	
	private SocketIOServer socketIOServer;

	public SocketIOServer getSocketIOServer() {
		return socketIOServer;
	}

	public void setSocketIOServer(SocketIOServer socketIOServer) {
		this.socketIOServer = socketIOServer;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
