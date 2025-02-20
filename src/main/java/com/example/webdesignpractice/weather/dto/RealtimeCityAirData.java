package com.example.webdesignpractice.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RealtimeCityAirData(
        @JsonProperty("list_total_count")
        Integer listTotalCount,
        @JsonProperty("RESULT")
        Result result,
        @JsonProperty("row")
        List<AirInfo> row
) {
}
