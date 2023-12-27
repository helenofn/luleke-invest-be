package br.com.luleke.investbe.response.dto;

import java.util.List;

import br.com.luleke.investbe.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponseDTO extends ReturnDTO{

	private Long id;
	private String name;
	private String email;
	private List<RoleResponseDTO> roles;
	
	public UserLoginResponseDTO(User model) {
		this.id = model.getId();
		this.email = model.getEmail();
		this.name = model.getName();
		this.roles = model.getRoles().stream().map(item -> new RoleResponseDTO(item)).toList();
	}
}
