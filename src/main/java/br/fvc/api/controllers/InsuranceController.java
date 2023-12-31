package br.fvc.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fvc.api.models.Insurance;
import br.fvc.api.services.InsuranceService;

@CrossOrigin
@RestController

@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping("/all")
    public ResponseEntity<Object> all() {
        return insuranceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> index(@PathVariable("id") Long id) {
        return insuranceService.index(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        return insuranceService.delete(id);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Insurance data) {
        return insuranceService.store(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Insurance data) {
        return insuranceService.update(id, data);
    }

    @PostMapping("/filter")
    public ResponseEntity<Object> filter(@RequestBody() Insurance data) {
        return insuranceService.filter(data);
    }
}
