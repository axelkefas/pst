package com.axel.pst.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.axel.pst.dto.request.CarsSearchRequest;
import com.axel.pst.dto.response.CarsResponse;
import com.axel.pst.model.entity.Cars;
import com.axel.pst.model.specification.CarsSpecification;
import com.axel.pst.repository.CarsRepository;
import com.axel.pst.transform.CarsMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;


import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Author: Axel Kefas
 * Date: 17/08/24
 */
@SpringBootTest
class CarsServiceTest {

    @Mock
    private CarsRepository carsRepository;

    @Mock
    private CarsSpecification carsSpecification;

    @InjectMocks
    private CarsService carsService;

    @Mock
    CarsMapper carsMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testFindAll() {
        CarsSearchRequest request = new CarsSearchRequest();
        List<Cars> carsList = Collections.singletonList(new Cars());
        List<CarsResponse> carsResponseList = Collections.singletonList(new CarsResponse());

        Specification<Cars> specification = mock(Specification.class);

        when(carsSpecification.findCars(request)).thenReturn(specification);
        when(carsRepository.findAll(specification)).thenReturn(carsList);
        when(carsMapper.toListResponseFromJpa(carsList)).thenReturn(carsResponseList);

        List<CarsResponse> result = carsService.findAll(request);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(carsSpecification, times(1)).findCars(request);
        verify(carsRepository, times(1)).findAll(specification);
    }
}