package com.steve.boot.launch.config.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
@ServerEndpoint(value = "/ws/asset")
public class WebSocketServer {

    //用来统计连接客户端的数量
    private static final AtomicInteger onlineCount = new AtomicInteger(0);
    // concurrent包的线程安全Set，用来存放每个客户端对应的Session对象。
    private static final CopyOnWriteArraySet<Session> sessionSet = new CopyOnWriteArraySet<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        sessionSet.add(session);
        int cnt = onlineCount.incrementAndGet(); // 在线数加1
        log.info("有连接加入，当前连接数为：{}", cnt);
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("来自客户端的消息：{}",message);
        //sendMessage(session, "Echo消息内容："+message);
        broadCastInfo(message, session); //群发消息
    }


    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        sessionSet.remove(session);
        int cnt = onlineCount.decrementAndGet();
        log.info("有连接关闭，当前连接数为：{}", cnt);
    }

    /**
     * 出现错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误：{}，Session ID： {}",error.getMessage(),session.getId());
    }

    /**
     * 发送消息，实践表明，每次浏览器刷新，session会发生变化。
     * @param session  session
     * @param message  消息
     */
    private static void sendMessage(Session session, String message, Session messageSourceSession) throws IOException {
        if(session == messageSourceSession){
            session.getBasicRemote().sendText(String.format("%s (From me)",message));
        }else {
            session.getBasicRemote().sendText(String.format("%s (From Server，Session ID=%s)", message, messageSourceSession.getId()));
        }
    }

    /**
     * 群发消息
     * @param message  消息
     */
    public static void broadCastInfo(String message, Session messageSourceSession) throws IOException {
        for (Session session : sessionSet) {
            if(session.isOpen()){
                sendMessage(session, message, messageSourceSession);
            }
        }
    }

}