package wheather.cron.services.RestWeather.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import wheather.cron.dtos.request.WeatherRequest;
import wheather.cron.services.RestWeather.RestWeather;

import java.util.Objects;

@Service
public class RestWeatherImpl implements RestWeather {
    @Value("${weather.api.url}")
    private  String url;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Mono<Object> getWeather(  WeatherRequest request) {
        String urlWeather = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", request.getQ())
                .queryParam("appid", request.getAppid())
                .toUriString();
        return  Mono.just(Objects.requireNonNull(restTemplate.getForObject(urlWeather, Object.class)));
    }
}
