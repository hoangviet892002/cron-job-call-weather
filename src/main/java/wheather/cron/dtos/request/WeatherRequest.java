package wheather.cron.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WeatherRequest {
    @JsonProperty("q")
    private String q;
    @JsonProperty("appid")
    private String appid;
}
