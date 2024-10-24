package org.integrador4.ps.security;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.integrador4.ps.services.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWT_Utilidades {

	@Autowired
	DefaultUserService userService;

	private final String SECRET = "Kb2N1Mg0RM1G9IAGOq6vs2sb4UU4ORFmGgqU+ewV+IPa6mVmKB2lPfGWlQAPi0ByYtYnWIQDiXb0Mz3Uf0HZTg";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Claims extractUserRole(String token) {
		return extractAllClaims(token);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET)
				.build()
				.parseSignedClaims(token)
				.getBody();
	}


	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(Authentication authentication) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, authentication);
	}



	private String createToken(Map<String, Object> claims, Authentication authentication) {
		Set<String> roles = authentication.getAuthorities().stream()
				.map(r -> r.getAuthority())
				.collect(Collectors.toSet());

		claims.put("roles", roles);  // Asegúrate de usar el mismo nombre aquí ("roles")
		claims.put("sub", authentication.getName());

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2)))
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public UsernamePasswordAuthenticationToken getAuthenticationToken(final String token,
																	  final Authentication existingAuth, final UserDetails userDetails) {

		Claims claims = extractAllClaims(token);
		Object rolesClaim = claims.get("roles");

		if (rolesClaim == null) {
			throw new IllegalArgumentException("El token no contiene roles");
		}

		final Collection<? extends GrantedAuthority> authorities = Arrays
				.stream(rolesClaim.toString().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

		return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}

}
