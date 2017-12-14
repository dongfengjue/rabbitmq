import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenbing
 * @date 2017-12-5 12:09
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue reporTesttQueue() {
        return new Queue("report.test");
    }

    @Bean
    Binding bindingExchangeReportTest(Queue reporTesttQueue, TopicExchange exchange) {
        return BindingBuilder.bind(reporTesttQueue).to(exchange).with("report.test");
    }

    @Bean
    public Queue reportQueue() {
        return new Queue("report.call");
    }

    @Bean
    Binding bindingExchangeMessages(Queue reportQueue, TopicExchange exchange) {
        return BindingBuilder.bind(reportQueue).to(exchange).with("report.call");
    }

    @Bean
    public Queue smsQueue() {
        return new Queue("topic.sms");
    }
    @Bean
    public Queue mailQueue() {
        return new Queue("topic.mail");
    }

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
     * @param mailQueue
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMail(Queue mailQueue, TopicExchange exchange) {
        return BindingBuilder.bind(mailQueue).to(exchange).with("topic.mail");
    }

    @Bean
    Binding bindingExchangeSms(Queue smsQueue, TopicExchange exchange) {
        return BindingBuilder.bind(smsQueue).to(exchange).with("topic.sms");
    }

    @Bean
    Binding bindingExchangeHello(Queue helloQueue, TopicExchange exchange) {
        return BindingBuilder.bind(helloQueue).to(exchange).with("hello");
    }
}
