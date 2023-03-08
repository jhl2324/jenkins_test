package test.cicd.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageSenderService {

    private final JmsTemplate jmsTemplate;

    public void sendMessage(String text) throws UnknownHostException {
        log.info("[{}] thread : {}, time : {}, message : {} - service - start", InetAddress.getLocalHost().getHostAddress(), Thread.currentThread().getId(), text, LocalDateTime.now());
        jmsTemplate.convertAndSend("message.queue", text);
        log.info("[{}] thread : {}, time : {}, message : {} - service - end", InetAddress.getLocalHost().getHostAddress(), Thread.currentThread().getId(), text, LocalDateTime.now());
    }
}

