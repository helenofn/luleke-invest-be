package br.com.luleke.investbe.response.dto;

import br.com.luleke.investbe.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleResponseDTO {

	private Integer code;
	private String name;
	
	public RoleResponseDTO(UserRole model) {
		this.code = model.getId();
		this.name = model.getName();
	}
}
