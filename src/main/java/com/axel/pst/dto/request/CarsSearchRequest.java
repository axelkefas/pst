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
    private Integer minLength;

    @JsonProperty("max_length")
    private Integer maxLength;

    @JsonProperty("min_weight")
    private Integer minWeight;

    @JsonProperty("max_weight")
    private Integer maxWeight;

    @JsonProperty("min_velocity")
    private Integer minVelocity;

    @JsonProperty("max_velocity")
    private Integer maxVelocity;

}
