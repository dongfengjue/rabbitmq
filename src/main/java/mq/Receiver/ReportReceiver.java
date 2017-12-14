package mq.Receiver;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenbing
 * @date 2017-12-7 17:19
 */
@Component
@CommonsLog
public class ReportReceiver {

    @RabbitListener(queues = "report.call")
    @RabbitHandler
    public void process(String msg) throws Exception {

        log.info("------report.test-----"+msg);

    }
}
