package com.agn.auth_service.controller;

import com.agn.auth_service.model.Role;
import com.agn.auth_service.model.User;
import com.agn.auth_service.payload.LoginRequest;
import com.agn.auth_service.payload.ResponsePayload;
import com.agn.auth_service.service.AuthService;
import com.agn.auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(new ResponsePayload( authService.authenticate(loginRequest)));
    }


    @GetMapping("/save")
    public void save(){

        User user = new User();

        user.setId(null);
        user.setName("Agnaldo");
        user.setLastName("Junior");
        user.setEmail("agnaldo@gmail.com");
        user.setPassword(passwordEncoder.encode("5544690"));
        user.setRole(Role.ADMIN);
        user.setUsername("agnaldo88");


        userService.save(user);

        log.info("User saved");

    }
}
