package br.com.registerpoc.registerapipoc.services.impl;

import br.com.registerpoc.registerapipoc.dtos.auth.LoginRequestDTO;
import br.com.registerpoc.registerapipoc.dtos.auth.LoginResponseDTO;
import br.com.registerpoc.registerapipoc.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponseDTO authenticate(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));

        var user = userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return LoginResponseDTO.builder()
                .token(jwtToken)
                .build();
    }


}
