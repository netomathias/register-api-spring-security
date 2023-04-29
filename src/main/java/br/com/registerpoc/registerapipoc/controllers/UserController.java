package br.com.registerpoc.registerapipoc.controllers;

import br.com.registerpoc.registerapipoc.dtos.users.UserResponseDTO;
import br.com.registerpoc.registerapipoc.facades.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserFacade userFacade;

    @Secured("ADMIN")
    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userFacade.getAll();
    }
}
