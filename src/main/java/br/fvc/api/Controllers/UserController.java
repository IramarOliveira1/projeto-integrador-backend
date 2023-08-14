package br.fvc.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fvc.api.Domain.User.UserRequestDTO;
import br.fvc.api.Models.User;
import br.fvc.api.Services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public ResponseEntity<Object> all() {
        return userService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequestDTO data) {
        return userService.store(data);
    }

}
