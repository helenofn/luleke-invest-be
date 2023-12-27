package br.com.luleke.investbe.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import br.com.luleke.investbe.dto.UserAuthDTO;
import br.com.luleke.investbe.exception.AccountEmailNotFoundException;
import br.com.luleke.investbe.exception.AccountWithoutRoleException;
import br.com.luleke.investbe.exception.PasswordDoesNotMatchException;
import br.com.luleke.investbe.exception.UserOrPassNotProvidedExcpetion;
import br.com.luleke.investbe.model.User;
import br.com.luleke.investbe.model.UserRole;
import br.com.luleke.investbe.model.respository.UserRepository;
import br.com.luleke.investbe.util.GenerateHashPasswordUtil;
import br.com.luleke.investbe.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthenticationService{

	private final UserRepository userRepository;
	
	public UserAuthDTO authenticate(String email, String password) {
		
		if(!StringUtils.isEmpty(password) && !StringUtils.isEmpty(email)) {
			User user = userRepository.findByEmail(email).orElseThrow(
					()-> new AccountEmailNotFoundException());
			if(!GenerateHashPasswordUtil.isPasswordMatch(password, user.getPassword())) {
				throw new PasswordDoesNotMatchException();
			}
			List<GrantedAuthority> roles = getRoles(user);
			if(null==roles || roles.isEmpty()) {
				throw new AccountWithoutRoleException();
			}
			return new UserAuthDTO(user, password, roles);
			
		}else {
			log.error("Usuário ou senha não informados");
			throw new UserOrPassNotProvidedExcpetion();
		}
	}
	
	private List<GrantedAuthority> getRoles(User user){
		List<GrantedAuthority> lista = new ArrayList<>();
		for (UserRole role : user.getRoles()) {
			lista.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		}
		return lista;
	}
}
