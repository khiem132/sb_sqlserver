package sop.utils;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.*;

public class JwtUtility {
	public String generateToken() {		
		String token = Jwts.builder().compact();
		return token;
	}
}
