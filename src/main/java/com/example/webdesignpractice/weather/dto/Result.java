package com.example.webdesignpractice.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Result(
        @JsonProperty("CODE")
        String code,
        @JsonProperty("MESSAGE")
        String message
) {
}
