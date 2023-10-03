package br.fvc.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fvc.api.Domain.Reserve.ReserveRequestDTO;
import br.fvc.api.Services.ReserveService;

@CrossOrigin
@RestController

@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @PostMapping("/register")
    public ResponseEntity<Object> reserve(@RequestBody ReserveRequestDTO data) {
        return reserveService.reserve(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> index(@PathVariable("id") Long id) {
        return reserveService.index(id);
    }

    @PostMapping("/cancellation/{id}")
    public ResponseEntity<Object> cancellation(@PathVariable("id") Long id) {
        return reserveService.cancellation(id);
    }

    @PostMapping("/startRent/{id}")
    public ResponseEntity<Object> startRent(@PathVariable("id") Long id) {
        return reserveService.startRent(id);
    }

    @PostMapping("/endRent/{id}")
    public ResponseEntity<Object> endRent(@PathVariable("id") Long id) {
        return reserveService.endRent(id);
    }
}