package mq.Sender;

import org.springframework.stereotype.Component;

/**
 * @author chenbing
 * @date 2017-12-5 10:48
 */
@Component
public class SmsSender extends Base {

    @Override
    String getQueues() {
        return "topic.sms";
    }

}
