package com.axel.pst.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarsResponse {

    private String name;
    private int length;
    private int weight;
    private int velocity;
    private String color;
}
