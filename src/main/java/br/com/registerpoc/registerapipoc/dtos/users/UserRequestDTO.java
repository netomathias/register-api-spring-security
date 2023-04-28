package br.com.registerpoc.registerapipoc.dtos.users;

import br.com.registerpoc.registerapipoc.entities.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String name;
    private String email;
    private String password;
    private RoleEnum role;
}
