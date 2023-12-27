package br.com.luleke.investbe.config.provider;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.luleke.investbe.util.DateTimeUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Component
@Log4j2
public class JwtTokenProvider {
private static final String ROLES = "roles";
	
	@Value("${security.jwt.token.secret-key}")
	private String secretKey;
	@Value("${security.jwt.token.expire-lenth}")
	private String expereTime;
	
	private Key getSignInKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }
	
	public String createToken(String username, Collection<? extends GrantedAuthority> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		
		String strRoles = roles.stream().map(role -> new String(role.getAuthority())).collect(Collectors.joining(","));
		// TODO remover roles do token e buscar no banco em todo acesso
		claims.put(ROLES, strRoles);
		//claims.put(ROLES, AuthorityUtils.createAuthorityList(strRoles));
		//claims.put(ROLES, roles);
				
		Date valid = DateTimeUtil.getNowSumTimeDate(Long.valueOf(expereTime));
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(DateTimeUtil.getNowDate())
				.setExpiration(valid)
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public String resolveToken(HttpServletRequest req) {
		String bearer = req.getHeader("authorization");
		if(null!=bearer && bearer.startsWith("Bearer ")) {
			return bearer.substring(7,bearer.length());
		}
		return null;
	}
	
	public boolean isTokenValid(String token) {
        return !isTokenExpired(token);
    }
	
	public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
	
	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
	
	private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
	
	private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
	
	private Claims extractAllClaims(String token)  {
		try {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
		}catch(JwtException e) {
			log.error("Token inválido.", e);
			throw new RuntimeException(e);
		}

    }
	
	/*
	public Authentication getAuthentication(String token) {
		String userName = extractUsername(token);
		User user = userRepository.findByEmail(userName).orElse(null);
		return new UserAuthDTO(user, null, getRoles(token));
	}
	*/
	
	/*
	public Collection<GrantedAuthority> getRoles(String token){
		Claims claims = extractAllClaims(token);
		List<GrantedAuthority> roleUser = AuthorityUtils.commaSeparatedStringToAuthorityList(claims.get(ROLES).toString());
		return roleUser;
	}*/
}
