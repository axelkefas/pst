package com.axel.pst.service;

import com.axel.pst.dto.request.CarsSearchRequest;
import com.axel.pst.dto.response.CarsResponse;
import com.axel.pst.model.entity.Cars;
import com.axel.pst.model.specification.CarsSpecification;
import com.axel.pst.repository.CarsRepository;
import com.axel.pst.transform.CarsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */
@Service
public class CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private CarsSpecification carsSpecification;

    public List<CarsResponse> findAll(CarsSearchRequest request){
        List<Cars> list = carsRepository.findAll(carsSpecification.findCars(request));
        List<CarsResponse> listResponse = CarsMapper.INSTANCE.toListResponseFromJpa(list);
        return listResponse;
    }
}
