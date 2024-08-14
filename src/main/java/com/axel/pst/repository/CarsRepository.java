package com.axel.pst.repository;

import com.axel.pst.model.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */
@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {

}
