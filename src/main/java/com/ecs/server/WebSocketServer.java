package com.ecs.server;

import com.alibaba.fastjson.JSONObject;
import com.ecs.model.NetworkConditions;
import com.ecs.utils.TestNetworksUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint(value = "/ws/webSocket/{clientId}")
public class WebSocketServer {
    //每个客户端都会有相应的session,服务端可以发送相关消息
    private Session session;

    private String clientId;

    //J.U.C包下线程安全的类，主要用来存放每个客户端对应的webSocket连接
    private static CopyOnWriteArraySet<WebSocketServer> copyOnWriteArraySet = new CopyOnWriteArraySet<WebSocketServer>();

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);

    //指定客户端，将设备信息发送过去
    private static final String targetClientId = "1";

    private static String targetClientSessionId;

    @OnOpen
    public void onOpen(@PathParam("clientId")String clientId, Session session) {
        this.session = session;
        this.clientId = clientId;
        if(clientId.equals(targetClientId)) {
            targetClientSessionId = session.getId();
        }
        copyOnWriteArraySet.add(this);
        LOGGER.info("websocket有新的连接, 总数:"+ copyOnWriteArraySet.size());
    }

    @OnClose
    public void onClose() {
        copyOnWriteArraySet.remove(this);
        LOGGER.info("websocket连接断开, 总数:"+ copyOnWriteArraySet.size());
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
//        LOGGER.info("websocket收到客户端发来的消息:" + message);
        String networkConditions = TestNetworksUtil.getNetworkCondition().toString();
        String msg = "data: {" + message + "; " + networkConditions + "}";
//        JSONObject jsonObject = JSONObject.parseObject(networkConditions);
        LOGGER.info("msg:" + msg);
        sendMessage(targetClientSessionId, msg);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        LOGGER.info("发生错误：" + error.getMessage() + session.getId());
        error.printStackTrace();
    }

    /**
     * 用于给指定客户端发送消息
     * @param message
     */
    public void sendMessage(String mySessionId, String message) {
        //遍历客户端
        for (WebSocketServer webSocket : copyOnWriteArraySet) {
            LOGGER.info("websocket向指定客户端发送消息：" + message);
            if(webSocket.session.getId().equals(mySessionId)) {
                try {
                    webSocket.session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else {
                LOGGER.info("error" + mySessionId);
            }
        }
    }

    /**
     * 用于发送给客户端消息（群发）
     * @param message
     */
    public void sendMessage(String message) {
        //遍历客户端
        for (WebSocketServer webSocket : copyOnWriteArraySet) {
            LOGGER.info("websocket广播消息：" + message);
            try {
                //服务器主动推送
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
