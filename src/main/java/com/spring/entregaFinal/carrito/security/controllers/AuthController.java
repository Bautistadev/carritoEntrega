package com.spring.entregaFinal.carrito.security.controllers;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import com.spring.entregaFinal.carrito.security.dtos.*;
import com.spring.entregaFinal.carrito.security.jwt.JwtProvider;
import com.spring.entregaFinal.carrito.security.jwt.JwtValidate;
import com.spring.entregaFinal.carrito.Entity.*;
import com.spring.entregaFinal.carrito.security.services.*;

import lombok.val;

import com.spring.entregaFinal.carrito.enums.*;
import com.spring.entregaFinal.carrito.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RoleService roleService;
    private final JwtProvider jwtProvider;
    private final JwtValidate jwtValidate;
    
    @Autowired
    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, PasswordEncoder passwordEncoder,
            UserService userService, RoleService roleService, JwtProvider jwtProvider, JwtValidate jwtValidate) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.roleService = roleService;
        this.jwtProvider = jwtProvider;
        this.jwtValidate = jwtValidate;
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDTO loginUser, BindingResult bidBindingResult){
        if(bidBindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
        try {
                UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword());
                Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtProvider.generateToken(authentication);
                TokenDTO jwtDto = new TokenDTO(jwt);
                return new ResponseEntity<>(jwtDto, HttpStatus.OK);
        } catch (Exception e) {
                return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<Object> resgister(@Valid @RequestBody UserDTO newUser, BindingResult bindingResult) {
        
    	
    	if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST);
        User user = new User(
        		newUser.getUserName(), 
        		newUser.getNombre(),
        		newUser.getApellido(),
        		newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword()),
                LocalDateTime.now().toString()
        		);
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleList.ROLE_USER).get());
        if (newUser.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleList.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new Message("Registro exitoso! Inicie sesión"), HttpStatus.CREATED);
    }
    
    //DEBE ESTAR AUTORIZADO COMO ADMINISTRADOR PARA PODER VER EL CONTENIDO
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
    	System.out.println(userService.getAllUsers());
    	return userService.getAllUsers();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/allRoles")
    public List<Role> getAllRoles(){
    	System.out.println(userService.getAllUsers());
    	return roleService.getAllRoles();
    }
    
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/getUser")
    public Optional<User>getUserByUserName(@Valid @RequestBody String userNamer){
    	return userService.getByUserName(userNamer);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/bajar")
    public ResponseEntity<Object>bajar(@Valid @RequestBody User user){
    
    	userService.bajar(user);
    	
    	return new ResponseEntity<>(new Message("Usuario dado de baja"), HttpStatus.CREATED);
    }
    
    @PostMapping("/validateToken")
    public boolean isValid(@Valid @RequestBody String token) {
    	return jwtValidate.validateToken(token);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/buscarPalabraClave")
    public List<User>getListPalabraClave(@Valid @RequestBody String palabraClave){
    	return userService.findPalabraClave(palabraClave);
    }
}
