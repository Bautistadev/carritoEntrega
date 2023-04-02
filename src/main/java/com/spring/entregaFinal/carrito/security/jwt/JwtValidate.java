package com.spring.entregaFinal.carrito.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtValidate {
		
    //Clave para verificar el token
    @Value("${jwt.secret}")
    private String secret;

	
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	
	//VALIDAMOS EL TOKEN
	public boolean validateToken(String token){	
        try {
        	
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token); 
            return true;
        }catch (MalformedJwtException e){
            logger.error("token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("token expirado");
        }catch (IllegalArgumentException e){
            logger.error("token vacío");
        }catch (SignatureException e){
            logger.error("fail en la firma");
        }
        return false;
    }
}
