package wheather.cron.services.RestWeather;

import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;
import wheather.cron.dtos.request.WeatherRequest;

public interface RestWeather {
    Mono<Object> getWeather(  WeatherRequest request);
}
