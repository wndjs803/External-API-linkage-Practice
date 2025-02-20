package com.example.webdesignpractice.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RealTimeCityAirResponse(
        @JsonProperty("RealtimeCityAir")
        RealtimeCityAirData realtimeCityAir
) {
}
