package br.com.registerpoc.registerapipoc.services;

import br.com.registerpoc.registerapipoc.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity save(UserEntity userEntity);
    UserEntity update(Long id, UserEntity userEntity);
    List<UserEntity> getAll();
    UserEntity getById(Long id);
    void deleteById(Long id);
}
