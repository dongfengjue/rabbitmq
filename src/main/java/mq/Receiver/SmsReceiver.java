package mq.Receiver;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author chenbing
 * @date 2017-12-5 10:48
 */
@Component
@CommonsLog
public class SmsReceiver {
    @RabbitListener(queues = "topic.sms")
    @RabbitHandler
    public void process(String msg) throws Exception {

        log.info("------receiver msg -----"+msg);

    }


}
