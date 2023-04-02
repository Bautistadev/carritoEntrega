package com.spring.entregaFinal.carrito.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.entregaFinal.carrito.security.services.*;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtTokenFilter extends OncePerRequestFilter  {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(JwtTokenFilter.class);
    @Autowired
    private  JwtProvider jwtProvider;
    
    @Autowired
    private JwtValidate jwtValidate;
    
    @Autowired
    private  UserDetailsServiceImpl userDetailsServiceImpl; 
    
   // @Override
   protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException{
        try {
            String token = getToken(req); //TRAEMOS EL TOKEN DEL HEADER
            if (token != null && jwtValidate.validateToken(token)) {//VALIDAMOS EL TOKEN
                String userName = jwtProvider.getUserNameFromToken(token);//TRAEMOS EL USUARIO CORRESPONDIENTE A ESE TOKEN
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(userName);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);//AUTENTICAMOS
                
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        filterChain.doFilter(req, res);
    }


    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");//TRAEMOS LA AUTENTIFICACION DEL HEADER 
        if (header != null && header.startsWith("Bearer")) 
            return header.replace("Bearer ", ""); //LE SACAMOS LA PALABRA BEARER Y DAJEMOS SOLO EL TOKEN
        return null;
    }
    
}
