package com.axel.pst.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.axel.pst.dto.request.CarsSearchRequest;
import com.axel.pst.dto.response.CarsResponse;
import com.axel.pst.service.CarsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Collections;
import java.util.List;

/**
 * Author: Axel Kefas
 * Date: 17/08/24
 */

@WebMvcTest(CarsController.class)
public class CarsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarsService carsService;

    @Test
    void testSearchCars() throws Exception {
        CarsSearchRequest request = new CarsSearchRequest();
        List<CarsResponse> carsResponseList = Collections.singletonList(new CarsResponse());

        when(carsService.findAll(request)).thenReturn(carsResponseList);

        mockMvc.perform(get("/cars/search")
                        .flashAttr("searchRequest", request))
                .andExpect(status().isOk())
                .andExpect(view().name("cars-list"))
                .andExpect(model().attribute("cars", carsResponseList))
                .andExpect(model().attribute("searchRequest", request))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testDownloadCarsXml() throws Exception {
        // Given
        CarsSearchRequest request = new CarsSearchRequest();
        CarsResponse carResponse = new CarsResponse();
        carResponse.setName("Test Car");
        carResponse.setColor("red");
        carResponse.setLength(50);
        carResponse.setWeight(1500);
        carResponse.setVelocity(200);
        List<CarsResponse> carsResponseList = Collections.singletonList(carResponse);

        when(carsService.findAll(request)).thenReturn(carsResponseList);

        String expectedXml = generateXml(carResponse);

        mockMvc.perform(get("/cars/download")
                        .flashAttr("searchRequest", request))
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=cars.xml"))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, "application/xml"))
                .andExpect(content().contentType(MediaType.APPLICATION_XML))
                .andExpect(content().xml(expectedXml))
                .andDo(MockMvcResultHandlers.print());
    }


    private String generateXml(CarsResponse carsResponse){
        StringBuilder stringBuilder = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
                .append("<cars>\n  <car>\n")
                .append("    <name>").append(carsResponse.getName()).append("</name>\n")
                .append("    <color>").append(carsResponse.getColor()).append("</color>\n")
                .append("    <length>").append(carsResponse.getLength()).append("</length>\n")
                .append("    <weight>").append(carsResponse.getWeight()).append("</weight>\n")
                .append("    <velocity>").append(carsResponse.getVelocity()).append("</velocity>\n")
                .append("  </car>\n</cars>\n");

        return stringBuilder.toString();

    }
}