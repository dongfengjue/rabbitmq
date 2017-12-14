package mq.Sender;

import org.springframework.stereotype.Component;

/**
 * @author chenbing
 * @date 2017-12-7 17:17
 */
@Component
public class ReportSender extends Base {
    @Override
    String getQueues() {
        return "report.call";
    }
}
