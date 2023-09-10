package br.com.luleke.investbe.model.enums;

import br.com.luleke.investbe.model.UserRole;
import lombok.Getter;

@Getter
public enum UserRoleEnum {

	PUBLIC(1, "Publico"),
	COMMON(2, "Comum"),
	REGISTER(3, "Cadastro"),
	ANALYST(4, "Analista");
	
	private Integer id;
	private String name;
	
	private UserRoleEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public UserRole getModel() {
		UserRole role = new UserRole();
		role.setCode(this.id);
		role.setName(this.name);
		return role;
	}
}
