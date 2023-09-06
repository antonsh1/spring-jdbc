package ru.smartjava.springjdbc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.smartjava.springjdbc.entity.ErrorMsg;
import ru.smartjava.springjdbc.service.JDBCService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {

    private final JDBCService service;
    private final Gson gson = new GsonBuilder().create();

    @GetMapping(value = "/products/fetch-product", produces = "application/json")
    ResponseEntity<String> getProductByName(@RequestParam String name) {
        System.out.println(name);
        return service.getProductByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(
                                        gson.toJson(
                                                new ErrorMsg("Products of customer with name '" + name + "' not found")
                                        )
                                )
                );
    }


}
