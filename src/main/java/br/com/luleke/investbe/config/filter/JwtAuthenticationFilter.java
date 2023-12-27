package br.com.luleke.investbe.config.filter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.luleke.investbe.config.provider.JwtTokenProvider;
import br.com.luleke.investbe.dto.UserAuthDTO;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.UserRole;
import br.com.luleke.investbe.model.respository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	private final JwtTokenProvider jwtTokenProvider;
	private final UserRepository userRepository;
		
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws  ServletException, IOException {
		String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
		if(token != null) {
			final String userId = jwtTokenProvider.extractUsername(token);
		    if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {	
		        if (jwtTokenProvider.isTokenValid(token)) {
		        	String username = jwtTokenProvider.extractUsername(token);
		        	User user = this.userRepository.findByEmail(username).orElse(null);
		        	if (null != user) {
			        	String roles = user.getRoles().stream().map(UserRole::getRoleName).collect(Collectors.joining(","));
			        	List<GrantedAuthority> roleUser = AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
			        	UserAuthDTO auth = new UserAuthDTO(user, null, roleUser);
			        	
			        	//TODO passar a pegar as roles do banco e não do token
			        	//TODO colocar qual role é permitida nos endpoints
			        	//TODO excpetion para quando o usuário não autorizado (token valido sem a devida role)
			        	//TODO exception para quando o usuário não está autenticado (token invalido)
						if (auth != null) {
							SecurityContextHolder.getContext().setAuthentication(auth);
						}
		        		
		        	}
		        }
		    }
		}
		
	    filterChain.doFilter(request, response);
	}
}
