package com.spring.entregaFinal.carrito.security.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.spring.entregaFinal.carrito.Entity.*;
import com.spring.entregaFinal.carrito.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
	
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
    public boolean existByUserName(String userName){
        return userRepository.existsByUserName(userName);
    }
    public void save(User user){
        userRepository.save(user);
    }
    
    public void bajar(User user){
       	
    	user.setFechaBaja(LocalDateTime.now().toString());
    	user.setPassword(userRepository.findByUserName(user.getUserName()).get().getPassword());
    	
        userRepository.save(user);
    }
    
    public List<User> getAllUsers(){
    	return userRepository.findAll();
    }
  
    public List<User> findPalabraClave(String palabra){
    	return userRepository.findPalabraClave(palabra);
    }
    
}
