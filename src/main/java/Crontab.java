import lombok.extern.apachecommons.CommonsLog;
import mq.Sender.ReportSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chenbing
 * @date 2017-12-7 17:12
 */
@CommonsLog
@Component
public class Crontab {
    @Autowired
    ReportSender reportSender;

    //每天凌晨两点执行
//   @Scheduled(cron = "0 0 2 * * ?") // 每天凌晨2点执行
    @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次
   public void startTask(){
        log.info("定时任务开始......");
        long begin = System.currentTimeMillis();


        for (int i = 0;i<10;i++){
            reportSender.send(String.valueOf(i));
        }

        long end = System.currentTimeMillis();
        log.info("定时任务结束，共耗时：[" + (end-begin) / 1000 + "]秒");
    }
}
