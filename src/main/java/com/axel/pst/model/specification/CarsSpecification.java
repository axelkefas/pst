package com.axel.pst.model.specification;

import com.axel.pst.dto.request.CarsSearchRequest;
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

    public Specification<Cars> findCars(CarsSearchRequest carsSearchRequest) {
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(carsSearchRequest.getMinWeight()!=null){
                predicates.add(cb.greaterThanOrEqualTo(root.get("weight"), carsSearchRequest.getMinWeight()));
            }

            if(carsSearchRequest.getMaxWeight()!=null){
                predicates.add(cb.lessThanOrEqualTo(root.get("weight"), carsSearchRequest.getMaxWeight()));
            }

            if(carsSearchRequest.getMinLength()!=null){
                predicates.add(cb.greaterThanOrEqualTo(root.get("length"), carsSearchRequest.getMinLength()));
            }

            if(carsSearchRequest.getMaxLength()!=null){
                predicates.add(cb.lessThanOrEqualTo(root.get("length"), carsSearchRequest.getMaxLength()));
            }

            if(carsSearchRequest.getMinVelocity()!=null){
                predicates.add(cb.greaterThanOrEqualTo(root.get("velocity"), carsSearchRequest.getMinVelocity()));
            }

            if(carsSearchRequest.getMaxVelocity()!=null){
                predicates.add(cb.lessThanOrEqualTo(root.get("velocity"), carsSearchRequest.getMaxVelocity()));
            }

            if (carsSearchRequest.getColor() != null && !carsSearchRequest.getColor().isEmpty()) {
                predicates.add(cb.equal(root.get("color"), carsSearchRequest.getColor()));
            }

            query.where(predicates.toArray(new Predicate[0]));
            return query.getRestriction();
        });
    }
}
