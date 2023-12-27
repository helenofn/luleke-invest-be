package br.com.luleke.investbe.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import br.com.luleke.investbe.model.UserRole;
import br.com.luleke.investbe.model.enums.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthDTO extends UsernamePasswordAuthenticationToken{
	private static final long serialVersionUID = -7204534684207673943L;

	public UserAuthDTO(Object principal, Object credentials, Collection<GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}
	
	public final List<UserRole> getRoles() {
		List<UserRole> listaRole = new ArrayList<UserRole>();
		for (GrantedAuthority g : getAuthorities()) {
			listaRole.add(UserRoleEnum.getUserRoleByName(g.getAuthority()));
		}
		return listaRole;
	}
}
