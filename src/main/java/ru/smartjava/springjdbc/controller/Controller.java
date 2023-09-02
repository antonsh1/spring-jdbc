package ru.smartjava.springjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.smartjava.springjdbc.service.JDBCService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {

    private final JDBCService service;

    @GetMapping("/products/fetch-product")
    public ResponseEntity<String> getProductByName(@RequestParam String name) {
        return ResponseEntity.ok(service.getProductByName(name).toString());
    }
}
