package com.softlond.mercadoEnLinea.Auth;

import com.softlond.mercadoEnLinea.security.jwt.JwtService;
import com.softlond.mercadoEnLinea.user.ERole;
import com.softlond.mercadoEnLinea.user.RoleEntity;
import com.softlond.mercadoEnLinea.user.UserEntity;
import com.softlond.mercadoEnLinea.user.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository iUserRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public String register(RegisterRequest request) {
        Set<RoleEntity> roles = request.getRoles().stream()
                .map(role-> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity user = UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .roles(roles)
                .build();
        iUserRepository.save(user);

        return jwtService.generateAccesToken(user.getEmail());
    }

    public String login(LoguinRequest loguinRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loguinRequest.getEmail(),loguinRequest.getPassword()));
        Optional<UserEntity> user= iUserRepository.findByEmail(loguinRequest.getEmail());
        if(user.isPresent()){
            return jwtService.generateAccesToken(user.get().getEmail());
        }else{
            throw new EntityNotFoundException("El usuario no existe en base de datos");
        }

    }
}
