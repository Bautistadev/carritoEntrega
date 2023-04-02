package com.spring.entregaFinal.carrito.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;




@Component
public class JwtProvider {
    //Logger para mostrar los errores
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    //Clave para verificar el token
    @Value("${jwt.secret}")
    private String secret;

    //Tiempo base de expiración
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
      
        UserDetails mainUser = (UserDetails) authentication.getPrincipal();
        logger.error(mainUser.getUsername());
        //CREAMOS EL TOKEN
        return Jwts.builder().setSubject(mainUser.getUsername())//RECLAMACIONES
        .setIssuedAt(new Date())//TIEMPO DE INICIO DEL TOKEN
        .setExpiration(new Date(new Date().getTime() + expiration *1000))//EXPIRACION DEL TOKEN
        .signWith(SignatureAlgorithm.HS512, secret)//FIRMA: SETEAMOS EL SECRETO Y EL ALGORITMO DE CODIFICACION
        .compact();
    }
    //OBTENEMOS EL USUARIO MEDIANTE EL TOKEN CREADO
    public String getUserNameFromToken(String token){
    	//NECESITAMOS LA CLAVE SECRETA(archivo propertieS) Y EL TOKEN GENERADO
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    //Creamos una función que permita validar nuestro token con la firma secreta
    //Controlamos cualquier error que pueda existir con el token

    
}
