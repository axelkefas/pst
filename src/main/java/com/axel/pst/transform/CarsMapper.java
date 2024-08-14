package com.axel.pst.transform;

import com.axel.pst.dto.response.CarsResponse;
import com.axel.pst.model.entity.Cars;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */
@Mapper
public interface CarsMapper {
    CarsMapper INSTANCE = Mappers.getMapper(CarsMapper.class);

     CarsResponse toCarsResponseDto(Cars cars);

     List<CarsResponse> toListResponseFromJpa(List<Cars> carsList);
}
