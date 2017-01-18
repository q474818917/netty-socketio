Netty-socketio Overview
===
[![Maven Central](https://img.shields.io/maven-central/v/com.corundumstudio.socketio/netty-socketio.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/com.corundumstudio.socketio/netty-socketio/)

This project is an open-source Java implementation of [Socket.IO](http://socket.io/) server. Based on [Netty](http://netty.io/) server framework.  

Checkout [Demo project](https://github.com/mrniko/netty-socketio-demo)

Licensed under the Apache License 2.0.

改动：
================================
~~为了测试连接socketio服务器，引入socket.io-client.jar[scoket.io-client](https://github.com/socketio/socket.io-client-java)包~~
现已改为android客户端连接
 + netty使用的4.1.5


Features
================================
* Supports __0.7__...__0.9.16__ (netty-socketio 1.6.6) and __1.0+__ (netty-socketio latest version) version of [Socket.IO-client](https://github.com/LearnBoost/socket.io-client)  
* Supports xhr-polling transport  
* Supports websocket transport  
* Supports namespaces and rooms  
* Supports ack (acknowledgment of received data)  
* Supports SSL  
* Supports client store (Memory, [Redisson](http://redisson.org), [Hazelcast](http://www.hazelcast.com/))  
* Supports distributed broadcast across netty-socketio nodes ([Redisson](http://redisson.org), [Hazelcast](http://www.hazelcast.com/))  
* Supports OSGi  
* Supports Spring  
* Lock-free and thread-safe implementation  
* Declarative handler configuration via annotations  


Performance
================================

Customer feedback in __2012__:  
CentOS, 1 CPU, 4GB RAM runned on VM: 
CPU 10%, Memory 15%  
6000 xhr-long polling sessions or 15000 websockets sessions  
4000 messages per second  


Customer feedback in __2014__:  
"To stress test the solution we run 30 000 simultaneous websocket clients and managed to peak at total of about 140 000 messages per second with less than 1 second average delay." (c) Viktor Endersz - Kambi Sports Solutions

Projects using netty-socketio
================================
 + AVOS Cloud, 现已变为LeanCloud,因域名中带av，中国团队开发 : [avoscloud.com](https://avoscloud.com/)
 + Bingo Crack: [bingocrack.com](http://bingocrack.com/)  
 + Kambi Sports Solutions: [kambi.com](http://kambi.com/)  
 + ARSnova: [arsnova.eu](https://arsnova.eu)  
 + Zipwhip: [zipwhip.com](https://zipwhip.com/)

### Maven 

Include the following to your dependency list:

    <dependency>
     <groupId>com.corundumstudio.socketio</groupId>
     <artifactId>netty-socketio</artifactId>
     <version>1.7.12</version>
    </dependency>
    
### Supported by

YourKit is kindly supporting this open source project with its full-featured Java Profiler.
YourKit, LLC is the creator of innovative and intelligent tools for profiling
Java and .NET applications. Take a look at YourKit's leading software products:
<a href="http://www.yourkit.com/java/profiler/index.jsp">YourKit Java Profiler</a> and
<a href="http://www.yourkit.com/.net/profiler/index.jsp">YourKit .NET Profiler</a>.
