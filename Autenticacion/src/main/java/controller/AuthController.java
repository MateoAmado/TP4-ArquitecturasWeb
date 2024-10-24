package org.integrador4.ps.auth_service.controller;


import org.integrador4.ps.auth_service.Response;
import org.integrador4.ps.auth_service.dto.UsuarioDTO;
import org.integrador4.ps.auth_service.model.Usuario;
import org.integrador4.ps.auth_service.repository.UsuarioRepository;
import org.integrador4.ps.security.JWT_Utilidades;
import org.integrador4.ps.auth_service.Service.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import responses.ErrorResponse;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWT_Utilidades jwt_utilidad;

    @Autowired
    DefaultUserService servicio_usuario;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/registro")
    public ResponseEntity<Object> registro(@RequestBody UsuarioDTO usuario_dto) {
        Usuario usuario = this.servicio_usuario.save(usuario_dto);
        if (usuario.equals(null)) {
            ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST, "No fue posible guardar el usuario.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
        }
        Response ur = new Response(usuario);
        return ResponseEntity.ok(ur);
    }

    @PostMapping("/registro2")
    public String registro2(@RequestBody UsuarioDTO usuario_dto) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario_dto.getEmail(), usuario_dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return this.jwt_utilidad.generateToken(authentication);
    }



    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuario_dto) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario_dto.getEmail(), usuario_dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return this.jwt_utilidad.generateToken(authentication);

    }


    @PostMapping("/genToken")
    public String get_token(@RequestBody UsuarioDTO usuario_dto) throws Exception {
        System.out.println(usuario_dto);
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario_dto.getEmail(), usuario_dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return this.jwt_utilidad.generateToken(authentication);
    }

    @GetMapping("/welcomeAdmin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcome() {
        return "WelcomeAdmin";
    }

    @GetMapping("/welcomeUser")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String welcomeUser() {
        return "WelcomeUSER";
    }



}
