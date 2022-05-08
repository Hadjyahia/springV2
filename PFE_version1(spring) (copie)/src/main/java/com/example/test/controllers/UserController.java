package com.example.test.controllers;

import com.example.test.Enum.TypeSang;
import com.example.test.models.AppUser;
import com.example.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() { }

    @GetMapping("/info/{email}")
    public AppUser getUserDetails(@PathVariable String email){
        //String e = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findAppUser(email).get();
    }

    @PostMapping("/update")
    public ResponseEntity<AppUser> updateUser(@RequestBody AppUser user) {
        return userService.updateAppUser(user);
    }
    @GetMapping("/users")
    public List<AppUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<AppUser> getUserById(@PathVariable("id") int userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.delete(id);
    }

    @GetMapping("/nbUsers")
    public long getNbUsers(){
        return userService.getNbUsers();
    }

    @GetMapping("/countByTypeSang/{typeSang}")
    public long countByTypeSang(@PathVariable("typeSang") String typeSang){
        return userService.countByTypeSang(typeSang);
    }
}