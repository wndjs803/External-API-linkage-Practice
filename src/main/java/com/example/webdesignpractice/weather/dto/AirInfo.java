package com.example.webdesignpractice.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AirInfo(
        @JsonProperty("MSRDT")
        String msrdt,
        @JsonProperty("MSRRGN_NM")
        String msrrgnNm,
        @JsonProperty("PM10")
        Integer pm10,
        @JsonProperty("PM25")
        Integer pm25,
        @JsonProperty("03")
        Double _03,
        @JsonProperty("NO2")
        Double nO2,
        @JsonProperty("CO")
        Double co,
        @JsonProperty("SO2")
        Double so2,
        @JsonProperty("IDEX_NM")
        String idexNm,
        @JsonProperty("IDEX_MVL")
        Integer idexMvl,
        @JsonProperty("ARPLT_MAIN")
        String arpltMain
) {
}