package com.steve.boot.launch.controller;

import com.steve.boot.launch.model.QueenMessage;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class P2pProducerController {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    @Resource
    private Queue messageQueue;

    @RequestMapping("/send")
    public QueenMessage send(){
        QueenMessage queenMessage = new QueenMessage("测试","测试内容" + atomicInteger.incrementAndGet());

        jmsMessagingTemplate.convertAndSend(messageQueue,queenMessage);
        return queenMessage;
    }
}