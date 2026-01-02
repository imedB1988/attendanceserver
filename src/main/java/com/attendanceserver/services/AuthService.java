package com.attendanceserver.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendanceserver.DTO.UserDTO;
import com.attendanceserver.entities.User;
import com.attendanceserver.enums.UserRole;
import com.attendanceserver.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
      private void CreateAdminUser()
    {
        User optionalUser = userRepository.findByUserRole(UserRole.ADMIN);
        if(optionalUser == null)
        {
            User user = new User();
            user.setName("admin");
            user.setEmail("admin@gmail.com");
            user.setUserRole(UserRole.ADMIN);
            user.setPassword("admin");

            userRepository.save(user);
            System.out.println("Admin user Created");
        }
        else
        {
            System.out.println("Admin user exists");
        }
    }

    public UserDTO Login(UserDTO userDTO)
    {
        Optional<User> dbUser = userRepository.findByEmail(userDTO.getEmail());

        if(dbUser.isPresent() && userDTO.getPassword().equals(dbUser.get().getPassword())){
            return dbUser.get().getUserDTO();
        }

        return null;
    }

}
