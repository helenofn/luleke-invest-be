package br.com.luleke.investbe.model.enums;

import br.com.luleke.investbe.model.UserRole;
import lombok.Getter;

@Getter
public enum UserRoleEnum {

	PUBLIC(1, "PUBLIC"),
	COMMON(2, "COMMON"),
	REGISTER(3, "REGISTER"),
	ANALYST(4, "ANALYST");
	
	private Integer id;
	private String name;
	
	private UserRoleEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public UserRole getModel() {
		UserRole role = new UserRole();
		role.setId(this.id);
		role.setName(this.name);
		return role;
	}
	
	public static UserRole getUserRoleByName(String userRoleName) {
		for (UserRoleEnum item : UserRoleEnum.values()) {
			if(item.getName().equalsIgnoreCase(userRoleName)) {
				return item.getModel();
			}
		}
		return null;
	}
}
