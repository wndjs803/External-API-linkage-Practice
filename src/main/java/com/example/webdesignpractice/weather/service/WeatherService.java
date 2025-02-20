package com.example.webdesignpractice.weather.service;

import com.example.webdesignpractice.weather.dto.RealTimeCityAirResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private static final String BASEURL = "http://openapi.seoul.go.kr:8088";
    private static final String KEY = "sample"; // 인증키
    private static final String TYPE = "json"; // 요청 파일 타입 (xml, json 등)
    private static final String SERVICE = "RealtimeCityAir";

    private final RestClient restClient;

    public String getWeather() {
        int START_INDEX = 1;
        int END_INDEX = 2;

        String url = BASEURL + "/" +
                URLEncoder.encode(KEY, StandardCharsets.UTF_8) + "/" +
                URLEncoder.encode(TYPE, StandardCharsets.UTF_8) + "/" +
                URLEncoder.encode(SERVICE, StandardCharsets.UTF_8) + "/" +
                START_INDEX + "/" +
                END_INDEX + "/";

        RealTimeCityAirResponse response = restClient.get()
                .uri(url)
                .retrieve()
                .body(RealTimeCityAirResponse.class);

        return response.realtimeCityAir().listTotalCount().toString();
    }
}
