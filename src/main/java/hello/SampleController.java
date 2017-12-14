package hello;

import mq.Sender.ReportSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
/**
 * @author chenbing
 * @date 2017-12-14 17:51
 */

@Controller
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(basePackages={"mq.*","hello.*"})
public class SampleController {

    @Autowired
    ReportSender reportSender;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        reportSender.send("hello");
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
