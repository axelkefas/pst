package com.axel.pst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsSearchRequest {

    @JsonProperty("color")
    private String color;

    @JsonProperty("min_length")
    private int minLength;

    @JsonProperty("max_length")
    private int max_length;

    @JsonProperty("min_weight")
    private int minWeight;

    @JsonProperty("max_weight")
    private int maxWeight;

    @JsonProperty("min_velocity")
    private int minVelocity;

    @JsonProperty("max_velocity")
    private int maxVelocity;

}
