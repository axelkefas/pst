package com.axel.pst.controller;

import com.axel.pst.dto.request.CarsSearchRequest;
import com.axel.pst.dto.response.CarsResponse;
import com.axel.pst.model.entity.Cars;
import com.axel.pst.service.CarsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

/**
 * Author: Axel Kefas
 * Date: 14/08/24
 */
@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @PostMapping("/search")
    public ResponseEntity<List<CarsResponse>> search(@Valid @RequestBody CarsSearchRequest request) {
        try {
            return new ResponseEntity<>(carsService.findAll(request), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarsResponse>> getAll() {
        try {
            List<CarsResponse> responses = carsService.findAll(new CarsSearchRequest());
            return new ResponseEntity<>(responses, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/search")
//    public ResponseEntity<String> downloadItemsAsXml() {
//        try {
//            // Fetch all items from the database
//            List<Cars> cars = carsService.findAll();
//
//            // Convert the list of items to XML
//            JAXBContext context = JAXBContext.newInstance(Cars.class, List.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//            StringWriter sw = new StringWriter();
//            for (Cars car : cars) {
//                marshaller.marshal(car, sw);
//            }
//            String xmlString = sw.toString();
//
//            // Set headers and return the XML as a response
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-Disposition", "attachment; filename=items.xml");
//            headers.add("Content-Type", "application/xml");
//
//            return new ResponseEntity<>(xmlString, headers, HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
