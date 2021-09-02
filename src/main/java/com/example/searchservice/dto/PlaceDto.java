package com.example.searchservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlaceDto {
    @JsonProperty(value = "display_name")
    private String displayName;
    private String lat;
    private String lon;
    @JsonProperty(value = "class")
    private String placeClass;
    private String type;
}
