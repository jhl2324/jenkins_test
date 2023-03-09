package test.cicd.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Component
@Slf4j
public class MessageReceiver {

    //private final EntityManager entityManager;

//    public MessageReceiver(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    //@Transactional
    @JmsListener(destination = "message.queue")
    public void receiveMessage(String message) throws UnknownHostException {
        try {
            log.info("[{}] thread : {}, time : {}, message : {} - receiver - start", InetAddress.getLocalHost().getHostAddress(), Thread.currentThread().getId(), message, LocalDateTime.now());
            MessageEntity entity = new MessageEntity(message);
      //      entityManager.persist(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            log.info("[{}] thread : {}, time : {}, message : {} - receiver - end", InetAddress.getLocalHost().getHostAddress(), Thread.currentThread().getId(), message, LocalDateTime.now());
        }
    }
}

