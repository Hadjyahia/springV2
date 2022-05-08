package com.example.test.controllers;

import com.example.test.models.AppUser;
import com.example.test.request.LoginRequest;
import com.example.test.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthenticationController {


    @Autowired
    private AuthenticationService authenticationService;
    AuthenticationController() { }


        @PostMapping("/register")
        public String register (@RequestBody AppUser user){
            return authenticationService.registerAppUser(user);
        }

        @PostMapping("/login")
        public ResponseEntity<?> loginHandler (@RequestBody LoginRequest body){
            return authenticationService.loginAppUser(body);
        }

        @GetMapping("/confirm-account")
        public String confirmToken (String token){
            return authenticationService.confirmToken(token);
        }
    }
