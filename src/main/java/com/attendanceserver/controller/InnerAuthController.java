package com.attendanceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceserver.DTO.UserDTO;
import com.attendanceserver.services.AuthService;

@RestController
@RequestMapping("api/auth")
@CrossOrigin("*")
public class InnerAuthController {

    @Autowired
    private AuthService authService;

@PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody UserDTO userDTO)
    {
        UserDTO dbUser = authService.Login(userDTO);

        if(dbUser == null)
        {
            return new ResponseEntity<>("Email ou mot de passe incorrects", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Email et mot de passe acceptés", HttpStatus.OK);
    }
    
}




