package wheather.cron.services.CronJobServices.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wheather.cron.dtos.request.WeatherRequest;
import wheather.cron.services.CronJobServices.CronJobService;
import wheather.cron.services.RestWeather.RestWeather;

import java.io.FileWriter;


@Service

public class CronJobServiceImpl implements CronJobService {
    private final RestWeather restWeather;

    public CronJobServiceImpl(RestWeather restWeather) {
        this.restWeather = restWeather;
    }
    @Value("${weather.api.city}")
    private  String city;
    @Value("${weather.api.key}")
    private  String appid;


    @Override
    public void getWeather() {
        System.out.println("City = " + city);
        WeatherRequest weatherRequest = new WeatherRequest(city, appid);
        Object weather = restWeather.getWeather(weatherRequest).block();
        System.out.println(weather);
        // Write JSON to file
        try (FileWriter file = new FileWriter("weather.json")) {
            file.write(weather.toString());
            file.flush();
            System.out.println("Successfully wrote JSON object to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
