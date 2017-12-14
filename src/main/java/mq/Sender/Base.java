package mq.Sender;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * @author chenbing
 * @date 2017-12-5 11:40
 */
@CommonsLog
public abstract class Base implements RabbitTemplate.ConfirmCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static Base sender;

    @PostConstruct
    public void init() {
        sender = this;
    }

    abstract String getQueues();

    String getExchange(){
        return "exchange";
    };

    static void setConfirmCallback(){
        sender.rabbitTemplate.setConfirmCallback(sender);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("------rabbit deal success confirm -----id"+correlationData.getId());
    }

    //    带回调的
    @Async
    public void send(String msg) {
        setConfirmCallback();
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        log.info("------rabbitmq send uuid ------id"+correlationData.getId());
        this.rabbitTemplate.convertAndSend(getExchange(),getQueues(), msg, correlationData);
    }
}
