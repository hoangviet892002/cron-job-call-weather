package wheather.cron.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import wheather.cron.services.CronJobServices.CronJobService;
import wheather.cron.shared.constants.ApplicationConstants;

@Component
public class ScheduledTasks {

    private final CronJobService cronJobService;

    public ScheduledTasks(CronJobService cronJobService) {
        this.cronJobService = cronJobService;
    }

    @Scheduled(cron = ApplicationConstants.CronJob)
    public void updateCronJob() {
        cronJobService.getWeather();
    }
}
