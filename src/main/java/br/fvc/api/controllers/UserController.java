package br.fvc.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.fvc.api.dtos.generic.GenericRequestDTO;
import br.fvc.api.dtos.user.UserRequestDTO;
import br.fvc.api.services.ForgotPasswordService;
import br.fvc.api.services.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ForgotPasswordService forgotPassword;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserRequestDTO data) {
        return userService.login(data);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> all(@RequestParam String role) {
        return userService.all(role);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequestDTO data) {
        return userService.store(data);
    }

    @GetMapping("/me")
    public ResponseEntity<Object> me(HttpServletRequest request) {
        return userService.me(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> index(@PathVariable("id") Long id) {
        return userService.index(id);
    }

    @PostMapping("/filter")
    public ResponseEntity<Object> filter(@RequestBody GenericRequestDTO data) {
        return userService.filter(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody UserRequestDTO data) {
        return userService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

    @PostMapping("/send-mail")
    public ResponseEntity<Object> sendMail(@RequestBody UserRequestDTO data) {
        return forgotPassword.forgotPassword(data);
    }

    @PostMapping("/verify-code")
    public ResponseEntity<Object> verifyCode(@RequestBody UserRequestDTO data) {
        return forgotPassword.verifyCode(data);
    }
}
