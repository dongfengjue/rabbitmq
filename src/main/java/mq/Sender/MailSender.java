package mq.Sender;

import org.springframework.stereotype.Component;

/**
 * @author chenbing
 * @date 2017-12-5 10:48
 */
@Component
public class MailSender extends Base {
    @Override
    String getQueues() {
        return "topic.mail";
    }
}
