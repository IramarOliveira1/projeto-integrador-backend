package br.fvc.api.Domain.User;

import br.fvc.api.Models.User;

public class LoginResponseDTO {

    public String name;
    public String email;
    public String role;
    public String token;

    public LoginResponseDTO(User user, String token) {
        this.email = user.getEmail();
        this.name = user.getNome();
        this.role = user.getRole();
        this.token = token;
    }

}