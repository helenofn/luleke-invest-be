package br.com.luleke.investbe.response.dto;

import br.com.luleke.investbe.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpResponseDTO extends ReturnDTO {

	private Long id;
	private String name;
	private String email;
	
	public UserSignUpResponseDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}
}
