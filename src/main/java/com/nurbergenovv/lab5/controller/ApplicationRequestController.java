package com.nurbergenovv.lab5.controller;

import com.nurbergenovv.lab5.entity.ApplicationRequest;
import com.nurbergenovv.lab5.service.ApplicationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class ApplicationRequestController {

    private final ApplicationRequestService requestService;

    @GetMapping
    public ResponseEntity<?> getAll( ) {
        return new ResponseEntity<>(requestService.getAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ApplicationRequest request) {
        requestService.addApplicationRequest(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(requestService.getApplicationRequestById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody ApplicationRequest request) {
        requestService.updateRequest(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        requestService.deleteApplicationRequest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}