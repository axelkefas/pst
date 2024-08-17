package com.axel.pst.controller;

import com.axel.pst.dto.request.CarsSearchRequest;
import com.axel.pst.dto.response.CarsResponse;
import com.axel.pst.service.CarsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */
@Controller
@AllArgsConstructor
@RequestMapping("/cars")
@Slf4j
public class CarsController {

    @Autowired
    private CarsService carsService;


    @GetMapping("/search")
    public String searchCars(@ModelAttribute CarsSearchRequest searchRequest, Model model) {
        List<CarsResponse> cars = carsService.findAll(searchRequest);
        model.addAttribute("cars", cars);
        model.addAttribute("searchRequest", searchRequest);
        return "cars-list";
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadCarsXml(@ModelAttribute CarsSearchRequest searchRequest) {
        List<CarsResponse> cars = carsService.findAll(searchRequest);

        // Generate XML content
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(baos);
        writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.println("<cars>");
        for (CarsResponse car : cars) {
            writer.println("  <car>");
            writer.println("    <name>" + car.getName() + "</name>");
            writer.println("    <color>" + car.getColor() + "</color>");
            writer.println("    <length>" + car.getLength() + "</length>");
            writer.println("    <weight>" + car.getWeight() + "</weight>");
            writer.println("    <velocity>" + car.getVelocity() + "</velocity>");
            writer.println("  </car>");
        }
        writer.println("</cars>");
        writer.flush();

        ByteArrayResource resource = new ByteArrayResource(baos.toByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=cars.xml");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/xml");

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
