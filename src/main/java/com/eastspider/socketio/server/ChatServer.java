package com.eastspider.socketio.server;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.VoidAckCallback;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.corundumstudio.socketio.store.RedissonStoreFactory;
import com.corundumstudio.socketio.store.StoreFactory;
import com.eastspider.socketio.common.ChatObject;
import com.eastspider.socketio.common.ChatUser;

public class ChatServer {
	
	private static Logger logger = LoggerFactory.getLogger(ChatServer.class);
	
	public static void main(String[] args) throws InterruptedException {

        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);
        
        RedissonClient redisson = Redisson.create();
        StoreFactory storeFactory = new RedissonStoreFactory(redisson);
        config.setStoreFactory(storeFactory);

        final SocketIOServer server = new SocketIOServer(config);
        server.addEventListener("ackevent1", ChatObject.class, new DataListener<ChatObject>() {
            @Override
            public void onData(final SocketIOClient client, ChatObject data, final AckRequest ackRequest) {

                // 是否来自client的ack请求,
                if (ackRequest.isAckRequested()) {
                    // 发送ack response 给client
                    ackRequest.sendAckData("client message was delivered to server!", "yeah!");
                }

                // send message back to client with ack callback WITH data
                ChatObject ackChatObjectData = new ChatObject(data.getUserName(), "message with ack data");
                client.sendEvent("ackevent2", new AckCallback<String>(String.class) {
                    @Override
                    public void onSuccess(String result) {
                        System.out.println("ack from client: " + client.getSessionId() + " data: " + result);
                    }
                }, ackChatObjectData);

                ChatObject ackChatObjectData1 = new ChatObject(data.getUserName(), "message with void ack");
                client.sendEvent("ackevent3", new VoidAckCallback() {

                    protected void onSuccess() {
                        System.out.println("void ack from: " + client.getSessionId());
                    }

                }, ackChatObjectData1);
            }
        });
        
        server.addConnectListener(new ConnectListener(){

			@Override
			public void onConnect(SocketIOClient client) {
				logger.info("{} 客户端已建立连接", client.getSessionId());
				ChatUser chatUser = new ChatUser();
				chatUser.setUserId(client.getSessionId().toString());
				client.set(client.getSessionId().toString(), chatUser);
			}
        	
        });
        
        server.addDisconnectListener(new DisconnectListener(){

			@Override
			public void onDisconnect(SocketIOClient client) {
				logger.info("{} 客户端已断开连接", client.getSessionId());
				client.del(client.getSessionId().toString());
			}
        	
        });
        
        SocketIONamespace socketIONamespace = server.addNamespace("/nsp1");
        

        server.start();

        Thread.sleep(Integer.MAX_VALUE);

        server.stop();
    }
	
}
