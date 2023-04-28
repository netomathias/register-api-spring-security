package br.com.registerpoc.registerapipoc.services.impl;

import br.com.registerpoc.registerapipoc.entities.UserEntity;
import br.com.registerpoc.registerapipoc.repositories.UserRepository;
import br.com.registerpoc.registerapipoc.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity save(UserEntity userEntity) {
        log.info("saving new user - {}", userEntity);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(Long id, UserEntity userEntity) {
        log.info("updating user - {}", userEntity);
        userEntity.setId(id);
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    @SneakyThrows
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new Exception("user already exists"));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
