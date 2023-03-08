package test.cicd.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MessageSenderController {

    private final MessageSenderService messageSenderService;

    @PostMapping("/send")
    public String send(@RequestParam String text) throws UnknownHostException {
        log.info("[{}] time : {} - controller - start", Thread.currentThread().getId(), LocalDateTime.now());
        messageSenderService.sendMessage(text);
        log.info("[{}] time : {} - controller - end", Thread.currentThread().getId(), LocalDateTime.now());
        return text + " 송신 완료!";
    }
}
