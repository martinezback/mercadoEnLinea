package com.softlond.mercadoEnLinea.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody LoguinRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping(value = "accesAdmin")
    public ResponseEntity<String> register()
    {
        return ResponseEntity.ok("controller admin");
    }

    @PostMapping(value= "test")
    public ResponseEntity<String> create(@RequestParam String name){
        return ResponseEntity.ok("tu nombre es "+ name);
    }
}
