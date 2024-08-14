package com.axel.pst.model.specification;

import com.axel.pst.model.entity.Cars;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */

@Component
public class CarsSpecification {

    public Specification<Cars> carsSpecification() {
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            return query.getRestriction();
        });
    }
}
