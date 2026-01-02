package com.attendanceserver.entities;

import com.attendanceserver.DTO.UserDTO;
import com.attendanceserver.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String email;
private String password;
private String name;

private UserRole userRole;

public UserDTO getUserDTO()
{
    UserDTO userdto = new UserDTO();
    userdto.setId(id);
    userdto.setName(name);
    userdto.setPassword(password);
    userdto.setEmail(email);
    userdto.setUserRole(userRole);

    return userdto;
}

}
