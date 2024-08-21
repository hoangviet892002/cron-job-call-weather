package wheather.cron.services.CronJobServices;

import org.springframework.web.bind.annotation.GetMapping;

public interface CronJobService {

    @GetMapping("/")
    void getWeather();
}
