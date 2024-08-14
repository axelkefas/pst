package com.axel.pst.dto.response;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */
@XmlRootElement(name = "cars")
@Setter
public class CarsXmlResponse {

    private int length;
    private int weight;
    private int velocity;
    private String color;
    private String name;

    @XmlElement
    public int getLength() {
        return length;
    }

    @XmlElement
    public int getWeight() {
        return weight;
    }

    @XmlElement
    public int getVelocity() {
        return velocity;
    }

    @XmlElement
    public String getColor() {
        return color;
    }

    @XmlElement
    public String getName() {
        return name;
    }
}
