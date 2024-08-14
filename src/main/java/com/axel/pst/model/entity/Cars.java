package com.axel.pst.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */
@Entity
@Table(name = "cars")
@Getter
@Setter
public class Cars {

    @Id
    private int id;

    private String name;
    private int length;
    private int weight;
    private int velocity;
    private String color;

}
