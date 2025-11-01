package com.nurbergenovv.lab5.controller;

import com.nurbergenovv.lab5.entity.Operator;
import com.nurbergenovv.lab5.service.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operators")
@RequiredArgsConstructor
public class OperatorController {

    private final OperatorService operatorService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(operatorService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Operator operator) {
        operatorService.create(operator);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Operator operator) {
        operatorService.update(id, operator);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        operatorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}